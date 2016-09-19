package com.mding.monitorweb.common.xls;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelTools {

	public static ExcelWorkBook createExcel(String title, List<String> titleList) {
		ExcelWorkBook workbook = new ExcelWorkBook();
		workbook.addSheet(title, titleList);

		return workbook;
	}

	public static void main(String[] args) {
		try {
			List<String> titleList = new ArrayList<>();
			titleList.add("编号");
			titleList.add("国标编号");
			titleList.add("摄像机");
			titleList.add("可控");
			titleList.add("1级部门名称");

			ExcelWorkBook workbook = createExcel("摄像机状态", titleList);
			
			ExcelSheet sheet = workbook.getDefaultSheet();
			for (int i = 0; i < 10; i++) {
			//	sheet.addRow(titleList);
			}

			FileOutputStream os = new FileOutputStream("./fisrtExcel.xls");
			workbook.getWorkbook().write(os);

			os.flush();
			os.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void createTitle(List<String> titleList) {

	}

}
