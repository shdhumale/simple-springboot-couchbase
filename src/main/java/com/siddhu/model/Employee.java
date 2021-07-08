package com.siddhu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import lombok.Data;

@Data
@Document
public class Employee {
	@Id
	private String id;
	@Field
	private String name;
	@Field
	private String[] address;


	public Employee(String id, String name, String[] address) { 
		this.id = id;
		this.name= name; 
		this.address = address;

	}



}
