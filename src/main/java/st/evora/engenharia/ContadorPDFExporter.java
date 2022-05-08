package st.evora.engenharia;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import st.evora.engenharia.model.Cliente;
import st.evora.engenharia.model.Contador;

public class ContadorPDFExporter {

	private List<Contador> listContadores;
	private List<Cliente> listClientes;

	public ContadorPDFExporter(List<Contador> listContadores) {
		super();
		this.listContadores = listContadores;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.orange);
		cell.setPadding(6);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.black);

		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Conta", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Nº Contador", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Leit.Anterior", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Nova Leit", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Ampe", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Ramal", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Cliente", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for (Contador contador : listContadores) {
			table.addCell(String.valueOf(contador.getIdcontador()));
			table.addCell(contador.getConta_numero());
			table.addCell(contador.getNumero_contador());
			table.addCell(String.valueOf(contador.getLeitura_anterior()));
			table.addCell(String.valueOf(contador.getNova_leitura())) ;
			table.addCell(contador.getAmperagem());
			table.addCell(contador.getRamal());
			table.addCell(String.valueOf(contador.getCliente()));
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.darkGray);

		Paragraph p = new Paragraph("Lista de Contadores", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		// table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
