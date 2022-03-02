package com.bank.drool_reward.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "T000899Table")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@ToString
public class T000899Table {

    @Id
    private String rWACC_UID;
    private String rWDP_BU_NBR;
    private String rWACC_RWDP_BU_NBR; 
    private String rWACC_PGM_NBR;
    private String rWACC_ACCT_NBR;
    private String rWACC_CNTLDP_PART_NBR;
    private String rWACC_RWDP_SEQ_NBR;
    private String rWACC_SYS_CDE;
    
    

    public String getrWACC_UID() {
		return rWACC_UID;
	}

	public void setrWACC_UID(String rWACC_UID) {
		this.rWACC_UID = rWACC_UID;
	}

	public String getrWACC_RWDP_BU_NBR() {
        return rWACC_RWDP_BU_NBR;
    }

    public void setrWACC_RWDP_BU_NBR(String rWACC_RWDP_BU_NBR) {
        this.rWACC_RWDP_BU_NBR = rWACC_RWDP_BU_NBR;
    }

    public String getrWACC_PGM_NBR() {
        return rWACC_PGM_NBR;
    }

    public void setrWACC_PGM_NBR(String rWACC_PGM_NBR) {
        this.rWACC_PGM_NBR = rWACC_PGM_NBR;
    }

    public String getrWACC_ACCT_NBR() {
        return rWACC_ACCT_NBR;
    }

    public void setrWACC_ACCT_NBR(String rWACC_ACCT_NBR) {
        this.rWACC_ACCT_NBR = rWACC_ACCT_NBR;
    }

    public String getrWACC_CNTLDP_PART_NBR() {
        return rWACC_CNTLDP_PART_NBR;
    }

    public void setrWACC_CNTLDP_PART_NBR(String rWACC_CNTLDP_PART_NBR) {
        this.rWACC_CNTLDP_PART_NBR = rWACC_CNTLDP_PART_NBR;
    }

    public String getrWACC_RWDP_SEQ_NBR() {
        return rWACC_RWDP_SEQ_NBR;
    }

    public void setrWACC_RWDP_SEQ_NBR(String rWACC_RWDP_SEQ_NBR) {
        this.rWACC_RWDP_SEQ_NBR = rWACC_RWDP_SEQ_NBR;
    }

    public String getrWDP_BU_NBR() {
        return rWDP_BU_NBR;
    }

    public void setrWDP_BU_NBR(String rWDP_BU_NBR) {
        this.rWDP_BU_NBR = rWDP_BU_NBR;
    }

    public String getrWACC_SYS_CDE() {
        return rWACC_SYS_CDE;
    }

    public void setrWACC_SYS_CDE(String rWACC_SYS_CDE) {
        this.rWACC_SYS_CDE = rWACC_SYS_CDE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T000899Table that = (T000899Table) o;
        return Objects.equals(rWACC_RWDP_BU_NBR, that.rWACC_RWDP_BU_NBR) && Objects.equals(rWACC_PGM_NBR, that.rWACC_PGM_NBR) && Objects.equals(rWACC_ACCT_NBR, that.rWACC_ACCT_NBR) && Objects.equals(rWACC_CNTLDP_PART_NBR, that.rWACC_CNTLDP_PART_NBR) && Objects.equals(rWACC_RWDP_SEQ_NBR, that.rWACC_RWDP_SEQ_NBR) && Objects.equals(rWDP_BU_NBR, that.rWDP_BU_NBR) && Objects.equals(rWACC_SYS_CDE, that.rWACC_SYS_CDE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rWACC_RWDP_BU_NBR, rWACC_PGM_NBR, rWACC_ACCT_NBR, rWACC_CNTLDP_PART_NBR, rWACC_RWDP_SEQ_NBR, rWDP_BU_NBR, rWACC_SYS_CDE);
    }
}
