package com.mding.monitorweb.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mding.monitorweb.web.camerastate.CameraStateService;

@SuppressWarnings("serial")
public class WebDispatchServlet extends DispatcherServlet{
	private final static Log log = LogFactory.getLog(WebDispatchServlet.class);
	private static ApplicationContext context;

	@Override
	protected void initStrategies(ApplicationContext context) {
		super.initStrategies(context);
		
		WebDispatchServlet.context = context;
		
		//初始化配置
		CameraStateService stateService = context.getBean(CameraStateService.class);
		log.info("init stateConfig successfully......");
		stateService.getStateConfig();
		
		//同步状态线程
		SyncStateThread stateThread = new SyncStateThread(stateService);
		stateThread.start();
		log.info("start SyncStateThread successfully......");
		
	}

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext context) {
		WebDispatchServlet.context = context;
	}
	
}
