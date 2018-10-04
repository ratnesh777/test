package com.ipc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ipc.controller.Customer;
import com.ipc.model.Employee;

public interface EmpService {

	
	Employee createEmployee(Employee company);

	Employee findEmployeeById(String id);

	Page<Employee> findEmpList(Integer page, Integer size, String sortParam, String sortDirection,
			String searchKey);

	List<Employee> getEmp();
	
	//Page<Employee> getEmpSort();
	List<Employee> getEmpSort(Integer page, Integer size, String sortParam, String sortDirection,
			String searchKey);
	
}
