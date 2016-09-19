package com.mding.monitorweb.web.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mding.monitorweb.base.BaseAction;

@Controller
@RequestMapping("/login")
public class LoginAction extends BaseAction<LoginService> {
	private final static Log log = LogFactory.getLog(LoginAction.class);

	@RequestMapping("/checkLogin")
	@ResponseBody
	public UserInfo login(UserInfo info) {
		log.info("login action....");
		
		try {
			getService().login(info);
		} catch (Exception e) {
			log.error("getService().login error",e);
		}
		
		return info;
	}

	
	@RequestMapping("/test")
	@ResponseBody
	public void test(String[] names,HttpServletRequest request){
		String[] nameArr = request.getParameterValues("names");
		System.out.println(nameArr);
		
	}
	
}
