package com.mding.monitorweb.web.camerastate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.mding.monitorweb.base.BaseDao;
import com.mding.monitorweb.common.MvpConfig;
import com.mding.monitorweb.common.dbcp.DBConnFactory;
import com.mding.monitorweb.web.pojo.TblCamerastate;
import com.mding.monitorweb.web.pojo.TblDevstatehistory;
import com.mding.monitorweb.web.pojo.ViewCamera;

@Component
public class CameraStateDao extends BaseDao {
	private final static Log log = LogFactory.getLog(CameraStateDao.class);

	private JdbcTemplate jdbcTempate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public CameraStateDao() {

	}

	public CameraStateDao(JdbcTemplate jdbcTempate) {
		this.jdbcTempate = jdbcTempate;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTempate);
	}

	public List<ViewCamera> getCameraList() {
		String sql = " select * from tbl_sxj ";

		return jdbcTempate.query(sql, BeanPropertyRowMapper.newInstance(ViewCamera.class));
	}
	
	
	/**
	 * 获取服务器相机列表
	 * @return 
	 * 
	 */
	public List<TblCamerastate> getCameraStateList(){
		String sql = "SELECT UBI_LOGIC_ID as ubiLogicId, SZ_GISCODE as szGisCode, UI_ENABLE as uiEnable, UI_RECORD_FLAG as uiRecordFlag, UI_RECORD_STATE as uiRecordState, UI_ACCESS_MODE as uiAccessMode, UBI_UPDATE_TIME as ubiUpdateTime FROM tbl_camerastate ";
		
		return jdbcTempate.query(sql, BeanPropertyRowMapper.newInstance(TblCamerastate.class));
	}
	
	/**
	 * 获取服务器相机列表
	 * @return 
	 * 
	 */
	public List<TblDevstatehistory> getDevStateHistoryList(long startTime,long endTime){
		String sql = "SELECT t.UBI_LOGIC_ID ubiLogicId, t.UI_EVENT_TYPE AS uiEventType, t.UI_EVENT_DESC AS uiEventDesc, "
				+ "t.UBI_TIME as ubiTime, t.SZ_GISCODE as szGiscode, t.UI_DEV_TYPE as uiDevType, t.UI_ACCESS_MODE as uiAccessMode FROM tbl_devstatehistory t ";
		sql += " where t.UBI_TIME between ? and ? ";
		
		return jdbcTempate.query(sql, new Object[]{startTime,endTime},BeanPropertyRowMapper.newInstance(TblDevstatehistory.class));
	}
	
	
	/**
	 * 更新状态
	 * @param name
	 * @param value
	 * @return
	 */
	public int updateStateConfig(String name,String value){
		String sql = "update tbl_stateconfig set `value` = ? where `name` = ? ";
		
		return jdbcTempate.update(sql, new Object[]{value,name});
	}
	
	
	/**
	 * 获取相机状态查询配置
	 * @return 
	 */
	public void getStateConfig(){
		String sql = "select `name`,`value` from tbl_stateconfig";
		
		jdbcTempate.query(sql, new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				String key = rs.getString("name");
				String value = rs.getString("value");
				
				MvpConfig.getProps().put(key, value);
			}
		});
	}
	
	
	/**
	 * 获取服务器相机列表
	 * @return 
	 * @return 
	 * 
	 */
	public int[] batchDevstatehistoryList(List<TblDevstatehistory> dataList){
		String sql = "insert into  tbl_devstatehistory_all(`UI_EVENT_TYPE`,`UI_EVENT_DESC`,`UBI_TIME`,`SZ_GISCODE`,`UI_DEV_TYPE`,`UI_ACCESS_MODE`) values (?,?,?,?,?,?) ";
		
		List<Object[]> devStateList = new ArrayList<>();
		for (TblDevstatehistory devState : dataList) {
			devStateList.add(new Object[]{
				devState.getUiDevType(),
				devState.getUiEventDesc(),
				devState.getUbiTime(),
				devState.getSzGiscode(),
				devState.getUiDevType(),
				devState.getUiAccessMode()
			});
		}
		
		return jdbcTempate.batchUpdate(sql, devStateList);
		
	}
	
	
	/**
	 * 批量更新状态
	 * @param stateList
	 * @return
	 */
	public int[] batchUpdateCameraState(List<TblCamerastate> stateList){
		String sql = "update tbl_camerastateall set  UI_ENABLE = ?,UI_RECORD_FLAG = ? ,UI_RECORD_STATE = ? ,UI_ACCESS_MODE = ?,UBI_UPDATE_TIME = ? where SZ_GISCODE = ?";
		
		List<Object[]> stateArgList = new ArrayList<>();
		for (TblCamerastate tblState : stateList) {
			
			Object[] args = {
				tblState.getUiEnable(),
				tblState.getUiRecordFlag(),
				tblState.getUiRecordState(),
				tblState.getUiAccessMode(),
				tblState.getUbiUpdateTime(),
				tblState.getSzGiscode()
			};
			
			stateArgList.add(args);
		}
		
		return jdbcTempate.batchUpdate(sql, stateArgList);
		
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
		String colNameStr = "";
		for (String colName : colNameList) {
			colNameStr += "," + colName;
		}
		colNameStr = colNameStr.substring(1);
		log.info("colNameStr:" + colNameStr);

		MapSqlParameterSource parameters = new MapSqlParameterSource();

		String sql = " select "+colNameStr+" from view_camerastate_all t where 1=1 ";

		///开始时间和结束时间
		if(endTime!=0){
			sql += " and  t.v_updateTime1 between :startTime and :endTime  ";
			parameters.addValue("startTime", startTime);
			parameters.addValue("endTime", endTime);
		}
		
		// conditionMap
		for (Entry<String, Object> entry: conditionMap.entrySet()) {
			if(!entry.getValue().toString().equals("全部")){
				String keyName = entry.getKey();
				if(keyName.equals("v_ipdz")){
					sql += " and " +  keyName + " like '%" + entry.getValue() + "%' ";
					parameters.addValue(keyName, entry.getValue());
				}else{
					sql += " and " +  keyName + " = :" + keyName+ " ";
					parameters.addValue(keyName, entry.getValue());
				}
			}
		}
		
		log.info("getCameraStateList SQL:"+sql);
		
		List<Map<String, Object>> resultList = namedJdbcTemplate.queryForList(sql, parameters);
		/*for (Map<String, Object> map : resultList) {
			for (Entry<String, Object> entry : map.entrySet()) {
				log.info("key:" + entry.getKey() + " value:" + entry.getValue());
			}
		}*/
		
		return resultList;
	}
	
	/**
	 * 获取摄像机历史状态
	 * @param colNameList
	 * @param startTime
	 * @param endTime
	 * @param conditionMap
	 * @return
	 */
	public List<Map<String, Object>> getCameraStateHistoryList(List<String> colNameList,long startTime,long endTime,Map<String,Object> conditionMap) {
		String colNameStr = "";
		for (String colName : colNameList) {
			colNameStr += "," + colName;
		}
		colNameStr = colNameStr.substring(1);
		log.info("colNameStr:" + colNameStr);
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		
		String sql = " select "+colNameStr+" from view_devstatehistory_all t where 1=1 ";
		
		///开始时间和结束时间
		if(endTime!=0){
			sql += " and  t.v_updateTime1 between :startTime and :endTime  ";
			parameters.addValue("startTime", startTime);
			parameters.addValue("endTime", endTime);
		}
		
		// conditionMap
		for (Entry<String, Object> entry: conditionMap.entrySet()) {
			if(!entry.getValue().toString().equals("全部")){
				String keyName = entry.getKey();
				
				if(keyName.equals("v_ipdz")){
					sql += " and " +  keyName + " like :" + keyName+ " ";
					parameters.addValue(keyName, "'%" + entry.getValue() + "%'");
				}else{
					sql += " and " +  keyName + " = :" + keyName+ " ";
					parameters.addValue(keyName, entry.getValue());
				}

			}
		}
		
		log.info("getCameraStateList SQL:"+sql);
		
		List<Map<String, Object>> resultList = namedJdbcTemplate.queryForList(sql, parameters);
		/*for (Map<String, Object> map : resultList) {
			for (Entry<String, Object> entry : map.entrySet()) {
				log.info("key:" + entry.getKey() + " value:" + entry.getValue());
			}
		}*/
		
		return resultList;
	}
	
	/*public List<ViewCamera> getCameraStateList(List<String> cameraIdList) {
		String sql = " select * from tbl_sxj t where t.xjbh in ( :cameraIdList )";

		if (cameraIdList == null || cameraIdList.isEmpty()) {
			return null;
		}

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("cameraIdList", cameraIdList);

		return namedJdbcTemplate.query(sql, parameters,BeanPropertyRowMapper.newInstance(ViewCamera.class));
	}
*/

	public JdbcTemplate getJdbcTempate() {
		return jdbcTempate;
	}

	protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
		this.jdbcTempate = super.createJdbcTemplate(dataSource);
		setJdbcTempate(jdbcTempate);
		return jdbcTempate;
	}


	public void setJdbcTempate(JdbcTemplate jdbcTempate) {
		this.jdbcTempate = jdbcTempate;
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTempate);
	}
	
	public static void main(String[] args) {
		JdbcTemplate template = DBConnFactory.createTemplate();
		
		CameraStateDao dao = new CameraStateDao(template);
		List<String> colNameList = new ArrayList<>();
		colNameList.add("v_xjbh");
		colNameList.add("v_xjmc");
		colNameList.add("v_ipdz");
		colNameList.add("v_mac");
		
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("v_xjbh", "'15020000001320800022'");
		
		List<Map<String, Object>> cameraStateList = dao.getCameraStateList(colNameList,0,0,conditionMap);
		
	}

	/**
	 * 获取所有的Mvp服务器地址
	 * @return
	 */
	public List<String> getMvpServerList() {
		String sql = "select fwqdz from view_mvpserver";
		
		return getJdbcTempate().queryForList(sql, String.class);
	}

}
