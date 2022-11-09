package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSalesforce {

	public static String[][] readExceldata(String fileName) throws IOException {
		
		XSSFWorkbook book =new XSSFWorkbook("./testData-Salesforce/"+fileName+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data =new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow eachrow = sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				XSSFCell eachcell = eachrow.getCell(j);
				
				String value = eachcell.getStringCellValue();
				data[i-1][j]=value;
				
			}
			
		
			
		}
		
		
		book.close();
		return data;

	}

}
