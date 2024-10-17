package com.demo.beans;

import java.io.Serializable;

public class Employee implements Serializable {
	private int empid;
	private String ename;
	private double sal;
	private double bonus;
	public Employee() {
		super();
	}
	public Employee(int empid, String ename, double sal, double bonus) {
		super();
		System.out.println("in parametrised constructor");
		this.empid = empid;
		this.ename = ename;
		this.sal = sal;
		this.bonus = bonus;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("in employee equals method "+this.empid+"-----"+((Employee)obj).empid);
		return this.empid==((Employee)obj).empid;
	}
	public Employee(int empid) {
		super();
		this.empid = empid;
	}
	public int getEmpid() {
		System.out.println("in getEmpid");
		return empid;
	}
	public void setEmpid(int empid) {
		System.out.println("in setEmpid");
		this.empid = empid;
	}
	public String getEname() {
		System.out.println("in getEname");
		return ename;
	}
	public void setEname(String ename) {
		System.out.println("in setename");
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		System.out.println("in setSal");
		this.sal = sal;
	}
	public double getBonus() {
		System.out.println("in getBonus");
		return bonus;
	}
	public void setBonus(double bonus) {
		System.out.println("in setBonus");
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", sal=" + sal + ", bonus=" + bonus + "]";
	}
	

}
