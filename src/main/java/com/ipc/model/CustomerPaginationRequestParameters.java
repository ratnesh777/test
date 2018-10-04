package com.ipc.model;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CustomerPaginationRequestParameters extends PaginationRequestParameters{

	 @Pattern(regexp = "id|name|")
	 String sortParam;
}
