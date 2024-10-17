package com.demo.test;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;

import com.demo.beans.Employee;

public class TestSerialization {
	public static void writeFile(List<Employee> lst) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("empdata.dat"))){
			/*for(int i=0;i<lst.size();i++) {
				oos.writeObject(lst.get(i));
			}*/
			/*Iterator<Employee> it=lst.iterator();
			while(it.hasNext()) {
				oos.writeObject(it.next());
			}*/
			
			for(Employee e:lst) {
				oos.writeObject(e);
			}
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void readFile() {
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("empdata.dat"));){
			
			while(true) {
			  Employee e=(Employee)ois.readObject();
			  System.out.println(e);
			}
			
		}catch(EOFException e) {
			System.out.println("end of file reached.....");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		List<Employee> elst=List.of(new Employee(1,"ashu",34567,3456),new Employee(2,"Rashmi",44444,3456),new Employee(3,"Anil",55555,5555));
		//writing data from list to file
		writeFile(elst);
		System.out.println("Reading data from file");
		readFile();

	}

	

}
