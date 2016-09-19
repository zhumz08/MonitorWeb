package com.mding.monitorweb.common.xls;

import java.util.Collection;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.mding.monitorweb.common.xls.row.CameraStateRow;

public class ExcelSheet {

	private HSSFWorkbook workbook = null;

	private HSSFSheet sheet = null;

	private int rowIndex = 0;

	public ExcelSheet(ExcelWorkBook workbook, String title) {
		this.workbook = workbook.getWorkbook();

		setSheet(this.workbook.createSheet(title));
	}

	/**
	 * 
	 * @param titleList
	 */
	public void createTitle(List<String> titleList) {
		HSSFRow row = getSheet().createRow(rowIndex++);

		for (int i = 0; i < titleList.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titleList.get(i));
			cell.setCellStyle(getTitleStyle());
		}

	}

	/**
	 * 
	 * @return
	 */
	public HSSFCellStyle getTitleStyle() {
		HSSFCellStyle style = workbook.createCellStyle();

		HSSFFont font = workbook.createFont();
		font.setBold(true);

		style.setFont(font);

		return style;
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}
	

	public ExcelRow createRow(){
		HSSFRow row = this.sheet.createRow(rowIndex++);
		return new ExcelRow(row);
	}
	
	
	public HSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}

	
	public void addRow(Collection<Object> cellList) {
		ExcelRow row = this.createRow();

		for (Object value : cellList) {
			if(value==null){
				value = "";
			}
			row.addCell(value.toString());
		}
	}
	

}
