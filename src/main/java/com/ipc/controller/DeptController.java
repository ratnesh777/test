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
import com.ipc.model.Department;
import com.ipc.model.Employee;
import com.ipc.service.DeptService;
import com.ipc.util.APIUtilConstant;
import com.ipc.util.ErrorMessagesConstant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping(value = APIUtilConstant.DEPT_API_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = APIUtilConstant.SWAGGER_DEPT_API)
public class DeptController {

	@Value("${base.path.uri}")
	private String basePATHURI;

	@Autowired
	public DeptService deptService;

	Logger auditLog = LogManager.getLogger("auditLogger");
	Logger logger = LogManager.getLogger("cpLogger");

	@ApiOperation(value = "Creates a department", response = Department.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = ErrorMessagesConstant.CREATED, response = Department.class),
			// @ApiResponse(code = 400, message = ErrorMessagesConstant.BAD_REQUEST,
			// response = ErrorResource.class),
			// @ApiResponse(code = 422, message = ErrorMessagesConstant.INVALID_REQUEST,
			// response = ErrorResource.class)
	})
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Department> createDept(@RequestBody @Valid Department department, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new PortalInvalidRequestException(ErrorMessagesConstant.INVALID_CREATE_REQUEST, bindingResult);
		}
		department = deptService.createDept(department);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", basePATHURI + APIUtilConstant.EMP_API_END_POINT + "/" + department.getId());
		return new ResponseEntity<>(department, httpHeaders, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Get employee  by Id", response = Employee.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = ErrorMessagesConstant.SUCCESS, response = Department.class),
			// @ApiResponse(code = 404, message = ErrorMessagesConstant.NOT_FOUND, response
			// = ErrorResource.class)
	})
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Department getEmpById(
			@ApiParam(name = "id", value = "company id", required = true) @PathVariable("id") String id)
			throws PortalResourceNotFoundException {

		return deptService.findDeptById(id);
	}

	@ApiOperation(value = "Find list of employees", responseContainer = "List", response = Department.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = ErrorMessagesConstant.SUCCESS, response = Department.class),
			// @ApiResponse(code = 422, message = ErrorMessagesConstant.INVALID_REQUEST,
			// response = ErrorResource.class)
	})
	@RequestMapping(method = RequestMethod.GET)
	public List<Department> getDeptList() {
				return deptService.getDepts();

	}


}