package br.com.rafaelpf.rfprod.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.rafaelpf.rfprod.model.OrdemProducao;

public class OrdemProducaoExcelGenerator {

	private List<OrdemProducao> ordensProducao;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public OrdemProducaoExcelGenerator(List<OrdemProducao> ordensProducao) {
		this.ordensProducao = ordensProducao;
		workbook = new XSSFWorkbook();
	}

	private void writeHeader() {
		sheet = workbook.createSheet("Ordem de Produção");
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		createCell(row, 0, "ID", style);
		createCell(row, 1, "Data de Criação", style);
		createCell(row, 2, "Data Inicial", style);
		createCell(row, 3, "Data Final", style);
		createCell(row, 4, "Status", style);
	}

	private void createCell(Row row, int columnCount, Object cellValue, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");

		if (cellValue instanceof Date) {
			cell.setCellValue(formatter.format(cellValue));
		} else if (cellValue instanceof Long) {
			cell.setCellValue((Long) cellValue);
		} else if (cellValue instanceof String) {
			cell.setCellValue((String) cellValue);
		}

		cell.setCellStyle(style);
	}

	private void write() {
		int rowCount = 1;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		for (OrdemProducao record: ordensProducao) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCell(row, columnCount++, record.getId(), style);
			createCell(row, columnCount++, record.getDataCriacao(), style);
			createCell(row, columnCount++, record.getDataInicio(), style);
			createCell(row, columnCount++, record.getDataFim(), style);
			createCell(row, columnCount++, record.getStatus(), style);
		}
	}

	public void generateExcelFile(HttpServletResponse response) throws IOException {
		writeHeader();
		write();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}

}
