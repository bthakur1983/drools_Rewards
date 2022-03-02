package com.bank.drool_reward.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.ToString;

@Document(collection = "T001750Table")
@JsonInclude(value= JsonInclude.Include.NON_NULL)
@ToString
public class T001750Table 
{
	 	@Id
	    private String dTASRS_ID;
	    private String rWDP_PGM_NBR;
	    private String rWDP_SEQ_NBR;
		public String getdTASRS_ID() {
			return dTASRS_ID;
		}
		public void setdTASRS_ID(String dTASRS_ID) {
			this.dTASRS_ID = dTASRS_ID;
		}
		public String getrWDP_PGM_NBR() {
			return rWDP_PGM_NBR;
		}
		public void setrWDP_PGM_NBR(String rWDP_PGM_NBR) {
			this.rWDP_PGM_NBR = rWDP_PGM_NBR;
		}
 
		public String getrWDP_SEQ_NBR() {
			return rWDP_SEQ_NBR;
		}
		public void setrWDP_SEQ_NBR(String rWDP_SEQ_NBR) {
			this.rWDP_SEQ_NBR = rWDP_SEQ_NBR;
		}
	    
	    
	    
	    

}
