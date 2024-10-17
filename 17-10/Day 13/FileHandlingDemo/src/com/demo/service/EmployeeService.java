package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.exceptions.EmployeeNotFound;

public interface EmployeeService {

	void readFile(String string);

	void addnewEmployee();

	List<Employee> getAll();

	void writeFile(String string);

	boolean deleteById(int id) throws EmployeeNotFound;

	boolean updateById(int id, double sal) throws EmployeeNotFound;

}
