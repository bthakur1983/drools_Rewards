package com.bank.drool_reward.repository;

import com.bank.drool_reward.model.T003922Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface T003922Repo  extends MongoRepository<T003922Table,String > {

	@Query("{'aCCT_UID' : ?0,'aCCT_BU_NBR': ?1}")
	T003922Table findByUIDAndBU_NBR(String eacToUid, String bU_NUM);


}
