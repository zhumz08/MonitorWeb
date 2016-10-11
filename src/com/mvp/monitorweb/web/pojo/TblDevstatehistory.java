package com.mvp.monitorweb.web.pojo;


/**
 * TblDevstatehistory entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
public class TblDevstatehistory implements java.io.Serializable {

	// Fields
	private Long ubiLogicId;
	private Integer uiEventType;
	private String uiEventDesc;
	private Long ubiTime;
	private String szGiscode;
	private Integer uiDevType;
	private Integer uiAccessMode;

	// Constructors

	/** default constructor */
	public TblDevstatehistory() {
	}

	/** minimal constructor */
	public TblDevstatehistory(Integer uiEventType, Long ubiTime,
			String szGiscode, Integer uiDevType, Integer uiAccessMode) {
		this.uiEventType = uiEventType;
		this.ubiTime = ubiTime;
		this.szGiscode = szGiscode;
		this.uiDevType = uiDevType;
		this.uiAccessMode = uiAccessMode;
	}

	/** full constructor */
	public TblDevstatehistory(Integer uiEventType, String uiEventDesc,
			Long ubiTime, String szGiscode, Integer uiDevType,
			Integer uiAccessMode) {
		this.uiEventType = uiEventType;
		this.uiEventDesc = uiEventDesc;
		this.ubiTime = ubiTime;
		this.szGiscode = szGiscode;
		this.uiDevType = uiDevType;
		this.uiAccessMode = uiAccessMode;
	}

	// Property accessors
	public Long getUbiLogicId() {
		return this.ubiLogicId;
	}

	public void setUbiLogicId(Long ubiLogicId) {
		this.ubiLogicId = ubiLogicId;
	}

	public Integer getUiEventType() {
		return this.uiEventType;
	}

	public void setUiEventType(Integer uiEventType) {
		this.uiEventType = uiEventType;
	}

	public String getUiEventDesc() {
		return this.uiEventDesc;
	}

	public void setUiEventDesc(String uiEventDesc) {
		this.uiEventDesc = uiEventDesc;
	}

	public Long getUbiTime() {
		return this.ubiTime;
	}

	public void setUbiTime(Long ubiTime) {
		this.ubiTime = ubiTime;
	}

	public String getSzGiscode() {
		return this.szGiscode;
	}

	public void setSzGiscode(String szGiscode) {
		this.szGiscode = szGiscode;
	}

	public Integer getUiDevType() {
		return this.uiDevType;
	}

	public void setUiDevType(Integer uiDevType) {
		this.uiDevType = uiDevType;
	}

	public Integer getUiAccessMode() {
		return this.uiAccessMode;
	}

	public void setUiAccessMode(Integer uiAccessMode) {
		this.uiAccessMode = uiAccessMode;
	}

}