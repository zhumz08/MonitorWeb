package com.mvp.monitorweb.common;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MvpConfig {

	private final static Log log = LogFactory.getLog(MvpConfig.class);

	private static Properties props = new Properties();

	public final static String updateTimeInterval = "updateTimeInterval";
	public final static String syncTime = "syncTime";

	private final static MvpConfig instance = new MvpConfig();

	public MvpConfig() {
		try {
		} catch (Exception e) {
			log.error("MvpConfig init error", e);
		}

	}

	public static String getProperty(String key) {
		return getProps().getProperty(key);
	}

	public static MvpConfig getInstance() {
		return instance;
	}

	public static Properties getProps() {
		return props;
	}

	public static void setProps(Properties props) {
		MvpConfig.props = props;
	}

}
