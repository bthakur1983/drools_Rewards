package com.bank.drool_reward.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "T001906Table")
@JsonInclude(value=Include.NON_NULL)
@ToString
public class T001906Table {

	
    @Id
	private String eAC_ID;

    private String eAC_IAC_ID;

    private String eAC_EXP_DTP;
    
    
    

	 
     
	 

	public String geteAC_ID() {
		return eAC_ID;
	}

	public void seteAC_ID(String eAC_ID) {
		this.eAC_ID = eAC_ID;
	}

	public String geteAC_IAC_ID() {
		return eAC_IAC_ID;
	}

	public void seteAC_IAC_ID(String eAC_IAC_ID) {
		this.eAC_IAC_ID = eAC_IAC_ID;
	}

	public String geteAC_EXP_DTP() {
		return eAC_EXP_DTP;
	}

	public void seteAC_EXP_DTP(String eAC_EXP_DTP) {
		this.eAC_EXP_DTP = eAC_EXP_DTP;
	}

	 

     
}

