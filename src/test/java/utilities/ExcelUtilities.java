package utilities;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public FileInputStream file;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	public String path;

	public ExcelUtilities(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowNum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		file.close();
		return cellCount;
	}

	public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String data;
		DataFormatter formatter = new DataFormatter();
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		file.close();
		return data;
	}

	public void setCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File xlfile = new File(path);
		if (!xlfile.exists()) // If file not exists then create new file
		{
			workbook = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workbook.write(fos);
		}

		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);

		if (workbook.getSheetIndex(sheetName) == -1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rowNum) == null) // If row not exists then create new Row
			sheet.createRow(rowNum);
		row = sheet.getRow(rowNum);

		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		file.close();
		fos.close();
	}

	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workbook.write(fos);
		workbook.close();
		file.close();
		fos.close();
	}

	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workbook.write(fos);
		workbook.close();
		file.close();
		fos.close();
	}
}
