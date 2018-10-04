package com.ipc.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ipc.controller.Customer;
import com.ipc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl extends AbstractServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer company) {
		
		return customerRepository.save(company);
	}

	@Override
	public Customer findCustomerById(String id) {
		Optional<Customer> company = null;
		try {
			company = customerRepository.findById(id);
			
		} catch (Exception ignored) {
				}
		return company.get();
	}
	

	@Override
	public Page<Customer> findCompanyList(Integer page, Integer size, String sortParam, String sortDirection,
			String searchKey) {
	/*	if (StringUtils.isNotBlank(searchKey)) {
			return searchAll(page, size, sortParam, sortDirection, searchKey);
		}
*/
		return customerRepository.findAll(getPageRequest(page, size, sortParam, sortDirection));
		//Pageable pageable = null;
		//return customerRepository.findAll(getPageRequest());
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<Customer> getCustomersSort() {
		
		//Sort.Order order = new Sort.Order(Sort.Direction.ASC, "name");
		//PageRequest page =  PageRequest.of(1,10,new Sort(order));
		PageRequest page =  PageRequest.of(0,10,new Sort(Sort.Direction.ASC,"name"));
		Query query = new Query().with(page);
		query.collation(Collation.of("en").strength(Collation.ComparisonLevel.secondary()));
		
		//Sort sort = new Sort(Sort.Direction.ASC,"name");
		//.Order order = new Sort.Order(ascending? Sort.Direction.ASC: Sort.Direction.DESC, sortKey);
		Query query1 = new Query().with(new Sort(Sort.Direction.ASC,"name"));
		query1.collation(Collation.of("en").strength(Collation.ComparisonLevel.secondary()));
				
		//return mongoTemplate.find(query,Customer.class);
		return mongoTemplate.find(query,Customer.class);
		//return customerRepository.findAll();
		
		

    	/*PageRequest page =  PageRequest.of(0,10,new Sort(Sort.Direction.DESC,"homeDataCenter.name"));
    	Query query = new Query().with(page);
    	query.collation(Collation.of("en").strength(Collation.ComparisonLevel.secondary()));
    	List<User> result =mongoTemplate.find(query, User.class);*/
	}
	
	/*public Page<Customer> searchAll(Integer page, Integer size, String sortParam, String sortDirection,
			String searchString) {

		logger.debug("Returned paginated and sorted customer data by searchString");
		QCustomer qCustomer = QCustomer.customer;
		QDataCenter qDataCenter = QDataCenter.dataCenter;
		Predicate predicateDataCenter = (qDataCenter.name.containsIgnoreCase(searchString));
		Iterable<DataCenter> lstDataCenter =  dataCenterRepository.findAll(predicateDataCenter);
		ArrayList<DataCenter> collDataCenter = Lists.newArrayList(lstDataCenter);
		Predicate predicate = qCustomer.name.containsIgnoreCase(searchString)
				.or(qCustomer.partyID.containsIgnoreCase(searchString))
				.or(qCustomer.softClientURL.containsIgnoreCase(searchString))
				.or(qCustomer.recordingURL.containsIgnoreCase(searchString))
				.or(qCustomer.skypeURL.containsIgnoreCase(searchString))
				.or(qCustomer.networkEntitlement.containsIgnoreCase(searchString))
				.or(qCustomer.emailDomain.containsIgnoreCase(searchString))
				.or(qCustomer.recordingURL.containsIgnoreCase(searchString))
				.or(qCustomer.recordingServerFQDN.containsIgnoreCase(searchString));
		predicate = updatePredicateForDCSearched(collDataCenter, predicate, qCustomer);
		predicate = updateBooleanData(searchString, predicate, qCustomer);
		return customerRepository.findAll(predicate, getPageRequest(page, size, sortParam, sortDirection));
	}
	*/

}
