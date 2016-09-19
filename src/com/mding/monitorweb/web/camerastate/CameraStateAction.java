package com.mding.monitorweb.web.camerastate;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mding.monitorweb.base.BaseAction;
import com.mding.monitorweb.common.xls.ExcelWorkBook;


@Controller
@RequestMapping("/camerastate")
public class CameraStateAction extends BaseAction<CameraStateService>{
	
	private final static Log log = LogFactory.getLog(CameraStateAction.class);
	
	
	@RequestMapping("/query")
	@ResponseBody
	public Result<Object> query(HttpServletRequest request,QueryParam param){
		Result<Object> result = new Result<>();
		try {
			Map<String, String[]> map = request.getParameterMap();
			
			Map<String,Object> conditionMap = new HashMap<>();
			List<String> colNameList = new ArrayList<>();
			colNameList.add("v_xjmc");
			colNameList.add("v_ipdz");
			colNameList.add("v_xjbh");
			colNameList.add("v_isStore");
			colNameList.add("v_updateTime");
			
			for (Entry<String, String[]> entry : map.entrySet()) {
				//log.info("name:" + entry.getKey() );
				if(entry.getValue()==null ||entry.getValue().length==0){
					continue;
				}
				
				if(!entry.getKey().startsWith("v")){ 
					continue;
				}
				
				String value = entry.getValue()[0];
				if(!StringUtils.isBlank(value)){
					conditionMap.put(entry.getKey(), value);
				}
				
				//ip地址不用添加
				if("v_ipdz".equals(entry.getKey())){
					continue;
				}
				colNameList.add(entry.getKey());
			}
			
			String[] arrs = map.get("colname");
			if(arrs!=null){
				for (String colName : arrs) {
					colNameList.add(colName);
				}
			}
			
			
			String startTime = param.getStartDay() + " " + param.getStartHour() + ":" + param.getStartMinute();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date startDate = sdf.parse(startTime);
			long startMills = startDate.getTime()/1000;
			
			String endTime = param.getEndDay() + " " + param.getEndHour() + ":" + param.getEndMinute();
			Date endDate = sdf.parse(endTime);
			long endMills = endDate.getTime()/1000;
			
			List<Map<String, Object>> resultList = getService().getCameraStateList(colNameList,startMills,endMills,conditionMap);
			
			if(param.isExportXls()){
				ExcelWorkBook workBook = getService().exportCameraStateXls(colNameList,resultList);
				
				String contextPath = request.getServletContext().getRealPath("/");
				String xlsPath = contextPath + "/export/xls/";
				File xlsDir = new File(xlsPath);
				if(!xlsDir.exists()){
					xlsDir.mkdirs();
				}
				
				String fileName = System.currentTimeMillis()+".xls";
				File xlsFile = new File(xlsDir,fileName);
				FileOutputStream out = new FileOutputStream(xlsFile);
				workBook.getWorkbook().write(out);
				
				Result<Object> xlsResult = new Result<>();
				xlsResult.setResultList(fileName);
				return xlsResult;
				
			}
			
			List<List<KeyValue>> keyValueList = new ArrayList<>();
			for (Map<String, Object> tmpMap : resultList) {
				List<KeyValue> subList = new ArrayList<>();
				for (Entry<String, Object> entry : tmpMap.entrySet()) {
					Object val = entry.getValue();
					if(val==null){
						val = "";
					}
					
					subList.add(new KeyValue(entry.getKey(),val.toString()));
				}
				keyValueList.add(subList);
			}
			
			result.setColNameList(colNameList);
			result.setResultList(keyValueList);
		} catch (Exception e) {
			log.error("query error",e);
		}
		
		return result;
	}
	
	
	@RequestMapping("/queryHistory")
	@ResponseBody
	public Result<Object> queryHistory(HttpServletRequest request,QueryParam param){
		Result<Object> result = new Result<>();
		try {
			Map<String, String[]> map = request.getParameterMap();
			
			Map<String,Object> conditionMap = new HashMap<>();
			List<String> colNameList = new ArrayList<>();
			colNameList.add("v_xjmc");
			colNameList.add("v_ipdz");
			colNameList.add("v_xjbh");
			colNameList.add("v_isStore");
			colNameList.add("v_updateTime");
			
			for (Entry<String, String[]> entry : map.entrySet()) {
				//log.info("name:" + entry.getKey() );
				if(entry.getValue()==null ||entry.getValue().length==0){
					continue;
				}
				
				if(!entry.getKey().startsWith("v")){ 
					continue;
				}
				
				String value = entry.getValue()[0];
				if(!StringUtils.isBlank(value)){
					conditionMap.put(entry.getKey(), value);
				}
				
				//ip地址不用添加
				if("v_ipdz".equals(entry.getKey())){
					continue;
				}
				colNameList.add(entry.getKey());
				
			}
			
			String[] arrs = map.get("colname");
			if(arrs!=null){
				for (String colName : arrs) {
					colNameList.add(colName);
				}
			}
			
			
			String startTime = param.getStartDay() + " " + param.getStartHour() + ":" + param.getStartMinute();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date startDate = sdf.parse(startTime);
			long startMills = startDate.getTime()/1000;
			
			String endTime = param.getEndDay() + " " + param.getEndHour() + ":" + param.getEndMinute();
			Date endDate = sdf.parse(endTime);
			long endMills = endDate.getTime()/1000;
			
			List<Map<String, Object>> resultList = getService().getCameraStateHistoryList(colNameList,startMills,endMills,conditionMap);
			
			if(param.isExportXls()){
				ExcelWorkBook workBook = getService().exportCameraStateXls(colNameList,resultList);
				
				String contextPath = request.getServletContext().getRealPath("/");
				String xlsPath = contextPath + "/export/xls/historystate/";
				File xlsDir = new File(xlsPath);
				if(!xlsDir.exists()){
					xlsDir.mkdirs();
				}
				
				String fileName = System.currentTimeMillis()+".xls";
				File xlsFile = new File(xlsDir,fileName);
				FileOutputStream out = new FileOutputStream(xlsFile);
				workBook.getWorkbook().write(out);
				
				Result<Object> xlsResult = new Result<>();
				xlsResult.setResultList(fileName);
				return xlsResult;
				
			}
			
			List<List<KeyValue>> keyValueList = new ArrayList<>();
			for (Map<String, Object> tmpMap : resultList) {
				List<KeyValue> subList = new ArrayList<>();
				for (Entry<String, Object> entry : tmpMap.entrySet()) {
					Object val = entry.getValue();
					if(val==null){
						val = "";
					}
					
					subList.add(new KeyValue(entry.getKey(),val.toString()));
				}
				keyValueList.add(subList);
			}
			
			result.setColNameList(colNameList);
			result.setResultList(keyValueList);
		} catch (Exception e) {
			log.error("query error",e);
		}
		
		return result;
	}

	
}
