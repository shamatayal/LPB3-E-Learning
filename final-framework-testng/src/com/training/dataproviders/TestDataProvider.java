package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class TestDataProvider {

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\SHAMATAYAL\\git\\LPB3-E-Learning\\final-framework-testng\\Test Data\\Test_Data.xlsx"; 
		//String sheetname="ELTD_068";
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
}
