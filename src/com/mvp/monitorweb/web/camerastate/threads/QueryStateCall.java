package com.mvp.monitorweb.web.camerastate.threads;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mvp.monitorweb.common.DateUtils;
import com.mvp.monitorweb.common.MvpConfig;
import com.mvp.monitorweb.common.dbcp.DBConnFactory;
import com.mvp.monitorweb.web.camerastate.CameraStateDao;
import com.mvp.monitorweb.web.pojo.TblCamerastate;
import com.mvp.monitorweb.web.pojo.TblDevstatehistory;

public class QueryStateCall implements Callable<Integer> {

	private final static Log log = LogFactory.getLog(QueryStateCall.class);

	private String fwqdz = null;
	
	private CameraStateDao stateDao;
	
	
	public QueryStateCall(CameraStateDao stateDao, String fwqdz) {
		this.fwqdz = fwqdz;
		this.stateDao = stateDao;
	}
	

	public QueryStateCall(String fwqdz) {
		this.fwqdz = fwqdz;
	}

	
	public Integer call() {
		try {
			JdbcTemplate template = DBConnFactory.createTemplate(fwqdz);
			if(template==null){
				log.error("QueryStateCall fwqdz:" + fwqdz);
				return 0;
			}
			CameraStateDao dao = new CameraStateDao(template);
			
			//先同步状态
			updateState(dao);
			
			//同步历史记录
			int[] syncArr = syncCameraStateHistory(dao);
			log.info(Thread.currentThread().getName() + "fwqdz:" + fwqdz + "syncArr size:" + syncArr.length);
			
		}catch(CannotGetJdbcConnectionException e){
			log.error("CannotGetJdbcConnectionException error" + e.getMessage());
		} catch (Exception e) {
			log.error("QueryStateCall error",e);
		}
		return 0;
	}
	

	private int[] syncCameraStateHistory(CameraStateDao dao) {
		String synTime = MvpConfig.getProps().getProperty(MvpConfig.syncTime);
		Date date = DateUtils.parseYYMMddHHmmss(synTime);
		long startTime = date.getTime();
		long endTime = System.currentTimeMillis();
		date.setTime(endTime);
		
		List<TblDevstatehistory> dataList = dao.getDevStateHistoryList(startTime/1000,endTime/1000);
		MvpConfig.getProps().setProperty(MvpConfig.syncTime,DateUtils.parse(date));
		stateDao.updateStateConfig(MvpConfig.syncTime, DateUtils.parse(date));
		
		return stateDao.batchDevstatehistoryList(dataList);
	}

	private void updateState(CameraStateDao dao) {
		List<TblCamerastate> stateList = dao.getCameraStateList();
		int[] result = stateDao.batchUpdateCameraState(stateList);
		
		int size = result==null ? 0 : result.length;
		log.info("update OK--->" + size + " state size:" + stateList.size());
	}

}
