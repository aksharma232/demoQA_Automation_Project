package org.Automation_Project.demoQA_Resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelReader {

	XSSFWorkbook wb;
	XSSFSheet excelsheet;

	public excelReader(String sheetName, String filepath) throws IOException
	{
		String excelfilePath = filepath;
		FileInputStream fis = new FileInputStream(excelfilePath);
		wb = new XSSFWorkbook(fis);
		excelsheet = wb.getSheet(sheetName);
		
	}
	public int rowcount() throws IOException
	{
		int rowCount = excelsheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		return rowCount;
	}
	public int colCount()
	{
		XSSFRow row = excelsheet.getRow(0);
		int columCount = row.getLastCellNum();
		System.out.println(columCount);
		return columCount;
		
	}

	public XSSFCell getCellData(int row,int column)
	{
		
		XSSFCell cellData = excelsheet.getRow(row).getCell(column);
		return cellData;
		
	}



}

