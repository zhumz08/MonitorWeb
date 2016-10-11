package com.mvp.monitorweb.web.camerastate;

public class QueryParam {
	private String startDay;
	private String startHour;
	private String startMinute;
	
	private String endDay;
	private String endHour;
	private String endMinute;
	
	private boolean exportXls = false;
	
	public QueryParam() {
		
	}
	
	
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getStartHour() {
		return startHour;
	}
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	public String getStartMinute() {
		return startMinute;
	}
	public void setStartMinute(String startMinute) {
		this.startMinute = startMinute;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public String getEndHour() {
		return endHour;
	}
	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}
	public String getEndMinute() {
		return endMinute;
	}
	public void setEndMinute(String endMinute) {
		this.endMinute = endMinute;
	}


	public boolean isExportXls() {
		return exportXls;
	}


	public void setExportXls(boolean exportXls) {
		this.exportXls = exportXls;
	}
	
	
	
	
}
