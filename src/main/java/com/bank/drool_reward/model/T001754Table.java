package com.bank.drool_reward.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.ToString;

@Document(collection = "T001754Table")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@ToString
public class T001754Table
{
	@Id
	private String bZPC_ID;
	private String bZPC_NME;
	private String bZPC_SUB_NME;
	public String getbZPC_ID() {
		return bZPC_ID;
	}
	public void setbZPC_ID(String bZPC_ID) {
		this.bZPC_ID = bZPC_ID;
	}
	public String getbZPC_NME() {
		return bZPC_NME;
	}
	public void setbZPC_NME(String bZPC_NME) {
		this.bZPC_NME = bZPC_NME;
	}
	public String getbZPC_SUB_NME() {
		return bZPC_SUB_NME;
	}
	public void setbZPC_SUB_NME(String bZPC_SUB_NME) {
		this.bZPC_SUB_NME = bZPC_SUB_NME;
	}
	
	
	

}
