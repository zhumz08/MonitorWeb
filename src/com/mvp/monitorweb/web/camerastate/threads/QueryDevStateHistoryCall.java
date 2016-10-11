package com.mvp.monitorweb.web.camerastate.threads;

import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mvp.monitorweb.common.dbcp.DBConnFactory;
import com.mvp.monitorweb.web.camerastate.CameraStateDao;
import com.mvp.monitorweb.web.pojo.TblCamerastate;

public class QueryDevStateHistoryCall implements Callable<Integer> {

	private final static Log log = LogFactory.getLog(QueryDevStateHistoryCall.class);

	private String fwqdz = null;
	
	private CameraStateDao stateDao;
	
	
	public QueryDevStateHistoryCall(CameraStateDao stateDao, String fwqdz) {
		this.fwqdz = fwqdz;
		this.stateDao = stateDao;
	}
	

	public QueryDevStateHistoryCall(String fwqdz) {
		this.fwqdz = fwqdz;
	}

	
	public Integer call() {
		try {
			JdbcTemplate template = DBConnFactory.createTemplate(fwqdz);
			CameraStateDao dao = new CameraStateDao(template);
			
			List<TblCamerastate> stateList = dao.getCameraStateList();
			int[] result = stateDao.batchUpdateCameraState(stateList);
			
			int size = result==null ? 0 : result.length;
			log.info("update OK--->" + size + " state size:" + stateList.size());
			return size;
		}catch(CannotGetJdbcConnectionException e){
			log.error("CannotGetJdbcConnectionException error"+e.getMessage());
		} catch (Exception e) {
			log.error("QueryStateCall error",e);
		}
		return 0;
	}

}
