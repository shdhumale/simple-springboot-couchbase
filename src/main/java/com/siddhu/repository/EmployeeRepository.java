package com.siddhu.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import com.siddhu.model.Employee;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc="employee",viewName="all")
@Repository
public interface EmployeeRepository extends CouchbaseRepository<Employee, Integer>{
	List<Employee> findAll();
}
