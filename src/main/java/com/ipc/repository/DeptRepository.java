package com.ipc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ipc.model.Department;


@Repository
public interface DeptRepository extends MongoRepository<Department, String>
{

	Department findByName(String name);

}
