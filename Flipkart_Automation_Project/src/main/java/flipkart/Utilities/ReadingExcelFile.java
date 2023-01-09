package flipkart.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelFile {

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public ReadingExcelFile() {

		try {

			File file = new File("./Resources/testdata.xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet("testdata");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int RowCount() {
		int rowTotal = sheet.getLastRowNum() + 1;
		return rowTotal;
	}

	// This method will read and provide accessing of data from excel sheet
	public String getCellData(int row, int col) {

		String value = "";

		Object type = sheet.getRow(row).getCell(col).getCellType();

		if (type == CellType.NUMERIC) {

			value = NumberToTextConverter.toText(sheet.getRow(row).getCell(col).getNumericCellValue());
		}

		if (type == CellType.STRING) {

			value = sheet.getRow(row).getCell(col).getStringCellValue();
		}
		return value;
	}
}