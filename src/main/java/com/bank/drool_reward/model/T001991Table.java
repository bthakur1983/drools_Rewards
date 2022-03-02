package com.bank.drool_reward.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.ToString;

@Document(collection = "T001991Table")
@JsonInclude(value=Include.NON_NULL)
@ToString
public class T001991Table {
	@Id
	private String CCNMI_BU_NBR;
	private String CCNMI_SYS_CDE;
	private String CCNMI_ACCT_NBR;
	private String CCNMI_TMS;
	private String CCNMI_SEQ_NBR;
	private String CCNMI_TRN_CDE;
	private String CCNMI_LGNID_NBR;
	private String CCNMI_BEF_DATA;
	private String CCNMI_AF_DATA;
	private String CCNMI_ENT_TMS;
	
	public String getCCNMI_BU_NBR() {
		return CCNMI_BU_NBR;
	}
	public void setCCNMI_BU_NBR(String cCNMI_BU_NBR) {
		CCNMI_BU_NBR = cCNMI_BU_NBR;
	}
	public String getCCNMI_SYS_CDE() {
		return CCNMI_SYS_CDE;
	}
	public void setCCNMI_SYS_CDE(String cCNMI_SYS_CDE) {
		CCNMI_SYS_CDE = cCNMI_SYS_CDE;
	}
	public String getCCNMI_ACCT_NBR() {
		return CCNMI_ACCT_NBR;
	}
	public void setCCNMI_ACCT_NBR(String cCNMI_ACCT_NBR) {
		CCNMI_ACCT_NBR = cCNMI_ACCT_NBR;
	}
	public String getCCNMI_TMS() {
		return CCNMI_TMS;
	}
	public void setCCNMI_TMS(String cCNMI_TMS) {
		CCNMI_TMS = cCNMI_TMS;
	}
	public String getCCNMI_SEQ_NBR() {
		return CCNMI_SEQ_NBR;
	}
	public void setCCNMI_SEQ_NBR(String cCNMI_SEQ_NBR) {
		CCNMI_SEQ_NBR = cCNMI_SEQ_NBR;
	}
	public String getCCNMI_TRN_CDE() {
		return CCNMI_TRN_CDE;
	}
	public void setCCNMI_TRN_CDE(String cCNMI_TRN_CDE) {
		CCNMI_TRN_CDE = cCNMI_TRN_CDE;
	}
	public String getCCNMI_LGNID_NBR() {
		return CCNMI_LGNID_NBR;
	}
	public void setCCNMI_LGNID_NBR(String cCNMI_LGNID_NBR) {
		CCNMI_LGNID_NBR = cCNMI_LGNID_NBR;
	}
	public String getCCNMI_BEF_DATA() {
		return CCNMI_BEF_DATA;
	}
	public void setCCNMI_BEF_DATA(String cCNMI_BEF_DATA) {
		CCNMI_BEF_DATA = cCNMI_BEF_DATA;
	}
	public String getCCNMI_AF_DATA() {
		return CCNMI_AF_DATA;
	}
	public void setCCNMI_AF_DATA(String cCNMI_AF_DATA) {
		CCNMI_AF_DATA = cCNMI_AF_DATA;
	}
	public String getCCNMI_ENT_TMS() {
		return CCNMI_ENT_TMS;
	}
	public void setCCNMI_ENT_TMS(String cCNMI_ENT_TMS) {
		CCNMI_ENT_TMS = cCNMI_ENT_TMS;
	}
	


}
