package com.mvp.monitorweb.common.xls;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;


public class ExcelRow {
	private HSSFRow row;
	
	private int cellIndex;
	
	
	public ExcelRow() {
		
	}
	
	public ExcelRow(HSSFRow row) {
		this.row = row;
	}
	
	public void addCell(String value){
		HSSFCell cell = row.createCell(cellIndex++);
		cell.setCellValue(value);
	}
	
}
