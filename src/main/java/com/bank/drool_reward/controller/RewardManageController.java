package com.bank.drool_reward.controller;

import com.bank.drool_reward.dto.RewardManage;
import com.bank.drool_reward.model.T000070Table;
import com.bank.drool_reward.model.T000820Table;
import com.bank.drool_reward.model.T001750Table;
import com.bank.drool_reward.model.T001754Table;
import com.bank.drool_reward.model.T001991Table;
import com.bank.drool_reward.services.RewardManageService;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/manage")
public class RewardManageController {

	    @Autowired
	    RewardManageService rewardManageService;

	    @PostMapping("/addT000070Table")
	    public ResponseEntity<?> addT000070Table(@RequestBody T000070Table obj) 
	    {

	        if (obj == null)
	            return ResponseEntity
	                    .badRequest()
	                    .body("Please provide valid request");
	        rewardManageService.saveDataInaddT000070Table(obj);
	        return ResponseEntity.ok("Successfully added the  addT000070Table");

	    }

	    @PostMapping("/addT001991Table")
	    public ResponseEntity<?> addT001991Table(@RequestBody T001991Table obj) throws ParseException {

	      rewardManageService.saveT001991Data(obj);
	      return ResponseEntity.ok("Successfully added the  addT001991Table");

	    }
	    
	    @PostMapping("/addT001750Table")
	    public ResponseEntity<?> T001750Table(@RequestBody T001750Table obj) throws ParseException {

	      rewardManageService.saveT001750Table(obj);
	      return ResponseEntity.ok("Successfully added the  T001750Table");

	    }

	    @PostMapping("/addT001754Table")
	    public ResponseEntity<?> T001754Table(@RequestBody T001754Table obj) throws ParseException {

	      rewardManageService.saveT001754Table(obj);
	      return ResponseEntity.ok("Successfully added the  T001754Table");

	    }


    
    @PostMapping("/rewardManage")
	public ResponseEntity<Object> fetchRewardManage(@RequestBody RewardManage rewardManage) {

		Map<String, String> returnMap = rewardManageService.getRewardManage(rewardManage, rewardManageService);
		return new ResponseEntity<Object>(returnMap, HttpStatus.OK);

	}

}
