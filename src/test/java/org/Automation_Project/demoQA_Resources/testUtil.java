package org.Automation_Project.demoQA_Resources;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class testUtil {

	//@Test
	public Object[][] student_TestData() throws IOException
	{
		String s = "sheet1";
		DataFormatter dm =  new DataFormatter();
		String filePath = System.getProperty("user.dir")+ "\\src\\test\\java\\org\\Automation_Project\\demoQA_Resources\\TestData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(s);
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		XSSFRow row = sheet.getRow(0);
		int columCount = row.getLastCellNum();
		System.out.println(columCount);
		Object[][] data = new String[rowCount][columCount];
		for(int i = 0; i<rowCount; i++)
		{
			row = sheet.getRow(i+1);
			for(int j=0; j<columCount; j++)
			{
				XSSFCell cell = sheet.getRow(i).getCell(j);
				data[i][j] = dm.formatCellValue(cell);
			}
		wb.close();
		}
		
		return data;
	}
	/*
	@Test
	public void td() throws IOException
	{
		System.out.println(student_TestData());
		
	}
	*/
}

