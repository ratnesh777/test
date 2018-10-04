package com.ipc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ipc.controller.Customer;
import com.ipc.model.Employee;


@Repository
public interface EmpRepository extends MongoRepository<Employee, String>
{

	//Customer findById(String customerId);
	
	Customer findByName(String name);
	
    Customer findByNameIgnoreCase(String name);
    

}
