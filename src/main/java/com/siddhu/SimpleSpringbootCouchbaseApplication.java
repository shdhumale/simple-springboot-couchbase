package com.siddhu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.siddhu.model.Employee;
import com.siddhu.repository.EmployeeRepository;

@SpringBootApplication
@RestController
public class SimpleSpringbootCouchbaseApplication {

	@Autowired
	private EmployeeRepository repository;


	@GetMapping("/fetchAllCustomers")
	public String getAll() {
		//return repository.findAll().toString();


		List<Employee> people = new ArrayList<Employee>(); 
		Iterator<Employee> it =repository.findAll().iterator();
		while(it.hasNext())
		{ 
			people.add(it.next());
		} 
		String json = new Gson().toJson(people);

		return json;


	}


	@GetMapping("/insertEmployee")
	public void addData() {

		//Employee objEmployeeOne =  new Employee(new Integer(1), "Siddhu1", new String[] { "Siddhu1 Address 1", "Siddhu1 Address 2" });
		//Employee objEmployeeTwo =  new Employee(new Integer(2), "Siddhu2", new String[] { "Siddhu2 Address 1", "Siddhu2 Address 2" });
		Employee objEmployeeOne =  new Employee("1", "Siddhu1", new String[] { "Siddhu1 Address 1", "Siddhu1 Address 2" });
		Employee objEmployeeTwo =  new Employee("2", "Siddhu2", new String[] { "Siddhu2 Address 1", "Siddhu2 Address 2" });
		repository.save(objEmployeeOne);
		repository.save(objEmployeeTwo);	

	}

	@GetMapping("/updateEmployee/{id}/{name}/{address}")
	public void updateData(@PathVariable("id") String id ,@PathVariable("name") String name,@PathVariable String[] address ) {

		//Employee objEmployeeOne =  new Employee(new Integer(id), name, address);		
		Employee objEmployeeOne =  new Employee(id, name, address);
		repository.save(objEmployeeOne);			

	}

	@GetMapping("/deleteEmployee/{id}")
	public void deleteData(@PathVariable("id") String id) {

		//repository.deleteById(new Integer(id));			
		repository.deleteById(new Integer(id));

	}
	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringbootCouchbaseApplication.class, args);
	}
}
