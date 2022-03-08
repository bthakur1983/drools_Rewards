package com.bank.drool_reward.controller;

import com.bank.drool_reward.dto.RewardStatus;
import com.bank.drool_reward.dto.RewardStatusGeneric;
import com.bank.drool_reward.model.T000820Table;
import com.bank.drool_reward.model.T000871Table;
import com.bank.drool_reward.model.T000899Table;
import com.bank.drool_reward.model.T001906Table;
import com.bank.drool_reward.model.T003922Table;
import com.bank.drool_reward.services.RewardStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reward")
public class RewardStatusController 
{
    Logger logger = LoggerFactory.getLogger(RewardStatusController.class);
    @Autowired
    RewardStatusService rewardStatusService;



    @PostMapping("/addT001906Table")
    public ResponseEntity<?> addT001906Table(@RequestBody T001906Table obj) {

        if (obj == null)
            return ResponseEntity
                    .badRequest()
                    .body("Please provide valid request");
        rewardStatusService.saveData(obj);
        return ResponseEntity.ok("Successfully added the  T001906Table");

    }

    @PostMapping("/addT003922Table")
    public ResponseEntity<?> addT003922Table(@RequestBody T003922Table obj1) {

        if (obj1 == null)
            return ResponseEntity
                    .badRequest()
                    .body("Please provide valid request");
        rewardStatusService.saveDataInT003922Table(obj1);
        return ResponseEntity.ok("Successfully added the  T003922Table");

    }
    
    @PostMapping("/addT000820Table")
    public ResponseEntity<?> addT000820Table(@RequestBody T000820Table obj) {

        if (obj == null)
            return ResponseEntity
                    .badRequest()
                    .body("Please provide valid request");
        rewardStatusService.saveDataInT000820Table(obj);
        return ResponseEntity.ok("Successfully added the  T001906Table");

    }
    

    @GetMapping("/findAllT001906Table")
    public ResponseEntity<?> getT001906Table() {
        List<T001906Table> data = rewardStatusService.getT001906Table();
        if (data.isEmpty()) {
            return new ResponseEntity<>("No rules found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(data);
    }
    @GetMapping("/findAllT003922Table")
    public ResponseEntity<?> getT003922Table() {
        List<T003922Table> data = rewardStatusService.getT003922Table();
        if (data.isEmpty()) {
            return new ResponseEntity<>("No rules found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(data);
    }

    @PostMapping("/rewardStatus")
    public ResponseEntity<Object> fetchRewardStatus(@RequestBody RewardStatus rewardStatus)
    {
  	
    	Map<String, String>returnMap =  rewardStatusService.getRewardStatus(rewardStatus,rewardStatusService);
       
    	return new ResponseEntity<Object>(returnMap,HttpStatus.OK);


    }

    @PostMapping("/addT000871Table")
    public String insertDataInT000871Table(@RequestBody T000871Table obj) {

        System.out.println("T000871Table data inserted................................");
        return rewardStatusService.insertDataInT000871Table(obj);


    }


    @PostMapping("/addT000899Table")
    public String insertDataInT000899Table(@RequestBody T000899Table obj) {

        System.out.println("T000899Table data inserted................................");
        return rewardStatusService.insertDataInT000899Table(obj);


    }
    
    @PostMapping("/RewardStatusGenericRulesCheck")
    public ResponseEntity<Object> insertDataInT000899Table(@RequestBody RewardStatusGeneric obj) {
 
    	Map<String, String>returnMap =  rewardStatusService.RewardStatusGenericRulesCheck(obj);
    	return new ResponseEntity<Object>(returnMap,HttpStatus.OK);
    }


}





