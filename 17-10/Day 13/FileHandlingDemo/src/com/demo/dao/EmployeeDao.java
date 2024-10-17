package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.exceptions.EmployeeNotFound;

public interface EmployeeDao {

	void readDataFromFile(String fname);

	void save(Employee e);

	List<Employee> findAll();

	void writeToFile(String fname);

	boolean removeById(int id) throws EmployeeNotFound;

	boolean modifyById(int id, double sal) throws EmployeeNotFound;

}
