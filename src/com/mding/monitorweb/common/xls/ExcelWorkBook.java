package com.mding.monitorweb.common.xls;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelWorkBook {
	private HSSFWorkbook workbook;
	private List<ExcelSheet> sheetList = new ArrayList<>();

	public ExcelWorkBook() {
		setWorkbook(new HSSFWorkbook());
	}

	
	public ExcelSheet addSheet(String title, List<String> titleList){
		ExcelSheet sheet = new ExcelSheet(this, title);
		sheet.createTitle(titleList);
		getSheetList().add(sheet);		
		return sheet;
	}
	
	
	public ExcelSheet getDefaultSheet(){
		return getSheetList().get(0);
	}
	

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}


	public List<ExcelSheet> getSheetList() {
		return sheetList;
	}


	public void setSheetList(List<ExcelSheet> sheetList) {
		this.sheetList = sheetList;
	}

	
}
