package com.bank.drool_reward.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T003922Table")
@JsonInclude(value=Include.NON_NULL)
@ToString
public class T003922Table {

	 @Id
    private String aCCT_IAC_ID;
    private String aCCT_UID;
    private String aCCT_NBR;
    private String aCCT_BU_NBR;
    private String aCCT_SYS_CDE;
    
    private boolean isValidRequest;
    
    
    
    
	public boolean isValidRequest() {
		return isValidRequest;
	}
	public void setValidRequest(boolean isValidRequest) {
		this.isValidRequest = isValidRequest;
	}
	public String getaCCT_IAC_ID() {
		return aCCT_IAC_ID;
	}
	public void setaCCT_IAC_ID(String aCCT_IAC_ID) {
		this.aCCT_IAC_ID = aCCT_IAC_ID;
	}
	public String getaCCT_UID() {
		return aCCT_UID;
	}
	public void setaCCT_UID(String aCCT_UID) {
		this.aCCT_UID = aCCT_UID;
	}
	public String getaCCT_NBR() {
		return aCCT_NBR;
	}
	public void setaCCT_NBR(String aCCT_NBR) {
		this.aCCT_NBR = aCCT_NBR;
	}
	public String getaCCT_BU_NBR() {
		return aCCT_BU_NBR;
	}
	public void setaCCT_BU_NBR(String aCCT_BU_NBR) {
		this.aCCT_BU_NBR = aCCT_BU_NBR;
	}
	public String getaCCT_SYS_CDE() {
		return aCCT_SYS_CDE;
	}
	public void setaCCT_SYS_CDE(String aCCT_SYS_CDE) {
		this.aCCT_SYS_CDE = aCCT_SYS_CDE;
	}
    
	 
 
}
