package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData {

	public static String[][] getData(String filename) throws IOException {
		// Open File
		XSSFWorkbook book = new XSSFWorkbook("./testData/"+filename+".xlsx");
		// Go to the Sheet
		XSSFSheet sheet = book.getSheetAt(0);
		// Find No of Rows
		int rowCount = sheet.getLastRowNum();
		
		// Find the Col
		short colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell eachCell = eachRow.getCell(j);
				String value = eachCell.getStringCellValue();
				data[i-1][j]=value;
			}

		}

		book.close();
return data;
	}

}
