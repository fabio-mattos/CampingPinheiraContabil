package performer.contabil.utils;



import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import com.performer.faces.PeFacesApplication;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.LayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class DynamicReportManager extends ReportManager {

	private JasperPrint jp;
	private DynamicReport dr;
	private JRDataSource ds;
	private LayoutManager lm;
	

	public DynamicReportManager(
			DynamicReport dr, JRDataSource ds, LayoutManager lm) {
		
		this.dr = dr;
		this.ds = ds;
		this.lm = lm;
		
	}
	
	public void generateReport(String output) throws JRException, ColumnBuilderException, ClassNotFoundException, FileNotFoundException
	{
		if ((dr != null) && (lm != null) && (ds != null))
		{
			jp = DynamicJasperHelper.generateJasperPrint(dr, lm, ds);
			JRAbstractExporter exporter = null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
			if ("PDF".equals(output))
				exporter = new JRPdfExporter();
			
			if ("XLS".equals(output))
			{
				exporter = new JRXlsExporter();
	            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
	            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
			}

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
            exporter.exportReport();

            byte[] bytes = baos.toByteArray();
            
            if (bytes != null && bytes.length > 1000)
            {
            	if ("XLS".equals(output))
            		PeFacesApplication.getInstance().downloadFile(new OutputWriterXLS("c:\\temp\\Listagem.xls", bytes));
            	
            	if ("PDF".equals(output))
            		PeFacesApplication.getInstance().openWindow(new OutputWriterReport(bytes), 800, 600, false, true);
            } else {
            	PeFacesApplication.getInstance().openWindow(new OutputWriterBlank(), 800, 600, false, true);
            }
		}
	}
}
