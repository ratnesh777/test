package com.ipc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ipc.controller.Customer;

public interface CustomerService {

	
	Customer createCustomer(Customer company);

	Customer findCustomerById(String id);

	Page<Customer> findCompanyList(Integer page, Integer size, String sortParam, String sortDirection,
			String searchKey);

	List<Customer> getCustomers();
	
	List<Customer> getCustomersSort();
	
}
