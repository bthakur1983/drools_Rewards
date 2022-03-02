package com.bank.drool_reward.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.bank.drool_reward.model.T001754Table;

public interface T001754Repo extends MongoRepository<T001754Table,String> 
{

	@Query("{'bZPC_NME' : ?0,'bZPC_SUB_NME': ?1}")
	T001754Table findByBusniessProcess(String businessPr, String businessSubPr);

}
