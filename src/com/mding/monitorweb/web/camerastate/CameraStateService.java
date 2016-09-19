package com.mding.monitorweb.web.camerastate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mding.monitorweb.base.BaseService;
import com.mding.monitorweb.common.MvpConfig;
import com.mding.monitorweb.common.dbcp.DBConnFactory;
import com.mding.monitorweb.common.dbcp.DBTemplate;
import com.mding.monitorweb.common.xls.ExcelSheet;
import com.mding.monitorweb.common.xls.ExcelWorkBook;
import com.mding.monitorweb.web.camerastate.threads.QueryStateCall;
import com.mding.monitorweb.web.pojo.ViewCamera;

@Service
public class CameraStateService extends BaseService{
	private final static Log log = LogFactory.getLog(CameraStateService.class);

	private ExecutorService threadPool = null;
	
	private CameraStateDao stateDao = null;

	public CameraStateService() {

	}

	
	 private static Map<String,String> stateTitleMap =  new HashMap<>();
	 static{
		 stateTitleMap.put("v_xjbh","相机编号");
        stateTitleMap.put("v_xjmc","摄像机名称");
        stateTitleMap.put("v_ipdz","IP地址");
        stateTitleMap.put("v_mac","MAC地址");
        stateTitleMap.put("v_online","在线状态");
        stateTitleMap.put("v_isStore","是否录像");
        stateTitleMap.put("v_store_state","录像状态");
        stateTitleMap.put("v_updateTime","时间");
        stateTitleMap.put("v_xzqh","行政区划");
        stateTitleMap.put("v_glbm","管理部门");
        stateTitleMap.put("v_xjlx","相机类型");
        stateTitleMap.put("v_sfkk","是否可控");
        stateTitleMap.put("v_yt","用途");
        stateTitleMap.put("v_qybz","启用标志");
        stateTitleMap.put("v_zgd","制高点");
        stateTitleMap.put("v_xjcs","相机厂商");
        stateTitleMap.put("v_dwmc","点位名称");
        stateTitleMap.put("v_lkmc","路口名称");
        stateTitleMap.put("v_twkg","透雾开关");
        stateTitleMap.put("v_gd","经度");
        stateTitleMap.put("v_wd","纬度");
        stateTitleMap.put("v_azrq","安装日期");
        stateTitleMap.put("v_bzqz","保质期至");
        stateTitleMap.put("v_jsdw","承建单位");
        stateTitleMap.put("v_yt_htbh","云台合同编号");
        stateTitleMap.put("v_jt_htbh","镜头合同编号");
        stateTitleMap.put("v_gcbh","工程信息编号");
        stateTitleMap.put("v_zrbm","设备责任部门");
        stateTitleMap.put("v_zrr_lxdh","联系电话");
        stateTitleMap.put("v_jydw","检验单位");
        stateTitleMap.put("v_lrr","录入人");
    };

	/**
	 * 
	 * 导出相机状态
	 * @param resultList 
	 * @param colNameList 
	 * @return 
	 * 
	 */
	public synchronized ExcelWorkBook exportCameraStateXls(List<String> colNameList, List<Map<String, Object>> resultList) {
		ExcelWorkBook workBook = new ExcelWorkBook();
		
		List<String> namesList = new ArrayList<>();
		namesList.add("编号");
		for (int i = 0; i < colNameList.size(); i++) {
			String name = colNameList.get(i);
			namesList.add(stateTitleMap.get(name));
		}
		
		ExcelSheet sheet = workBook.addSheet("titleSheet", namesList);
		for (int i = 0; i < resultList.size(); i++) {
			Map<String,Object> cellMap = resultList.get(i);
			
			List<Object> valueList = new ArrayList<>();
			valueList.add(String.valueOf(i+1));
			valueList.addAll(cellMap.values());
			
			sheet.addRow(valueList);
		}

		return workBook;
		
	}
	
	/**
	 * 获取摄像机状态
	 * @param colNameList
	 * @param startTime
	 * @param endTime
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String, Object>> getCameraStateList(List<String> colNameList,long startTime,long endTime,Map<String,Object> conditionMap) {
		return getStateDao().getCameraStateList(colNameList, startTime, endTime, conditionMap);
	}
	
	/**
	 * 获取摄像机状态历史
	 * @param colNameList
	 * @param startTime
	 * @param endTime
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String, Object>> getCameraStateHistoryList(List<String> colNameList,long startTime,long endTime,Map<String,Object> conditionMap) {
		return getStateDao().getCameraStateHistoryList(colNameList, startTime, endTime, conditionMap);
	}
	
	
	/**
	 * 同步状态
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public int syncCameraStateList() {
		try {
			//获取服务器列表
			List<String> serverList = stateDao.getMvpServerList();
			
			//新建查询任务，同步所有相机列表
			List<Future<Integer>> futureList = new ArrayList<>();
			for (String fwqdz : serverList) {
				QueryStateCall task = new QueryStateCall(stateDao,fwqdz);
				Future<Integer> future = getThreadPool().submit(task);
				futureList.add(future);
			}
			
			int totalSize = 0;
			for (Future<Integer> future : futureList) {
				Integer size = future.get();
				totalSize += size;
			}
			log.info("sync camera state totalsize:" + totalSize);
			return totalSize;
		} catch (Exception e) {
			log.error("error syncCameraStateList",e);
		}
		
		return 0;
	}
	
	/**
	 * 同步状态
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public int syncDevStateHistoryList() {
		try {
			//获取服务器列表
			List<String> serverList = stateDao.getMvpServerList();
			
			//新建查询任务，同步所有相机列表
			List<Future<Integer>> futureList = new ArrayList<>();
			for (String fwqdz : serverList) {
				QueryStateCall task = new QueryStateCall(stateDao,fwqdz);
				Future<Integer> future = getThreadPool().submit(task);
				futureList.add(future);
			}
			
			int totalSize = 0;
			for (Future<Integer> future : futureList) {
				Integer size = future.get();
				totalSize += size;
			}
			log.info("sync camera state totalsize:" + totalSize);
			return totalSize;
		} catch (Exception e) {
			log.error("error syncCameraStateList",e);
		}
		
		return 0;
	}

	public ExecutorService getThreadPool() {
		if (threadPool == null) {
			String poolSize = MvpConfig.getProperty("threadPoolSize");
			int threadPoolSize = NumberUtils.toInt(poolSize);

			threadPool = Executors.newFixedThreadPool(threadPoolSize);
		}

		return threadPool;
	}

	public void setThreadPool(ExecutorService threadPool) {
		this.threadPool = threadPool;
	}

	
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		MvpConfig.getInstance();
		MvpConfig.getProps().load(CameraStateService.class.getResourceAsStream("/script/mvp.properties"));
		
		CameraStateService service = new CameraStateService();
		JdbcTemplate template = DBConnFactory.createTemplate();
		CameraStateDao dao = new CameraStateDao(template);
		service.setStateDao(dao);
		
		int stateCount = service.syncCameraStateList();
		log.info("stateCount:" + stateCount);
	}

	public CameraStateDao getStateDao() {
		return stateDao;
	}

	public void setStateDao(CameraStateDao stateDao) {
		this.stateDao = stateDao;
	}

	public void getStateConfig() {
		stateDao.getStateConfig();
	}
	
}
