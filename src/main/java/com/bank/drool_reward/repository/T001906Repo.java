 package com.bank.drool_reward.repository;

import com.bank.drool_reward.model.T001906Table;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface T001906Repo extends MongoRepository<T001906Table,String > {

	 
}
