package com.bank.drool_reward.util;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.drool_reward.dto.RewardManage;
import com.bank.drool_reward.dto.RewardStatus;
import com.bank.drool_reward.dto.RewardStatusGeneric;
import com.bank.drool_reward.model.T000070Table;
import com.bank.drool_reward.model.T000820Table;
import com.bank.drool_reward.model.T000871Table;
import com.bank.drool_reward.model.T000899Table;
import com.bank.drool_reward.model.T003922Table;
import com.bank.drool_reward.repository.T000871Repo;
import com.bank.drool_reward.repository.T000899Repo;
import com.bank.drool_reward.repository.T003922Repo;
import com.bank.drool_reward.services.RewardManageService;
import com.bank.drool_reward.services.RewardStatusService;

public class RuleUtility 
{

	KieSession kieSession = null;
	
	public void executeRule(RewardStatus rewardStatus,T003922Table tb,KieContainer kieContainer,RewardStatusService rewardStatusService){
		//KieSession kieSession = kContainer.newKieSession();
		//KieSession kieSession = null;
		kieSession = kieContainer.newKieSession("rulesStatusSession");
		kieSession.insert(tb);
		kieSession.insert(rewardStatus);
		kieSession.setGlobal( "rewardStatusService", rewardStatusService);
		kieSession.fireAllRules();
		kieSession.dispose();
		}
	public void executeRuleForValidateRequestCode(RewardStatus rewardStatus,KieContainer kContainer,RewardStatusService rewardStatusService){
		kieSession = kContainer.newKieSession("rulesStatusSession");
		kieSession.insert(rewardStatus);
		kieSession.setGlobal( "rewardStatusService", rewardStatusService);
		kieSession.fireAllRules();
		kieSession.dispose();
		}
	
	public void executeRuleForRewardProgram(T000899Repo repo899,T000871Repo repo871,T003922Repo repo3922,T000899Table tb899,T000871Table tb871,T003922Table tb922,KieContainer kContainer,RewardStatusService rewardStatusService){
		//KieSession kieSession = kContainer.newKieSession();
		kieSession = kContainer.newKieSession("rulesStatusSession");
		kieSession.insert(tb899);
		kieSession.insert(tb871);
		kieSession.insert(tb922);
		kieSession.setGlobal( "rewardStatusService", rewardStatusService);
		kieSession.setGlobal( "repo899", repo899);
		kieSession.setGlobal( "repo871", repo871);
		kieSession.setGlobal( "repo3922", repo3922);
		kieSession.fireAllRules();
		kieSession.dispose();
		}
	
	public void executeRuleCheckExpDate(RewardStatus rewardStatus,T000820Table data,KieContainer kContainer,RewardStatusService rewardStatusService){
		kieSession = kContainer.newKieSession("rulesStatusSession");
		kieSession.insert(data);
		kieSession.insert(rewardStatus);

		kieSession.setGlobal( "rewardStatusService", rewardStatusService);
		kieSession.fireAllRules();
		kieSession.dispose();
		}
	
	public void executeRuleForManage(RewardManage rewardManage,T003922Table tb,KieContainer kContainer,RewardManageService rewardManageService)
	{
		kieSession = kContainer.newKieSession("rulesManageSession");
		kieSession.insert(tb);
		kieSession.insert(rewardManage);

		kieSession.setGlobal( "rewardManageService", rewardManageService);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
	public void executeRuleForCutOfTime(RewardManage rewardManage,T000070Table table,KieContainer kContainer,RewardManageService rewardManageService)
	{
		kieSession = kContainer.newKieSession("rulesManageSession");
		kieSession.insert(rewardManage);
		kieSession.insert(table);
		kieSession.setGlobal( "rewardManageService", rewardManageService);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
	public void executeGenericRule(RewardStatusGeneric rewardStatusGenericTable,KieContainer kieContainer){

		kieSession = kieContainer.newKieSession("rulesStatusSession");
		//kieSession.insert(tb);
		kieSession.insert(rewardStatusGenericTable);
		//kieSession.setGlobal( "rewardStatusService", rewardStatusService);
		kieSession.fireAllRules();
		kieSession.dispose();
		}

}
