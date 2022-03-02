package com.bank.drool_reward.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.drool_reward.model.T000820Table;

@Repository
public interface T000820Repo extends MongoRepository<T000820Table,String > {

	@Query("{'rWAE_UID' : ?0,'rWAE_BU_NBR': ?1,'rWAE_PGM_NBR': ?2 }")
	T000820Table findByUIDAndBU_NBR(String rWAE_UID, String rWAE_BU_NBR,String rWAE_PGM_NBR);

	@Query("{'rWAE_UID' : ?0,'rWAE_BU_NBR': ?1,'rWAE_PGM_NBR': ?2,'rWAE_TYP_CDE': ?3,'rWAE_ACTN_DEST_NBR': ?4 }")
	T000820Table findByData(String rWAE_UID,String rWAE_BU_NBR,String rWAE_PGM_NBR,String rWAE_TYP_CDE,String rWAE_ACTN_DEST_NBR);
}

