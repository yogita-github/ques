package com.demo.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;
import com.demo.exceptions.EmployeeNotFound;

public class EmployeeDaoImpl implements EmployeeDao{
	static List<Employee> elst;
	static {
		elst=new ArrayList<>();
		
	}
	@Override
	public void readDataFromFile(String fname) {
		try(ObjectInputStream oos=new ObjectInputStream(new FileInputStream(fname));){
			
			while(true) {
				Employee e=(Employee) oos.readObject();
				elst.add(e);
			}
			
		} catch(EOFException e) {
			System.out.println("reached to end of file...."+elst.size());
			
		} catch(FileNotFoundException e) {
			System.out.println("file does not exists");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	@Override
	public void save(Employee e) {
		elst.add(e);
		
	}
	@Override
	public List<Employee> findAll() {
		return elst;
	}
	@Override
	public void writeToFile(String fname) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fname));){
			for(Employee e:elst) {
				oos.writeObject(e);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean removeById(int id) throws EmployeeNotFound {
		boolean flag= elst.remove(new Employee(id));
		if(flag)
			return flag;
		throw new EmployeeNotFound("Not found "+id);
	}
	@Override
	public boolean modifyById(int id, double sal) throws EmployeeNotFound {
		int pos=elst.indexOf(new Employee(id));
		if(pos!=-1) {
			Employee e=elst.get(pos);
			e.setSal(sal);
			return true;
		}
		throw new EmployeeNotFound("updation fail, not found "+id);
	}

}
