package com.ipc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ipc.model.Department;
import com.ipc.model.Employee;

public interface DeptService {

	
	Department createDept(Department dept);

	Department findDeptById(String id);

	List<Department> getDepts();
	
}
