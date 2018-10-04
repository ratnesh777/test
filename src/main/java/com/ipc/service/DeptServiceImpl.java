package com.ipc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ipc.model.Department;
import com.ipc.model.Employee;
import com.ipc.repository.DeptRepository;

@Service
public class DeptServiceImpl extends AbstractServiceImpl implements DeptService{
	
	@Autowired
	DeptRepository deptRepository;

	@Override
	public Department createDept(Department department) {
		
		return deptRepository.save(department);
	}

	@Override
	public Department findDeptById(String id) {
		Optional<Department> department = null;
		try {
			department = deptRepository.findById(id);
			
		} catch (Exception ignored) {
				}
		if(!department.isPresent()){
			//throw error emp not found
		}
		return department.get();
	}

	

	@Override
	public List<Department> getDepts() {
		return deptRepository.findAll();
	}

	@Autowired
	MongoTemplate mongoTemplate;


	
	
}
