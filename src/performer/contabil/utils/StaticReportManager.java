package performer.contabil.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import com.performer.faces.PeFacesApplication;
import com.performer.faces.PeMessages;
import com.salmonllc.sql.DBConnection;


public class StaticReportManager extends ReportManager {

	/**
	 * Gera visualizacao em PDF para um determinado relatorio pre-compilado.
	 * 
	 * @param reportName nome do arquivo compilado (.jasper) sem a sua extensao
	 * @param params map de parametros que o relatorio utiliza
	 * @throws IllegalArgumentException se reportName for null ou vazio e/ou se params for null 
	 */
	public void generateReport(String reportName, Map<String, Object> params) {
		
		this.generateReport(reportName, params, "empty");
		
	}
	
	/**
	 * Gera visualizacao em PDF para um determinado relatorio pre-compilado 
	 * especificado uma colecao de beans que representam seus dados.
	 * 
	 * @param reportName nome do arquivo compilado (.jasper) sem a sua extensao
	 * @param params map de parametros que o relatorio utiliza
	 * @param coll colecao de beans que representam os dados do relatorio
	 * @throws IllegalArgumentException se "reportName" for null ou vazio 
	 * 		  e/ou se "params" for null e/ou se "coll" for null 
	 */
	public void generateReport(String reportName, Map<String, Object> params, Collection<? extends Serializable> coll) {
		
		if (reportName == null || "".equals(reportName) || params == null || coll == null)
			throw new IllegalArgumentException(
					"Parameter invalid : reportName=" + reportName + 
					", params=" + params +
					", coll=" + coll);
		
		this.sendPDFReportByBean(reportName, params, coll);
		
	}
	
	/**
	 * Gera visualizacao em PDF para um determinado relatorio pre-compilado 
	 * especificado a sua query de busca de dados.
	 * 
	 * @param reportName nome do arquivo compilado (.jasper) sem a sua extensao
	 * @param params map de parametros que o relatorio utiliza
	 * @param query consulta sql que o relatorio utiliza para recuperar suas informacoes
	 * @throws IllegalArgumentException se "reportName" for null ou vazio 
	 * 		  e/ou se "params" for null e/ou se "query" for null 
	 */
	public void generateReport(String reportName, Map<String, Object> params, String query) {
		
		if (reportName == null || "".equals(reportName) || params == null || query == null)
			throw new IllegalArgumentException(
					"Parameter invalid : reportName=" + reportName + 
					", params=" + params +
					", query=" + query);
        
    	DBConnection dbconn = null;
        try {
        	
        	PeFacesApplication app = PeFacesApplication.getInstance();
        	dbconn = DBConnection.getConnection(app.getName());
            
            String reportPath = Utils.getReportPath();
            String completeReportPath = reportPath + reportName + ".jasper"; 
            
            this.sendPDFReportByDataBase(completeReportPath, params, dbconn, query);
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (dbconn != null) dbconn.freeConnection();
        }
    
    }
	
 
public void generateReport(String reportName, Map<String, Object> params, String query, String banco) {
		
	if (reportName == null || "".equals(reportName) || params == null || query == null)
		throw new IllegalArgumentException(
				"Parameter invalid : reportName=" + reportName + 
				", params=" + params +
				", query=" + query);
    
	DBConnection dbconn = null;
    try {
    	
    	PeFacesApplication app = PeFacesApplication.getInstance();
    	dbconn = DBConnection.getConnection(app.getName(),banco);
        
        
        String reportPath = Utils.getReportPath();
        String completeReportPath = reportPath + reportName + ".jasper"; 
        
        this.sendPDFReportByDataBase(completeReportPath, params, dbconn, query);
        
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        if (dbconn != null) dbconn.freeConnection();
    }
    
    }
	
	

    private void sendPDFReportByDataBase(String completeReportPath, Map<String, Object> params, 
    		DBConnection dbconn, String query) throws Exception {
    	
        Connection conn = null;
        byte[] bytes = null;
        
        try {
            conn = dbconn.getJDBCConnection();
            
            if ("empty".equals(query)) {
            	bytes = JasperRunManager.runReportToPdf(completeReportPath, params, conn);
            } else {
            	bytes = this.getReportBytesWithQuery(completeReportPath, params, conn, query);
            }
        } catch (JRException e) {
        	
        	PeFacesApplication.getInstance().openWindow(new OutputWriterException(e), 800, 600, false, true);
			return;
			
        } finally {
        	if (conn != null) conn.close();
        }
        
        if (bytes != null && bytes.length > 1000) {
        	PeFacesApplication.getInstance().openWindow(new OutputWriterReport(bytes), 800, 600, false, true);
        } else {
        	//PeFacesApplication.getInstance().openWindow(new OutputWriterBlank(), 800, 600, false, true);
        	PeMessages.showDialog("Atenção", "Relatório sem dados para o(s) critério(s) da consulta informado(s)!", PeMessages.Icon.WARNING);
        }
        
    }
    
    
    
     
    
    
    
    
    
    
    private byte[] getReportBytesWithQuery(String reportPath, 
    		Map<String, Object> params, Connection conn, String query) throws SQLException, JRException {
    	
    	byte[] bytes = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try {
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		
    		JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
    		bytes = JasperRunManager.runReportToPdf(reportPath, params, jrRs);
    	} finally {
    		if (rs != null) rs.close();
    		if (ps != null) ps.close();
    	}
    	
		return bytes;
		
	}
    
    private void sendPDFReportByBean(String reportName, 
    		Map<String, Object> params, 
    		Collection<? extends Serializable> coll) {
    	
    	String reportPath = Utils.getReportPath();
        String completeReportPath = reportPath + reportName + ".jasper";
        
   
    	
        
    	byte[] bytes = null;
		JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(coll, false);
		
		try {
			bytes = JasperRunManager.runReportToPdf(completeReportPath, params, jrBean);
		} catch (JRException ex) {
			ex.printStackTrace();
			PeFacesApplication.getInstance().openWindow(
					new OutputWriterException(ex), 800, 600, false, true);
		}
		
		PeFacesApplication.getInstance().openWindow(
				new OutputWriterReport(bytes), 800, 600, false, true);
    	
	}
    
    public void generateXLS(String reportName, Map<String, Object> params) {
    	this.generateXLS(reportName, params, "empty");
    }
    
    public void generateXLS(String reportName, Map<String, Object> params, String query) {
		
		if (reportName == null || "".equals(reportName) || params == null || query == null)
			throw new IllegalArgumentException(
					"Parameter invalid : reportName=" + reportName + 
					", params=" + params +
					", query=" + query);
        
    	DBConnection dbconn = null;
        try {
        	PeFacesApplication app = PeFacesApplication.getInstance();
        	dbconn = DBConnection.getConnection(app.getName());
            
            String reportPath = Utils.getReportPath();
            String completeReportPath = reportPath + reportName + ".jasper"; 
            
            this.sendXLSReportByDataBase(reportName, completeReportPath, params, dbconn, query);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (dbconn != null) dbconn.freeConnection();
        }
    
    }
    
public void generateXLS(String reportName, Map<String, Object> params, String query, String banco) {
		
	if (reportName == null || "".equals(reportName) || params == null || query == null)
		throw new IllegalArgumentException(
				"Parameter invalid : reportName=" + reportName + 
				", params=" + params +
				", query=" + query);
    
	DBConnection dbconn = null;
    try {
    	PeFacesApplication app = PeFacesApplication.getInstance();
    	dbconn = DBConnection.getConnection(app.getName(),banco);
        
        String reportPath = Utils.getReportPath();
        String completeReportPath = reportPath + reportName + ".jasper"; 
        
        this.sendXLSReportByDataBase(reportName, completeReportPath, params, dbconn, query);
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        if (dbconn != null) dbconn.freeConnection();
    }
    
    }
    
    
    
    
    private void sendXLSReportByDataBase(String reportName, String completeReportPath, Map<String, Object> params, 
    		DBConnection dbconn, String query) throws Exception {
    	
    	Connection conn = null;
        byte[] bytes = null;
        try {
        	reportName = reportName + ".xls";
            conn = dbconn.getJDBCConnection();
            
            if ("empty".equals(query)) {
            	bytes = this.getXLSBytes(reportName, completeReportPath, params, conn);
            } else {
            	bytes = this.getXLSBytesWithQuery(reportName, completeReportPath, params, conn, query);
            }
        } catch (Exception ex) {
        	PeFacesApplication.getInstance().openWindow(new OutputWriterException(ex), 800, 600, false, true);
			return;
        } finally {
        	if (conn != null) conn.close();
        }
        
        if (bytes != null && bytes.length > 1000) {
        	PeFacesApplication.getInstance().downloadFile(new OutputWriterXLS(reportName, bytes));
        } else {
        	PeMessages.showDialog("Atenção", "Relatório sem dados para o(s) critério(s) da consulta informado(s)!", PeMessages.Icon.WARNING);
        	
        	//PeFacesApplication.getInstance().openWindow(new OutputWriterBlank(), 800, 600, false, true);
        }
    }
    
	private byte[] getXLSBytes(String reportName, String completeReportPath, 
    		Map<String, Object> params, Connection conn) throws Exception {
    	
    	JasperPrint print = JasperFillManager.fillReport(completeReportPath, params, conn);
    	byte[] bytes = this.exportXLSBytes(print);
    	
    	File xlsFile = PeFacesApplication.getInstance().getRealPath("/output/" + reportName);
        OutputStream outputfile = new FileOutputStream(xlsFile);
        outputfile.write(bytes);
         
        return bytes;
    }
	
	private byte[] getXLSBytesWithQuery(String reportName, String completeReportPath,
			Map<String, Object> params, Connection conn, String query) throws Exception {
		byte[] bytes = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
    		ps = conn.prepareStatement(query);
    		rs = ps.executeQuery();
    		JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
    		
    		JasperPrint print = JasperFillManager.fillReport(completeReportPath, params, jrRs);
    		bytes = this.exportXLSBytes(print);
    		
    		File xlsFile = PeFacesApplication.getInstance().getRealPath("/output/" + reportName);
            OutputStream outputfile = new FileOutputStream(xlsFile);
            outputfile.write(bytes);
    	} finally {
    		if (rs != null) rs.close();
    		if (ps != null) ps.close();
    	}
		return bytes;
	}
	
	private byte[] exportXLSBytes(JasperPrint print) throws Exception {
		ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
		
        JRXlsExporter exporterXLS = new JRXlsExporter();
        exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
        exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, outputByteArray);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
        exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
        exporterXLS.exportReport();
        
        return outputByteArray.toByteArray();
	}
	
	public void generateXLS(String reportName, Map<String, Object> params, 
			Collection<? extends Serializable> coll) {
		
		if (reportName == null || "".equals(reportName) || params == null || coll == null)
			throw new IllegalArgumentException(
					"Parameter invalid : reportName=" + reportName + 
					", params=" + params +
					", coll=" + coll);
		
		byte[] bytes = null;
		try {
			String reportPath = Utils.getReportPath();
			String completeReportPath = reportPath + reportName + ".jasper";
			reportName = reportName + ".xls";
			
			bytes = this.getXLSByBean(reportName, completeReportPath, params, coll);
		} catch (Exception ex) {
			ex.printStackTrace();
			PeFacesApplication.getInstance().openWindow(new OutputWriterException(ex), 800, 600, false, true);
		}
		
		if (bytes != null && bytes.length > 1000) {
        	PeFacesApplication.getInstance().downloadFile(new OutputWriterXLS(reportName, bytes));
        } else {
        	PeMessages.showDialog("Erro", "Relatório sem dados para o(s) critério(s) da consulta informado(s)!", PeMessages.Icon.WARNING);
        	
        	//PeFacesApplication.getInstance().openWindow(new OutputWriterBlank(), 800, 600, false, true);
        }
	}
	
	private byte[] getXLSByBean(String reportName, String completeReportPath, 
    		Map<String, Object> params, 
    		Collection<? extends Serializable> coll) throws Exception {
    	
		byte[] bytes = null;
		JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(coll, false);
		
		JasperPrint print = JasperFillManager.fillReport(completeReportPath, params, jrBean);
		bytes = this.exportXLSBytes(print);
		
		File xlsFile = PeFacesApplication.getInstance().getRealPath("/output/" + reportName);
        OutputStream outputfile = new FileOutputStream(xlsFile);
        outputfile.write(bytes);
            
		return bytes;
	}
    
}
