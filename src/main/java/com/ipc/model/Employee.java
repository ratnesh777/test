package com.ipc.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "employee")
public class Employee {

	@Id
	String id;
	
	@NotBlank
	String name;
	
	@DBRef
	Department department;
}
