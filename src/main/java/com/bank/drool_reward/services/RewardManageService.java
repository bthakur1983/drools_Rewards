package com.bank.drool_reward.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.drools.ecj.EclipseCompilationProblem;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.drool_reward.dto.RewardManage;
import com.bank.drool_reward.model.T000070Table;
import com.bank.drool_reward.model.T000820Table;
import com.bank.drool_reward.model.T000871Table;
import com.bank.drool_reward.model.T000899Table;
import com.bank.drool_reward.model.T001750Table;
import com.bank.drool_reward.model.T001754Table;
import com.bank.drool_reward.model.T001906Table;
import com.bank.drool_reward.model.T001991Table;
import com.bank.drool_reward.model.T003922Table;
import com.bank.drool_reward.repository.T000070Repo;
import com.bank.drool_reward.repository.T000820Repo;
import com.bank.drool_reward.repository.T000899Repo;
import com.bank.drool_reward.repository.T001750Repo;
import com.bank.drool_reward.repository.T001754Repo;
import com.bank.drool_reward.repository.T001906Repo;
import com.bank.drool_reward.repository.T001991Repo;
import com.bank.drool_reward.repository.T003922Repo;
import com.bank.drool_reward.util.ComponentConstantString;
import com.bank.drool_reward.util.DataConversion;
import com.bank.drool_reward.util.RuleUtility;

@Service
public class RewardManageService {
	@Autowired
	T000070Repo t000070Repo;
	@Autowired
	T000820Repo t000820Repo;
	@Autowired
	T001991Repo t001991Repo;
	@Autowired
	T000899Repo t000899Repo;
	@Autowired
	T001906Repo t001906Repo;
	@Autowired
	T003922Repo t003922Repo;	
	@Autowired
	T001750Repo t001750Repo;
	@Autowired
	T001754Repo t001754Repo;
	static SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	public static final String EVT_TYP = "FAE";
	public static final String EVT_NBR = "1";
	public static final String login_Id = "CGOL4763";
	public Date globalStartDate = null;
	public Date globalExpireDate = null;
	public Date convertCutOffTime = null;

	T000820Table t000820Table;
	T000899Table t000899Table;
	boolean islessDate;
	boolean isCutoffDateCheck;
	String dest_nbr = null;
	String buNum = null;
	String pgmNum = null;
	String typCode = null;
	String rwdpSeqNbr = null;
	String startDate1 = null;
	String expDate = null;
	String destTxt = null;
	String UnQacID = null;
	String wacc_rwdp_bu_nbr = null;
	String waccPgmNbr = null;
	String waccrwdpSeqNbr = null;
	T000820Table t000820TableObj;
	RuleUtility ruleUtil = new RuleUtility();
	public String  Hrs;
	public String  Min;
	@Autowired
	private KieContainer kContainer;
	
	private boolean isSuccess = false;

	public T000070Table saveDataInaddT000070Table(T000070Table obj) {

		t000070Repo.save(obj);

		return obj;
	}

	public String saveT001991Data(T001991Table request) {
		t001991Repo.save(request);
		return "Success";
	}
	
	public T001750Table saveT001750Table(T001750Table obj) {

		t001750Repo.save(obj);
		return obj;
	}
	
	public T001754Table saveT001754Table(T001754Table obj) {

		t001754Repo.save(obj);
		return obj;
	}
	
	
public void getCutOfTime(RewardManage rewardManage, RewardManageService rewardManageService)throws ParseException 
{
	//convertCutOffTime = sdformat.parse(cutOffTime);
	//Date currentDate = new Date();
	T000070Table t000070Table = t000070Repo.findBySYS_EVT_TYPAndSYS_EVT_NBRAndLGN_ID_NBR(EVT_TYP, EVT_NBR,login_Id);
	String cutOffTime = t000070Table.getcGSE_SYS_EVT_TXT();
	Hrs = cutOffTime.substring(0, 2);
	Min = cutOffTime.substring(2,cutOffTime.length());
	ruleUtil.executeRuleForCutOfTime(rewardManage,t000070Table, kContainer, rewardManageService);
	/*int value = DataConversion.compareTimeWithCurrentTime(Hrs, Min);
	if(value>0)
	{
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, 1); // Date With +1 day from the current date
		dt = c.getTime();
		globalStartDate = dt;
		globalExpireDate = currentDate;
	}
	else
	{
		Date dt1 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, -1); // Date With -1 day from the current date
		dt1 = c.getTime();
		globalStartDate = currentDate;
		globalExpireDate = dt1;
	}
	*/
	
	
}
	

	public void updateExpDateInt000820(T000820Table t00820Obj ,Date expDate)
	{
		 
		try
		{
		String dateExpireLogic = sdformat.format(globalExpireDate);
		t00820Obj.setrWAE_EXP_DTE(dateExpireLogic);
		t000820Repo.save(t00820Obj);
		 
		}
		catch(Exception e)
		{
			
		}
		 
	}
	
	public boolean insertRecoredInT001991Table(T001991Table t001991TableObj)
	{
		boolean returnVal = false;
		try
		{
			t001991TableObj = t001991Repo.save(t001991TableObj);
			returnVal = true;
			
		}
		catch(Exception e)
		{
			
		}
		return returnVal;
	}

	public Map<String, String> updateRewardActionTable(String uid,RewardManage rewardManage) throws ParseException 
	{
		Map<String, String>returnMap = new HashMap<String, String>();
		try
		{
			T000820Table t000820DateLogicRecord = t000820Repo.findByData(uid,ComponentConstantString.BU_NUM,ComponentConstantString.PG_NUM,ComponentConstantString.TYP_CDE,ComponentConstantString.ACTN_DEST_NBR);
			T001991Table t001991TableObj = new T001991Table();
			if (rewardManage.getEarnType().equals("REM") ||rewardManage.getEarnType().equals("QTR") || rewardManage.getEarnType().equals("ONE") ) 
			{
	
				if (t000820DateLogicRecord != null)
				{
					    updateExpDateInt000820(t000820DateLogicRecord,globalExpireDate);
						String sequenceNo = t000820DateLogicRecord.getrWAE_RWDP_SEQ_NBR();
						long sequenceNO = Long.parseLong(sequenceNo);
						sequenceNO = sequenceNO + 1;
											
						t001991TableObj.setCCNMI_BU_NBR(t000820DateLogicRecord.getrWAE_BU_NBR());
						t001991TableObj.setCCNMI_SEQ_NBR(String.valueOf(sequenceNO));
						insertRecoredInT001991Table(t001991TableObj);
						returnMap.put("STATUS", "SUCCESS");
				}
				
			
				else 
				{
					returnMap.put("STATUS", "Fail");
					returnMap.put("ERROR", "Active Record Does Not Exist in Table T000820");
					 
				}
	
			}
	
			else 
			{
		
					if (t000820DateLogicRecord != null)
					{
						updateExpDateInt000820(t000820DateLogicRecord,globalExpireDate);
						String sequenceNo = t000820DateLogicRecord.getrWAE_RWDP_SEQ_NBR();
						long sequenceNO = Long.parseLong(sequenceNo);
						sequenceNO = sequenceNO + 1;
						t001991TableObj.setCCNMI_BU_NBR(t000820DateLogicRecord.getrWAE_BU_NBR());
						t001991TableObj.setCCNMI_SEQ_NBR(String.valueOf(sequenceNO));
						insertRecoredInT001991Table(t001991TableObj);
						returnMap.put("STATUS", "SUCCESS");
	
					} 
					else
					{
					String sequenceNo = t000820DateLogicRecord.getrWAE_RWDP_SEQ_NBR();
					long sequenceNO = Long.parseLong(sequenceNo);
					sequenceNO = sequenceNO + 1;
					t001991TableObj.setCCNMI_BU_NBR(t000820DateLogicRecord.getrWAE_BU_NBR());
					t001991TableObj.setCCNMI_SEQ_NBR(String.valueOf(sequenceNO));
					insertRecoredInT001991Table(t001991TableObj);
					returnMap.put("STATUS", "SUCCESS");
					}
	
			}
		}
		catch(Exception e)
		{
			returnMap.put("STATUS", "Fail");
			
		}
		return returnMap;
	}

	public Map<String, String> getRewardManage(RewardManage rewardManage, RewardManageService rewardManageService)
	{
		Map<String, String> map = new HashMap<String, String>();
		T003922Table tb = new T003922Table();
		ruleUtil.executeRuleForManage(rewardManage, tb, kContainer, rewardManageService);
		if (tb.isValidRequest()) 
		{
			ruleUtil.executeRuleForManage(rewardManage, tb, kContainer, rewardManageService);
			String EacToUid = tb.getaCCT_UID();

			if (EacToUid == null && rewardManage.getKeyType().equals(ComponentConstantString.UID_TYPE))
			{
				EacToUid = rewardManage.getPrimaryKey();
			}
			else if(EacToUid == null && rewardManage.getKeyType().equals(ComponentConstantString.EAC_TYPE))
        	{
        		 map.put("Error", "UID is Not Available in DB");
        		 return map;
        	}
			try 
			{
				if (rewardManage.getVersionNumber().equals(ComponentConstantString.VERSION_NUM)) 
				{
					if(isValidateDataSurceIdAndProcess(rewardManage.getDataSourceId(),rewardManage.getBuisnessProcess(),rewardManage.getBuisnessSubprocess()))
					{
						getCutOfTime(rewardManage,rewardManageService);
						map = updateRewardActionTable(EacToUid,rewardManage);
					}
					else
					{
						map.put("Error", "Data is not valid in T001754Table OR T001750Table");
					}
				}
					 
			}
			catch (Exception e) {

				map.put("Error", "Data is Not Available in DB");
			}
		}
		else {
			map.put("Error", "Invalid Properties, should be AlphaNumeric..");

		}
		return map;
	}
	
	
	public boolean isValidateDataSurceIdAndProcess(String dataSourceId,String businessPr,String businessSubPr)
	{
		boolean result = false;
		try
    	{
			Optional<T001750Table> T001750Obj =  t001750Repo.findById(dataSourceId);
			T001754Table T001754Obj = t001754Repo .findByBusniessProcess(businessPr,businessSubPr);
			if(T001750Obj.get() != null && T001754Obj != null)
			 result= true;

    	}
		catch(Exception e)
		{
			
		}
		return result;
	}
	public String fetchUId(String primaryKey) {

		String UID = null;
		try {
			T001906Table s = getIACValue(primaryKey);
			String IAC = s.geteAC_IAC_ID();

			UID = getUIDFromT003922Table(IAC).getaCCT_UID();

		} catch (Exception e) {

		}

		return UID;
	}
	
	public T001906Table getIACValue(String eac) {

		Optional<T001906Table> data = t001906Repo.findById(eac);

		return data.isPresent() ? data.get() : null;

	}
	public T003922Table getUIDFromT003922Table(String iac) {

		Optional<T003922Table> data = t003922Repo.findById(iac);

		return data.isPresent() ? data.get() : null;

	}


}
