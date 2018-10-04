package com.ipc.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@JsonInclude(value = Include.NON_NULL)
@Data
@Document(collection = "customer")
public class Customer {

	@Id
	String id;
	
	@NotBlank
	String name;
	
	String emailDomain;
	
}
