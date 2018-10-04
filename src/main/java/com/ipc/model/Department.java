package com.ipc.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@JsonInclude(value = Include.NON_NULL)
@Data
@Document(collection = "dept")
public class Department {

	@Id
	String id;
	
	@NotBlank
	String name;
	
}
