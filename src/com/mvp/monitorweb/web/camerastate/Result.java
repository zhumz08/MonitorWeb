package com.mvp.monitorweb.web.camerastate;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable{
	private List<String> colNameList;

	private T resultList;

	public Result() {

	}

	public List<String> getColNameList() {
		return colNameList;
	}

	public void setColNameList(List<String> colNameList) {
		this.colNameList = colNameList;
	}

	public T getResultList() {
		return resultList;
	}

	public void setResultList(T resultList) {
		this.resultList = resultList;
	}
}
