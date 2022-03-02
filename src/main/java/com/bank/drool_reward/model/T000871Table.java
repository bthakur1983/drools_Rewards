package com.bank.drool_reward.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "T000871Table")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@ToString
public class T000871Table {

    @Id
    private String rWDP_UID;
    private String rWDP_BU_NBR;
    private String rWDP_PGM_NBR;
    private String rWDP_ACCT_NBR;
    private String rWDP_CNTLDP_PART_NBR;
    private String rWDP_SEQ_NBR;
    
    
    
    
    public String getrWDP_UID() {
		return rWDP_UID;
	}

	public void setrWDP_UID(String rWDP_UID) {
		this.rWDP_UID = rWDP_UID;
	}

	public String getrWDP_BU_NBR() {
        return rWDP_BU_NBR;
    }

    public void setrWDP_BU_NBR(String rWDP_BU_NBR) {
        this.rWDP_BU_NBR = rWDP_BU_NBR;
    }

    public String getrWDP_PGM_NBR() {
        return rWDP_PGM_NBR;
    }

    public void setrWDP_PGM_NBR(String rWDP_PGM_NBR) {
        this.rWDP_PGM_NBR = rWDP_PGM_NBR;
    }

    public String getrWDP_ACCT_NBR() {
        return rWDP_ACCT_NBR;
    }

    public void setrWDP_ACCT_NBR(String rWDP_ACCT_NBR) {
        this.rWDP_ACCT_NBR = rWDP_ACCT_NBR;
    }

    public String getrWDP_CNTLDP_PART_NBR() {
        return rWDP_CNTLDP_PART_NBR;
    }

    public void setrWDP_CNTLDP_PART_NBR(String rWDP_CNTLDP_PART_NBR) {
        this.rWDP_CNTLDP_PART_NBR = rWDP_CNTLDP_PART_NBR;
    }

    public String getrWDP_SEQ_NBR() {
        return rWDP_SEQ_NBR;
    }

    public void setrWDP_SEQ_NBR(String rWDP_SEQ_NBR) {
        this.rWDP_SEQ_NBR = rWDP_SEQ_NBR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T000871Table that = (T000871Table) o;
        return Objects.equals(rWDP_BU_NBR, that.rWDP_BU_NBR) && Objects.equals(rWDP_PGM_NBR, that.rWDP_PGM_NBR) && Objects.equals(rWDP_ACCT_NBR, that.rWDP_ACCT_NBR) && Objects.equals(rWDP_CNTLDP_PART_NBR, that.rWDP_CNTLDP_PART_NBR) && Objects.equals(rWDP_SEQ_NBR, that.rWDP_SEQ_NBR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rWDP_BU_NBR, rWDP_PGM_NBR, rWDP_ACCT_NBR, rWDP_CNTLDP_PART_NBR, rWDP_SEQ_NBR);
    }
}
