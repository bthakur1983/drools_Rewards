package com.bank.drool_reward.services;

import com.bank.drool_reward.config.RulesConfigure;
import com.bank.drool_reward.dto.RewardStatus;
import com.bank.drool_reward.dto.RewardStatusGeneric;
import com.bank.drool_reward.model.T000820Table;
import com.bank.drool_reward.model.T000871Table;
import com.bank.drool_reward.model.T000899Table;
import com.bank.drool_reward.model.T001906Table;
import com.bank.drool_reward.model.T003922Table;
import com.bank.drool_reward.repository.T000820Repo;
import com.bank.drool_reward.repository.T000871Repo;
import com.bank.drool_reward.repository.T000899Repo;
import com.bank.drool_reward.repository.T001906Repo;
import com.bank.drool_reward.repository.T003922Repo;
import com.bank.drool_reward.util.ComponentConstantString;
import com.bank.drool_reward.util.DataConversion;
import com.bank.drool_reward.util.RuleUtility;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class RewardStatusService 
{

//	@Autowired
//	private  KieContainer kContainer;
//	
//	@Autowired
//	public RewardStatusService(KieContainer kieContainer)
//	{
//		this.kContainer = kieContainer;
//	}
	@Autowired
	RulesConfigure ruleConfig;
	

	
    public RewardStatus rewardStatus = new RewardStatus();
    @Autowired
    T001906Repo t001906Repo;
    @Autowired
    T003922Repo t003922Repo;
    @Autowired
    T000820Repo t000820Repo;
    @Autowired
    T000899Repo t000899Repo;
    @Autowired
    T000871Repo t000871Repo;

    
    public String EacToUid;
    
    
    public List<T003922Table> dataT003922Table = null;
    public Optional<T000899Table> dataT000899Table = null;
    public Optional<T000871Table> dataT000871Table = null;
    
    public Map<String, String>map=new HashMap<String, String>();

    boolean primaryKey;
    public String versionNo = null;
    RuleUtility ruleUtil=new RuleUtility();
    
    public Map<String, String> getRewardStatus(RewardStatus rewardStatus,RewardStatusService rewardStatusService) {
 
    	T000820Table T000820Obj = new T000820Table();
    	Map<String, String>map=new LinkedHashMap<String, String>();
  	
		T003922Table tb=new T003922Table();
		//ruleUtil.executeRule(ruleConfig.getkContainer(),rewardStatus, tb,rewardStatusService);
		ruleUtil.executeRule(rewardStatus, tb,ruleConfig.getkContainer(),rewardStatusService);
		 if (tb.isValidRequest())
	     {
			//ruleUtil.executeRule(ruleConfig.getkContainer(),rewardStatus, tb,rewardStatusService);
        	EacToUid = tb.getaCCT_UID();
        	
        	if(EacToUid == null)
         	{
         		 map.put("Error", "UID is Not Available in DB");
         		 return map;
         	}
        		
	        	try
	        	{
            		if(rewardStatus.getVersionNumber().equals(ComponentConstantString.VERSION_NUM))
            		{
            			
            			ruleUtil.executeRuleForValidateRequestCode(rewardStatus,ruleConfig.getkContainer(),rewardStatusService);
            			if(rewardStatus.isValidRequest())
            			{
            				T000820Obj.setrWAE_TYP_CDE(ComponentConstantString.TYP_CDE);
            				T000820Obj.setrWAE_ACTN_DEST_NBR(ComponentConstantString.ACTN_DEST_NBR);
            				
            			}
            			else
            			{
            				map.put("Error", "RequestCode OR DataSourceID Invalid..");
            				return map;
            			}
            			T000899Table T000899obj = getRewardProgramData(t000899Repo,t000871Repo,t003922Repo,rewardStatusService); 
            			if(T000899obj != null)
            			{
            					T000820Obj = getRewardAction(EacToUid,T000899obj.getrWDP_BU_NBR(),T000899obj.getrWACC_PGM_NBR(),ComponentConstantString.TYP_CDE,ComponentConstantString.ACTN_DEST_NBR);
			        			if(T000820Obj != null)
			        			{
			        				validateRewardAction(rewardStatus,T000820Obj,rewardStatusService);
			        				map.put("keyValue", rewardStatus.getPrimaryKey());
				                    map.put("keyType", rewardStatus.getKeyType());
				                    map.put("recordStatus", T000820Obj.getrWAE_STATUS());
				                    map.put("earnType", T000820Obj.getrWAE_ACTN_DEST_TXT());
				                    map.put("expData", T000820Obj.getrWAE_EXP_DTE());
				                    map.put("effectiveData", T000820Obj.getrWAE_STRT_DTE());
			        			}
			        			else
			        			{
			                    map.put("keyValue", rewardStatus.getPrimaryKey());
			                    map.put("keyType", rewardStatus.getKeyType());
			                    map.put("recordStatus",ComponentConstantString.REWARD_STATUS_INACTIVE);
			                    map.put("earnType", "");
			                    map.put("expData", "");
			                    map.put("effectiveData", "");
			        			}
            			}
            			else
            			{
            				map.put("Error", "Data is Not Available for Get Reward Program  ");
            			}
        			}
            		else
            		{
            			map.put("Error", "Input Version No Should be 01");
            		}
	        	}
        		catch (Exception e)
        		{
                   
                     map.put("Error", "Data is Not Available in DB");
        		}
        	 

        }
        else 
        {
        	map.put("Error", "Invalid Properties, Check Input Parameters" );
           
        }


        return map;


    }

    
    
	public String fetchUId(String primaryKey)
	{
		
		String UID = null;
		try
		{
			T001906Table s = getIACValue(primaryKey);
			String IAC = s.geteAC_IAC_ID();
		
			UID = getUIDFromT003922Table(IAC).getaCCT_UID();
            

        }catch (Exception e)
    	{
           
             
        }
		
		
		return UID;
	}
    
    public void validateRewardAction(RewardStatus rewardStatus,T000820Table data,RewardStatusService rewardStatusService)throws Exception
    {
    	
    	  
    		
    		 ruleUtil.executeRuleCheckExpDate(rewardStatus, data,ruleConfig.getkContainer(),rewardStatusService);
    		          	                   	
         
    }
    
    
    public T000820Table getRewardAction(String uid,String bu_num,String prog_num,String typeCode,String destNum)
    {
    	
    	
    	return t000820Repo.findByData(uid,bu_num,prog_num,typeCode,destNum);
    	
    	 
    }
    
    
    public T001906Table getIACValue(String eac) {


        Optional<T001906Table> data = t001906Repo.findById(eac);

        return data.isPresent() ? data.get() : null;


    }


    public T003922Table getUIDFromT003922Table(String iac) {


        Optional<T003922Table> data = t003922Repo.findById(iac);

        return data.isPresent() ? data.get() : null;


    }


    public String saveData(T001906Table obj) {
        t001906Repo.save(obj);

        return "Data Saved";
    }

    public void saveDataInT003922Table(T003922Table obj1) {

        t003922Repo.save(obj1);

    }
    
	public void saveDataInT000820Table(T000820Table obj)
	{
		 
		t000820Repo.save(obj);
		
	}


    public String findRecord(String id) {

        t001906Repo.findById(id);
        return "Found";
    }

    public List<T001906Table> getT001906Table() {

        return t001906Repo.findAll();
    }
    
    public List<T003922Table> getT003922Table() {

        return t003922Repo.findAll();
    }

    public String insertDataInT000871Table(T000871Table obj) {


    	t000871Repo.save(obj);

        return "Data Inserted in Table T000871Table ";

    }

    public String insertDataInT000899Table(T000899Table obj1) {

    	t000899Repo.save(obj1);

        return "Data insert in table T000899Table ";

    }
    
    public T000899Table getRewardProgramData(T000899Repo repo899,T000871Repo repo871,T003922Repo repo3922,RewardStatusService rewardStatusService) 
    {
    	try
    	{
    		T000899Table obj899 = new T000899Table();
    		T000871Table obj871 = new T000871Table();
    		T003922Table obj922 = new T003922Table();

    		
    		ruleUtil.executeRuleForRewardProgram(repo899,repo871,repo3922,obj899,obj871,obj922,ruleConfig.getkContainer(),rewardStatusService);
    		 
    		if(obj899 != null && obj871 != null && obj922 != null)
	    	{
	    		if(obj899.getrWACC_RWDP_BU_NBR().equals(obj871.getrWDP_BU_NBR()) &&
	    				obj899.getrWACC_PGM_NBR().equals(obj871.getrWDP_PGM_NBR()) &&
	    				obj922.getaCCT_BU_NBR().equals(obj899.getrWDP_BU_NBR()) && 
	    				obj922.getaCCT_SYS_CDE().equals(obj899.getrWACC_SYS_CDE()))
	    		{
	    		return obj899;
	    		}
	    		else
	    		{
	    			return null;
	    		}
	    	}
    		
	    	/*T000899Table T000899Obj =  t000899Repo.findByUIDAndBU_NBR(EacToUid,BU_NUM,systemCode);
	    	T000871Table T000871Obj = 	t000871Repo.findByUIDAndBU_NBR(EacToUid,BU_NUM);
	    	T003922Table T003922Obj =  t003922Repo.findByUIDAndBU_NBR(EacToUid,BU_NUM);
	    	
	    	if(T000899Obj != null && T000871Obj != null && T003922Obj != null)
	    	{
	    		if(T000899Obj.getrWACC_RWDP_BU_NBR().equals(T000871Obj.getrWDP_BU_NBR()) &&
	    			T000899Obj.getrWACC_PGM_NBR().equals(T000871Obj.getrWDP_PGM_NBR()) &&
	    			T003922Obj.getaCCT_BU_NBR().equals(T000899Obj.getrWDP_BU_NBR()) && 
	    			T003922Obj.getaCCT_SYS_CDE().equals(T000899Obj.getrWACC_SYS_CDE()))
	    		{
	    		return T000899Obj;
	    		}
	    		else
	    		{
	    			return null;
	    		}
	    	}*/
	    	
    	}
    	catch(Exception e)
    	{
    		return null;
    	}
    	return null;
    	
      
    } 
    	
    public Map<String, String> RewardStatusGenericRulesCheck(RewardStatusGeneric obj) 
    {
    	Map<String, String>map=new LinkedHashMap<String, String>();
    	ruleUtil.executeGenericRule(obj,ruleConfig.getkContainer());
    	if(obj.isValidRequest())
    	{
    		map.put("Result", "SUCCESS");
    		map.put("RewardStatus", obj.geteAC_Status());
    	}
    	else
    		map.put("Result", "FAIL");
    	
    	return map;
   	 
   	  
    }

    	

}
