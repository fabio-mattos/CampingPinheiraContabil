package performer.contabil.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.performer.faces.download.IPeFileDownloader;
import com.performer.faces.download.IPeOutputWriter;
import com.performer.faces.download.PeOutputWriterManager;

public abstract class ReportManager {

	class OutputWriterException implements IPeOutputWriter {

    	Exception _ex;
    	
    	public OutputWriterException(Exception ex) {
    		_ex = ex;
    	}
    	
		@Override
		public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
	        out.println("<head>");
	        out.println("</head>");
	        out.println("<body bgcolor=\"white\">");
	        out.println("<b>A tentativa de gerar o relatório provocou o seguinte erro:</b>");
	        out.println("<pre>");
	        _ex.printStackTrace(out);
	        out.println("</pre>");
	        out.println("</body>");
	        out.println("</html>");
		}

		@Override
		public String mimeType() {
			return PeOutputWriterManager.getMimeType("html");
		}

	}
    
    class OutputWriterReport implements IPeOutputWriter {

    	byte[] _bytes;
    	
    	public OutputWriterReport(byte[] bytes) {
    		_bytes = bytes;
    	}
    	
		@Override
		public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			response.setContentLength(_bytes.length);
	        ServletOutputStream ouputStream = response.getOutputStream();
	        ouputStream.write(_bytes, 0, _bytes.length);
	        
		}

		@Override
		public String mimeType() {
			return PeOutputWriterManager.getMimeType("pdf");
		}

	}
    
    class OutputWriterXLS implements IPeFileDownloader {

    	String _fileName;
    	byte[] _bytes;
    	
    	public OutputWriterXLS(String fileName, byte[] bytes) {
    		_fileName = fileName;
    		_bytes = bytes;
    	}
    	
		@Override
		public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
			ServletOutputStream out = response.getOutputStream();
			response.setContentLength(_bytes.length);
	        out.write(_bytes, 0, _bytes.length);
		}

		@Override
		public String mimeType() {
			return PeOutputWriterManager.getMimeType("xls");
		}

		@Override
		public String fileName() {
			return _fileName;
		}

		@Override
		public long fileSize() {
			return _bytes.length;
		}

	}
    
    class OutputWriterBlank implements IPeOutputWriter {

		@Override
		public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
			 
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Visualizando relat�rio...</title>");
	        out.println("<style type=\"text/css\">");
	        out.println(".style1 {");
	        out.println("  font-family: Verdana, Arial, Helvetica, sans-serif; font-weight: bold;");
	        out.println("}");
	        out.println("</style>");        
	        out.println("</head>");
	        out.println("<body bgcolor='white'>");
	        out.println("<form name='form' >");
	        out.println("	<span class=\"style1\">Relatório sem dados para o(s) critério(s) da consulta informado(s)!</span>");
	        out.println("</form>");
	        out.println("</body>");
	        out.println("</html>");
	        
	         
			 
		}

		@Override
		public String mimeType() {
			return PeOutputWriterManager.getMimeType("text/html");
		}

	}
	
}
