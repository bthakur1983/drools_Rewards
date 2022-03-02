package com.bank.drool_reward.util;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.drool_reward.dto.RewardManage;
import com.bank.drool_reward.dto.RewardStatus;
import com.bank.drool_reward.model.T000070Table;
import com.bank.drool_reward.model.T000820Table;
import com.bank.drool_reward.model.T003922Table;
import com.bank.drool_reward.services.RewardManageService;
import com.bank.drool_reward.services.RewardStatusService;

public class RuleUtility {

	public void executeRule(RewardStatus rewardStatus,T003922Table tb,KieContainer kContainer,RewardStatusService rewardStatusService){
		KieSession kieSession = kContainer.newKieSession();
		kieSession.insert(tb);
		kieSession.insert(rewardStatus);

		kieSession.setGlobal( "rewardStatusService", rewardStatusService);
		kieSession.fireAllRules();
		kieSession.dispose();
		}
	
	public void executeRuleCheckExpDate(RewardStatus rewardStatus,T000820Table data,KieContainer kContainer,RewardStatusService rewardStatusService){
		KieSession kieSession = kContainer.newKieSession();
		kieSession.insert(data);
		kieSession.insert(rewardStatus);

		kieSession.setGlobal( "rewardStatusService", rewardStatusService);
		kieSession.fireAllRules();
		kieSession.dispose();
		}
	
	public void executeRuleForManage(RewardManage rewardManage,T003922Table tb,KieContainer kContainer,RewardManageService rewardManageService)
	{
		KieSession kieSession = kContainer.newKieSession();
		kieSession.insert(tb);
		kieSession.insert(rewardManage);

		kieSession.setGlobal( "rewardManageService", rewardManageService);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	
	public void executeRuleForCutOfTime(RewardManage rewardManage,T000070Table table,KieContainer kContainer,RewardManageService rewardManageService)
	{
		KieSession kieSession = kContainer.newKieSession();
		kieSession.insert(rewardManage);
		kieSession.insert(table);
		kieSession.setGlobal( "rewardManageService", rewardManageService);
		kieSession.fireAllRules();
		kieSession.dispose();
	}
	


}
