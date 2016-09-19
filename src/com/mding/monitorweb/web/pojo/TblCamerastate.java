package com.mding.monitorweb.web.pojo;


/**
 */
@SuppressWarnings("serial")
public class TblCamerastate implements java.io.Serializable {

	// Fields

	private Long ubiLogicId;
	private String szGiscode;
	private Integer uiEnable;
	private Integer uiRecordFlag;
	private Integer uiRecordState;
	private Integer uiAccessMode;
	private Long ubiUpdateTime;

	// Constructors

	/** default constructor */
	public TblCamerastate() {
	}

	/** full constructor */
	public TblCamerastate(String szGiscode, Integer uiEnable,
			Integer uiRecordFlag, Integer uiRecordState, Integer uiAccessMode,
			Long ubiUpdateTime) {
		this.szGiscode = szGiscode;
		this.uiEnable = uiEnable;
		this.uiRecordFlag = uiRecordFlag;
		this.uiRecordState = uiRecordState;
		this.uiAccessMode = uiAccessMode;
		this.ubiUpdateTime = ubiUpdateTime;
	}

	public Long getUbiLogicId() {
		return this.ubiLogicId;
	}

	public void setUbiLogicId(Long ubiLogicId) {
		this.ubiLogicId = ubiLogicId;
	}

	public String getSzGiscode() {
		return this.szGiscode;
	}

	public void setSzGiscode(String szGiscode) {
		this.szGiscode = szGiscode;
	}

	public Integer getUiEnable() {
		return this.uiEnable;
	}

	public void setUiEnable(Integer uiEnable) {
		this.uiEnable = uiEnable;
	}

	public Integer getUiRecordFlag() {
		return this.uiRecordFlag;
	}

	public void setUiRecordFlag(Integer uiRecordFlag) {
		this.uiRecordFlag = uiRecordFlag;
	}

	public Integer getUiRecordState() {
		return this.uiRecordState;
	}

	public void setUiRecordState(Integer uiRecordState) {
		this.uiRecordState = uiRecordState;
	}

	public Integer getUiAccessMode() {
		return this.uiAccessMode;
	}

	public void setUiAccessMode(Integer uiAccessMode) {
		this.uiAccessMode = uiAccessMode;
	}

	public Long getUbiUpdateTime() {
		return this.ubiUpdateTime;
	}

	public void setUbiUpdateTime(Long ubiUpdateTime) {
		this.ubiUpdateTime = ubiUpdateTime;
	}

}