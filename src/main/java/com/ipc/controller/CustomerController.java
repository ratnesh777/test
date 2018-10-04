package com.ipc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipc.exception.PortalInvalidRequestException;
import com.ipc.exception.PortalResourceNotFoundException;
import com.ipc.model.CustomerPaginationRequestParameters;
import com.ipc.service.CustomerService;
import com.ipc.util.APIUtilConstant;
import com.ipc.util.ErrorMessagesConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin
@RestController
@RequestMapping(value = APIUtilConstant.CUSTOMER_API_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = APIUtilConstant.SWAGGER_CUSTOMER_API)
public class CustomerController {

	@Value("${base.path.uri}")
	private String basePATHURI;

	@Autowired
	public CustomerService customerService;

	Logger auditLog = LogManager.getLogger("auditLogger");
	Logger logger = LogManager.getLogger("cpLogger");

	@ApiOperation(value = "Creates customer", response = Customer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = ErrorMessagesConstant.CREATED, response = Customer.class),
			// @ApiResponse(code = 400, message = ErrorMessagesConstant.BAD_REQUEST,
			// response = ErrorResource.class),
			// @ApiResponse(code = 422, message = ErrorMessagesConstant.INVALID_REQUEST,
			// response = ErrorResource.class)
	})
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Customer> createCompany(@RequestBody @Valid Customer company, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new PortalInvalidRequestException(ErrorMessagesConstant.INVALID_CREATE_REQUEST, bindingResult);
		}
		company = customerService.createCustomer(company);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", basePATHURI + APIUtilConstant.CUSTOMER_API_END_POINT + "/" + company.getId());
		return new ResponseEntity<>(company, httpHeaders, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Get customer  by Id", response = Customer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = ErrorMessagesConstant.SUCCESS, response = Customer.class),
			// @ApiResponse(code = 404, message = ErrorMessagesConstant.NOT_FOUND, response
			// = ErrorResource.class)
	})
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getCompanyById(
			@ApiParam(name = "id", value = "company id", required = true) @PathVariable("id") String id)
			throws PortalResourceNotFoundException {

		return customerService.findCustomerById(id);
	}

	@ApiOperation(value = "Find list of customers", responseContainer = "List", response = Customer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = ErrorMessagesConstant.SUCCESS, response = Customer.class),
			// @ApiResponse(code = 422, message = ErrorMessagesConstant.INVALID_REQUEST,
			// response = ErrorResource.class)
	})
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> getCompanyList(
			@Valid @ModelAttribute() CustomerPaginationRequestParameters paginationRequestParameters,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new PortalInvalidRequestException(ErrorMessagesConstant.INVALID_PARAMETER_PASSED, bindingResult);
		}

		return customerService.getCustomers();

	}
	/*public Page<Customer> getCompanyList(
			@Valid @ModelAttribute() CustomerPaginationRequestParameters paginationRequestParameters,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new PortalInvalidRequestException(ErrorMessagesConstant.INVALID_PARAMETER_PASSED, bindingResult);
		}

		return customerService.findCompanyList(paginationRequestParameters.getPage(),
				paginationRequestParameters.getSize(), paginationRequestParameters.getSortParam(),
				paginationRequestParameters.getSortDirection(), paginationRequestParameters.getSearchKey());

	}*/
	
	@RequestMapping(value = "/customersSort", method = RequestMethod.GET, produces="application/json")
    public  List<Customer>  getCompanyListSorted()
    {
    	return customerService.getCustomersSort();
    }
	

}