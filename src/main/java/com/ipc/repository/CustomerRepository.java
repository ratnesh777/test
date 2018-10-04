package com.ipc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ipc.controller.Customer;


@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>
{

	//Customer findById(String customerId);
	
	Customer findByName(String name);
	
    Customer findByNameIgnoreCase(String name);
    

}
