package com.bank.drool_reward.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.bank.drool_reward.model.T001991Table;

@Repository
public interface T001991Repo extends MongoRepository<T001991Table, String>
{




}
