package com.mvp.monitorweb.base;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public class BaseAction<T> {
	private T service;
	
	public ModelAndView view(String url, List<?> result){
		return view(url).addObject("resultList",result);
	}
	
	public ModelAndView view(String url){
		ModelAndView view = new ModelAndView(url);
		return view;
	}
	
	public void setService(T service) {
		this.service = service;
	}
	
	public T getService() {
		return service;
	}
	
}
