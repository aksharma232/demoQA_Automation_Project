package org.Automation_Project.demoQA_Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class testUtil {

	@Test
	public Object[][] student_TestData() throws IOException
	{
		String filePath = System.getProperty("user.dir")+ "\\src\\test\\java\\org\\Automation_Project\\demoQA_Resources\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("student_Data");
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		XSSFRow row = sheet.getRow(0);
		int columCount = row.getLastCellNum();
		System.out.println(columCount);
		
		Object data[][] = new Object[rowCount+1][columCount];
		for(int i = 0; i<rowCount-1; i++)
		{
			row = sheet.getRow(i+1);
			for(int j=0; j<columCount; j++)
			{
				data[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return data;
		
		
		
		
	}
}
