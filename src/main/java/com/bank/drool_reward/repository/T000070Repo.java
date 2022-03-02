package com.bank.drool_reward.repository;

import com.bank.drool_reward.model.T000070Table;
import com.bank.drool_reward.model.T000820Table;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface T000070Repo extends MongoRepository<T000070Table,String> {


    @Query("{'cGSE_SYS_EVT_TYP' : ?0,'cGSE_SYS_EVT_NBR': ?1,'cGSE_LGN_ID_NBR': ?2 }")
    T000070Table findBySYS_EVT_TYPAndSYS_EVT_NBRAndLGN_ID_NBR(String eventType, String eventNumber,String loginId);



}
