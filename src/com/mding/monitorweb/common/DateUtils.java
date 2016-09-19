package com.mding.monitorweb.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtils {
	private static Log log = LogFactory.getLog(DateUtils.class);

	public final static Date parse(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS");
			return sdf.parse(date);
		} catch (Exception e) {
			log.error("parse error", e);
		}
		return null;
	}

	public final static Date parseYYMMddHHmmss(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return sdf.parse(date);
		} catch (Exception e) {
			log.error("parse error", e);
		}
		return null;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public final static Date parseSimple(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(date);
		} catch (Exception e) {
			log.error("parse error", e);
		}
		return null;
	}

	public final static String parse(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			log.error("parse error", e);
		}
		return null;
	}
}
