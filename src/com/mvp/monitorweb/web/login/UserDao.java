package com.mvp.monitorweb.web.login;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mvp.monitorweb.base.BaseDao;
import com.mvp.monitorweb.base.BasePreparedStatementCreator;

@Component
public class UserDao extends BaseDao{
	public static final Log log = LogFactory.getLog(UserDao.class);

	/**
	 *  登录
	 * @param login
	 * @return
	 */
	public UserInfo login(UserInfo login){
		String sql = "select * from userinfo t where t.name = ? , t.password = ? ";
		return getJdbcTemplate().queryForObject(sql,
				new Object[] { 
					login.getUserName(), 
					login.getPassword() 
				}, BeanPropertyRowMapper.newInstance(UserInfo.class));
	}

	/**
	 * 用户创建
	 * @param login
	 * @return
	 */
	public UserInfo create(UserInfo login) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		String sql = "insert into userinfo(username,password) values(?,?)";
		int result = getJdbcTemplate().update(
				new BasePreparedStatementCreator<UserInfo>(login, sql) {

					@Override
					public PreparedStatement update(UserInfo param,
							PreparedStatement pst) throws SQLException {
						Object[] paramArr = new Object[] { param.getUserName(),
								param.getPassword() };

						for (int i = 0; i < paramArr.length; i++) {
							pst.setObject((i + 1), paramArr[i]);
						}

						return pst;
					}

				}, keyHolder);

		if (result <= 0) { //没有行更新
			log.warn(result + " rows update");
		}

		int keyValue = (int) keyHolder.getKey().longValue();
		login.setId(keyValue);

		return login;
	}

}
