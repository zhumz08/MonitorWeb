package com.mvp.monitorweb.common.xls.row;

import java.util.List;

import com.mvp.monitorweb.common.xls.ExcelRow;
import com.mvp.monitorweb.common.xls.ExcelSheet;
import com.mvp.monitorweb.common.xls.IRow;

public class CameraStateRow implements IRow {
	

	public CameraStateRow() {
	}
	
	
	public void addRow(ExcelSheet sheet,List<String> cellList) {
		ExcelRow row = sheet.createRow();
		
		for (String value : cellList) {
			row.addCell(value);
		}
	}

}
