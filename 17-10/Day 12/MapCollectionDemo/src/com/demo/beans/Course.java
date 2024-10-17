package com.demo.beans;

public class Course implements Comparable<Course>{
    private String cname;
    private double fees;
    private int capacity;
    private int duration;
    
	public Course() {
		super();
	}

	public Course(String cname, double fees, int capacity, int duration) {
		super();
		this.cname = cname;
		this.fees = fees;
		this.capacity = capacity;
		this.duration = duration;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [cname=" + cname + ", fees=" + fees + ", capacity=" + capacity + ", duration=" + duration + "]";
	}

	@Override
	public int compareTo(Course o) {
		System.out.println("in compareTo method of Course "+this.cname+"-----"+o.cname);
		
		return this.duration-o.duration;
	}
    

}
