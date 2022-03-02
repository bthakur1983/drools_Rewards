package com.bank.drool_reward.dto;


public class RewardManage {

	private String clientApplication;
	private String requestAction;
	private String dataSourceId;
	private String keyType;
	private String primaryKey;
	private String versionNumber;
	private String buisnessProcess;
	private String buisnessSubprocess;
	private String earnType;
	private boolean isParamtereAlphaNumeric;
	
	
	public String getEarnType() {
		return earnType;
	}
	public void setEarnType(String earnType) {
		this.earnType = earnType;
	}
	public String getClientApplication() {
		return clientApplication;
	}
	public void setClientApplication(String clientApplication) {
		this.clientApplication = clientApplication;
	}
	public String getRequestAction() {
		return requestAction;
	}
	public void setRequestAction(String requestAction) {
		this.requestAction = requestAction;
	}
	public String getDataSourceId() {
		return dataSourceId;
	}
	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public String getBuisnessProcess() {
		return buisnessProcess;
	}
	public void setBuisnessProcess(String buisnessProcess) {
		this.buisnessProcess = buisnessProcess;
	}
	public String getBuisnessSubprocess() {
		return buisnessSubprocess;
	}
	public void setBuisnessSubprocess(String buisnessSubprocess) {
		this.buisnessSubprocess = buisnessSubprocess;
	}
	public boolean isParamtereAlphaNumeric() {
		return isParamtereAlphaNumeric;
	}
	public void setParamtereAlphaNumeric(boolean isParamtereAlphaNumeric) {
		this.isParamtereAlphaNumeric = isParamtereAlphaNumeric;
	}
	
}
