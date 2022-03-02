package com.bank.drool_reward.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T000070Table")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@ToString
public class T000070Table {

    @Id
    private String cGSE_LGN_ID_NBR; //As Mention UID Comming from Flows  CG0l4763
    private String cGSE_SYS_EVT_TYP;
    private String cGSE_SYS_EVT_NBR;
    private String cGSE_STRT_TMS;
    private String cGSE_SYS_EVT_TXT;
    private String cGSE_END_TMS;
    private String cGSE_PRC_DTE;

    public String getcGSE_SYS_EVT_TYP() {
        return cGSE_SYS_EVT_TYP;
    }

    public void setcGSE_SYS_EVT_TYP(String cGSE_SYS_EVT_TYP) {
        this.cGSE_SYS_EVT_TYP = cGSE_SYS_EVT_TYP;
    }

    public String getcGSE_SYS_EVT_NBR() {
        return cGSE_SYS_EVT_NBR;
    }

    public void setcGSE_SYS_EVT_NBR(String cGSE_SYS_EVT_NBR) {
        this.cGSE_SYS_EVT_NBR = cGSE_SYS_EVT_NBR;
    }

    public String getcGSE_STRT_TMS() {
        return cGSE_STRT_TMS;
    }

    public void setcGSE_STRT_TMS(String cGSE_STRT_TMS) {
        this.cGSE_STRT_TMS = cGSE_STRT_TMS;
    }

    public String getcGSE_SYS_EVT_TXT() {
        return cGSE_SYS_EVT_TXT;
    }

    public void setcGSE_SYS_EVT_TXT(String cGSE_SYS_EVT_TXT) {
        this.cGSE_SYS_EVT_TXT = cGSE_SYS_EVT_TXT;
    }

    public String getcGSE_END_TMS() {
        return cGSE_END_TMS;
    }

    public void setcGSE_END_TMS(String cGSE_END_TMS) {
        this.cGSE_END_TMS = cGSE_END_TMS;
    }

    public String getcGSE_PRC_DTE() {
        return cGSE_PRC_DTE;
    }

    public void setcGSE_PRC_DTE(String cGSE_PRC_DTE) {
        this.cGSE_PRC_DTE = cGSE_PRC_DTE;
    }

    public String getcGSE_LGN_ID_NBR() {
        return cGSE_LGN_ID_NBR;
    }

    public void setcGSE_LGN_ID_NBR(String cGSE_LGN_ID_NBR) {
        this.cGSE_LGN_ID_NBR = cGSE_LGN_ID_NBR;
    }
}
