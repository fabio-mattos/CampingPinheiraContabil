package performer.contabil.viewcontroller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class GeraPDFViaCodigo {

	/*
	 * criação do objeto documento Document document = new Document(); try {
	 * PdfWriter.getInstance(document, new
	 * FileOutputStream("C://123//PDF_LinhaCodigo.pdf")); document.open();
	 * 
	 * Image logo = Image.getInstance(
	 * "C://Performer//Fapeu//SAL//trunk//war//images//logoRel.png");
	 * 
	 * logo.setWidt
	 * 
	 * 
	 * PdfPTable table = new PdfPTable(2); table.setWidthPercentage(100);
	 * table.addCell(createImageCell(logo));
	 * table.addCell("FAPEU /n LINHA2 /n LINHA3");
	 * 
	 * document.add(table);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * document.add(new
	 * Paragraph("Exemplo Geração de Arquivo PDF via iText - Java"));
	 * document.add(new Paragraph("Linha2"));
	 * 
	 * 
	 * 
	 * 
	 * } catch (DocumentException de) { System.err.println(de.getMessage()); }
	 * catch (IOException ioe) { System.err.println(ioe.getMessage()); }
	 * document.close();
	 */

	public void criaPDF() {
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream("C://123//PDF_LinhaCodigo.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.open();
		PdfPTable table = new PdfPTable(2);

		try {
			table.setWidths(new int[] { 2, 9 });
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Image img = null;
		try {
			img = Image.getInstance("C://Performer//Fapeu//SAL//trunk//war//images//logoRel.png");
		} catch (BadElementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		table.addCell(new PdfPCell(img, true));
		table.addCell(new Phrase("Linha1"));
		table.addCell(new Phrase("Linha2"));
		try {
			document.add(table);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			document.add(new Paragraph("Exemplo Geração de Arquivo PDF via iText - Java"));
			document.add(new Paragraph("Linha2"));
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		document.close();

	}

}
