package org.Automation_Project.demoQA_Testcases;

import java.io.IOException;

import org.Automation_Project.demoQA_Resources.excelReader;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testData
{
	String testDataSheet;
	String testDataExcelfilePath;
	
	public testData(String sheetName, String filepath)
	{
		testDataSheet = sheetName;
		testDataExcelfilePath = filepath;
	}

	public Object[][] testDataToTC() throws IOException 
  {	  
	DataFormatter df = new DataFormatter();	
	excelReader td = new excelReader(testDataSheet,testDataExcelfilePath);
	int rowCount = td.rowcount();
	int colCount = td.colCount();
	
	Object data[][] = new Object[rowCount-1][colCount];
	
	for(int i = 1; i<rowCount;i++)
	{
		for (int j=0;j<colCount;j++)
		{
			XSSFCell cellData = td.getCellData(i, j);
			String value = df.formatCellValue(cellData);
			data[i-1][j] = value;
		}
	}
	return data;
  }
}
