package com.mvp.monitorweb.common.xls;

import java.util.List;

public interface IRow {
	
	public void addRow(ExcelSheet sheet,List<String> cellList);

}
