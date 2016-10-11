package com.mvp.monitorweb.web.login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.mvp.monitorweb.base.BaseService;

@Service
public class LoginService extends BaseService{
	private final static Log log = LogFactory.getLog(LoginService.class);
	private UserDao dao = null;
	
	public UserInfo login(UserInfo info) {
		return dao.login(info);
	}

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

}
