package com.mvp.monitorweb.common.dbcp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mvp.monitorweb.common.MvpConfig;

public class DBConnFactory {
	private final static Log log = LogFactory.getLog(DBConnFactory.class);


	public static JdbcTemplate createTemplate() {
		try {
			String jdbcClass = MvpConfig.getProperty("driverClass");
			String jdbcUrl = MvpConfig.getProperty("jdbcUrl");
			String username = MvpConfig.getProperty("user");
			String password = MvpConfig.getProperty("password");
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(jdbcClass);
			dataSource.setUrl(jdbcUrl);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			/*String sql = "select * from tbl_sxj";
			 
			List<ViewCamera> cameraList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ViewCamera.class));
			for (ViewCamera viewCamera : cameraList) {
				System.out.println(viewCamera.getXjmc());
			}*/
			
			
			return jdbcTemplate;
		} catch (Exception e) {
			log.error("Error DB connect",e);
		}
		
		return null;
	}
	
	
	public static JdbcTemplate createTemplate(String localhost) {
		try {
			String jdbcClass = MvpConfig.getProperty("driverClass");
			String jdbcUrl = MvpConfig.getProperty("jdbcUrl").replace("localhost", localhost);
			String username = MvpConfig.getProperty("user");
			String password = MvpConfig.getProperty("password");
			
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(jdbcClass);
			dataSource.setUrl(jdbcUrl);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			/*String sql = "select * from tbl_sxj";
			 
			List<ViewCamera> cameraList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ViewCamera.class));
			for (ViewCamera viewCamera : cameraList) {
				System.out.println(viewCamera.getXjmc());
			}*/
			
			
			return jdbcTemplate;
		} catch (Exception e) {
			log.error("Error DB connect",e);
		}
		
		return null;
	}

}
