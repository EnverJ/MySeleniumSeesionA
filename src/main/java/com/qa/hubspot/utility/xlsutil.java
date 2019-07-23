package com.qa.hubspot.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class xlsutil {
	public static Workbook book;
	public static Sheet sheet;
	public static String Test_Data_Sheet_Path="/Users/enlem/workspace/MyPOMserious/src/main/java/com/qa/hubspot/testdata/MyDtP.xlsx";
public static Object[][] getTestData(String sheetNmae){
	FileInputStream file=null;
	try {
		file=new FileInputStream(Test_Data_Sheet_Path);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}

	try {
		book=WorkbookFactory.create(file);
	} catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	sheet=book.getSheet(sheetNmae);
	Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++){
		for(int k=0;k<sheet.getRow(0).getFirstCellNum();k++){
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			
		}
	}
	return data;
}

}
