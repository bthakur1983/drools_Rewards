package com.bank.drool_reward.repository;

import com.bank.drool_reward.model.T000899Table;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface T000899Repo extends MongoRepository<T000899Table,String> {

	@Query("{'rWACC_UID' : ?0,'rWDP_BU_NBR': ?1,'rWACC_SYS_CDE': ?2 }")
	T000899Table findByUIDAndBU_NBR(String eacToUid, String bU_NUM, String systemCode);
}
