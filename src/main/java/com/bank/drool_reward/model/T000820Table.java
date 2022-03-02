package com.bank.drool_reward.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.ToString;


@Document(collection = "T000820Table")
@JsonInclude(value=Include.NON_NULL)
@ToString
public class T000820Table
{
	@Id
	private String rWAE_UID;
	private String rWAE_BU_NBR;
	private String rWAE_PGM_NBR;
	private String rWAE_TYP_CDE;
	private String rWAE_ACTN_DEST_NBR;
	private String rWAE_RWDP_SEQ_NBR;
	private String rWAE_EXP_DTE;
	private String rWAE_STRT_DTE;
	private String rWAE_ACTN_DEST_TXT;
	private String rWAE_STATUS;
	
	public String getrWAE_BU_NBR() {
		return rWAE_BU_NBR;
	}
	public void setrWAE_BU_NBR(String rWAE_BU_NBR) {
		this.rWAE_BU_NBR = rWAE_BU_NBR;
	}
	public String getrWAE_PGM_NBR() {
		return rWAE_PGM_NBR;
	}
	public void setrWAE_PGM_NBR(String rWAE_PGM_NBR) {
		this.rWAE_PGM_NBR = rWAE_PGM_NBR;
	}
	public String getrWAE_TYP_CDE() {
		return rWAE_TYP_CDE;
	}
	public void setrWAE_TYP_CDE(String rWAE_TYP_CDE) {
		this.rWAE_TYP_CDE = rWAE_TYP_CDE;
	}
	public String getrWAE_ACTN_DEST_NBR() {
		return rWAE_ACTN_DEST_NBR;
	}
	public void setrWAE_ACTN_DEST_NBR(String rWAE_ACTN_DEST_NBR) {
		this.rWAE_ACTN_DEST_NBR = rWAE_ACTN_DEST_NBR;
	}
	public String getrWAE_RWDP_SEQ_NBR() {
		return rWAE_RWDP_SEQ_NBR;
	}
	public void setrWAE_RWDP_SEQ_NBR(String rWAE_RWDP_SEQ_NBR) {
		this.rWAE_RWDP_SEQ_NBR = rWAE_RWDP_SEQ_NBR;
	}
	public String getrWAE_EXP_DTE() {
		return rWAE_EXP_DTE;
	}
	public void setrWAE_EXP_DTE(String rWAE_EXP_DTE) {
		this.rWAE_EXP_DTE = rWAE_EXP_DTE;
	}
	public String getrWAE_STRT_DTE() {
		return rWAE_STRT_DTE;
	}
	public void setrWAE_STRT_DTE(String rWAE_STRT_DTE) {
		this.rWAE_STRT_DTE = rWAE_STRT_DTE;
	}
	public String getrWAE_ACTN_DEST_TXT() {
		return rWAE_ACTN_DEST_TXT;
	}
	public void setrWAE_ACTN_DEST_TXT(String rWAE_ACTN_DEST_TXT) {
		this.rWAE_ACTN_DEST_TXT = rWAE_ACTN_DEST_TXT;
	}
	public String getrWAE_STATUS() {
		return rWAE_STATUS;
	}
	public void setrWAE_STATUS(String rWAE_STATUS) {
		this.rWAE_STATUS = rWAE_STATUS;
	}
	public String getrWAE_UID() {
		return rWAE_UID;
	}
	public void setrWAE_UID(String rWAE_UID) {
		this.rWAE_UID = rWAE_UID;
	}
	
	 
	
	
	

}
