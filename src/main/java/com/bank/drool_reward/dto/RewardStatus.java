package com.bank.drool_reward.dto;





public class RewardStatus {

    private String clientApplication;
    private String requestAction;
    private String dataSourceId;
    private String keyType;
    private String primaryKey;
    private String versionNumber;   
    private boolean isParamtereAlphaNumeric;
     
    
    
    

    public boolean getIsParamtereAlphaNumeric() {
		return isParamtereAlphaNumeric;
	}

	public void setIsParamtereAlphaNumeric(boolean isParamtereAlphaNumeric) {
		this.isParamtereAlphaNumeric = isParamtereAlphaNumeric;
	}

	 

	public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String key;


    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
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

 
    
}
