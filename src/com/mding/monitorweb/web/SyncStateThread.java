package com.mding.monitorweb.web;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mding.monitorweb.common.MvpConfig;
import com.mding.monitorweb.web.camerastate.CameraStateService;

public class SyncStateThread extends Thread {
	private final static Log log = LogFactory.getLog(SyncStateThread.class);

	private CameraStateService stateService;

	public SyncStateThread() {

	}

	public SyncStateThread(CameraStateService stateService) {
		this.stateService = stateService;
	}

	public void run() {
		long inteval = NumberUtils.toInt(MvpConfig.getProperty(MvpConfig.updateTimeInterval), 15000);
		while (true) {
			stateService.syncCameraStateList();

			try {
				Thread.sleep(inteval);
			} catch (InterruptedException e) {
				log.error("thread err", e);
			}
		}

	}

	public CameraStateService getStateService() {
		return stateService;
	}

	public void setStateService(CameraStateService stateService) {
		this.stateService = stateService;
	}

}
