package com.test;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hibernate.sql.Employee;
import com.hibernate.sql.EmployeeRepository;

public class EmployeeDAO {
	@Autowired
	EmployeeRepository employeeRepository;

	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {       
        
        //add resource
    	employee = employeeRepository.save(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }

	public Object getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
