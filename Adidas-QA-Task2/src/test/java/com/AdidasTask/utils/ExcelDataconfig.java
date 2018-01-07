package com.AdidasTask.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataconfig {
	
	
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		FileOutputStream fout;
		File src;
	
	public ExcelDataconfig(){
		try {
			src= new File(System.getProperty("user.dir") + "//src//test//resources//TestData//InputData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			workbook  = new XSSFWorkbook(fis);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public String ExcelRead(int sheetnumber, int row, int column){
		
		
		sheet = workbook.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		
		return data;	
	}
	
	public double ExcelReadNumeric(int sheetnumber, int row, int column) throws IOException{
		
		
		sheet = workbook.getSheetAt(sheetnumber);
		double data = sheet.getRow(row).getCell(column).getNumericCellValue();
		
		
		return data;	
	}
	
	
	
	public void ExcelWrite(int sheetnumber, int row, int column, String value){
		sheet = workbook.getSheetAt(sheetnumber);
		sheet.getRow(row).createCell(column).setCellValue(value);
	}
	
	
	
	public void ExcelWriteFile() throws IOException{
		
		
		
		fout = new FileOutputStream(src);
		
		workbook.write(fout);
		
		workbook.close();
		
	}
	
	
	public int GetRowCount(int sheetindex){
		
		int row = workbook.getSheetAt(sheetindex).getLastRowNum();
		row=row+1;
		
		return row;
	}
	

}