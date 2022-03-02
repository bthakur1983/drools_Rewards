package com.bank.drool_reward.repository;

import com.bank.drool_reward.model.T000871Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface T000871Repo extends MongoRepository<T000871Table, String>
{

	@Query("{'rWDP_UID' : ?0,'rWDP_BU_NBR': ?1}")
	T000871Table findByUIDAndBU_NBR(String eacToUid, String bU_NUM);




}
