package Marathon4;

import java.io.IOException;

import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData extends BaseClass{
	
	public static String[][] setData(String filename,String sheetname) throws IOException
	{
	
	XSSFWorkbook book = new XSSFWorkbook("./testdata/"+filename+".xlsx");
	XSSFSheet sheet = book.getSheet(sheetname);
	
	short colCount = sheet.getRow(0).getLastCellNum();
	
    int rowCount = sheet.getLastRowNum();
    
    System.out.println("Row Count"+rowCount);
    System.out.println("Col Count" +colCount);
    
    String[][] data =new String[rowCount][colCount];
    
    
    for(int i=1;i<=rowCount; i++)
    {
    	XSSFRow eachrow = sheet.getRow(i);
    	
    	for(int j=0;j<colCount;j++)
    	{
	       data[i-1][j]= eachrow.getCell(j).getStringCellValue();
	
	System.out.println(data[i-1][j]);
	}}
    book.close();
    return data;
	}
}
