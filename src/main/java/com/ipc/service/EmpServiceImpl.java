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

import com.ipc.controller.Customer;
import com.ipc.model.Employee;
import com.ipc.repository.EmpRepository;

@Service
public class EmpServiceImpl extends AbstractServiceImpl implements EmpService{
	
	@Autowired
	EmpRepository empRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		
		return empRepository.save(employee);
	}

	@Override
	public Employee findEmployeeById(String id) {
		Optional<Employee> employee = null;
		try {
			employee = empRepository.findById(id);
			
		} catch (Exception ignored) {
				}
		if(!employee.isPresent()){
			//throw error emp not found
		}
		return employee.get();
	}

	@Override
	public Page<Employee> findEmpList(Integer page, Integer size, String sortParam, String sortDirection,
			String searchKey) {
		/*	if (StringUtils.isNotBlank(searchKey)) {
		return searchAll(page, size, sortParam, sortDirection, searchKey);
		}
		 */
		
	return empRepository.findAll(getPageRequest(page, size, sortParam, sortDirection));

	}

	@Override
	public List<Employee> getEmp() {
		return empRepository.findAll();
	}

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<Employee> getEmpSort(Integer page, Integer size, String sortParam, String sortDirection,
			String searchKey) {
		
		PageRequest pageReq =  PageRequest.of(0,10,new Sort(Sort.Direction.ASC,sortParam));
		Query query = new Query().with(pageReq);
		query.collation(Collation.of("en").strength(Collation.ComparisonLevel.secondary()));
		
		return mongoTemplate.find(query,Employee.class);
		
    	/*PageRequest page =  PageRequest.of(0,10,new Sort(Sort.Direction.DESC,"homeDataCenter.name"));
    	Query query = new Query().with(page);
    	query.collation(Collation.of("en").strength(Collation.ComparisonLevel.secondary()));
    	List<User> result =mongoTemplate.find(query, User.class);
    	return result;*/
	}
	

}
