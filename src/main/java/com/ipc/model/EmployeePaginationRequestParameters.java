package com.ipc.model;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeePaginationRequestParameters extends PaginationRequestParameters{

	 @Pattern(regexp = "id|name|department|department.name|department.id|")
	 String sortParam;
}
