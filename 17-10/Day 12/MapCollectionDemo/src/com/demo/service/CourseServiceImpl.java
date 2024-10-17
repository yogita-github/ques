package com.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.demo.beans.Course;
import com.demo.dao.CourseDao;
import com.demo.dao.CourseDaoImpl;
import com.demo.exceptions.CourseNotFound;
import com.demo.exceptions.NoCourseDuration;

public class CourseServiceImpl implements CourseService{
	private CourseDao cdao;
	public CourseServiceImpl() {
		cdao=new CourseDaoImpl();
	}
	
	@Override
	public boolean addnewcourse() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter course name");
		String nm=sc.next();
		System.out.println("Enter duration");
		int duration=sc.nextInt();
		System.out.println("capacity");
		int capacity=sc.nextInt();
		System.out.println("enter fees");
		double fees=sc.nextDouble();
		Course c=new Course(nm, fees, capacity, duration);
		return cdao.save(c);
	}

	@Override
	public Map<String, Course> getAll() {
		return cdao.findAll();
	}

	@Override
	public boolean deleteByName(String cname) {
		// TODO Auto-generated method stub
		
		return cdao.removeByName(cname);
	}

	@Override
	public boolean modifyByName(String cname, int cduration, int capacity) throws CourseNotFound {
		
		return cdao.updateByName(cname,cduration,capacity);
	}

	@Override
	public List<Course> findByDuration(int cduration) throws NoCourseDuration {
		
		return cdao.getByDuration(cduration);
	}

	@Override
	public Map<String, Course> sortByName() {
		
		return cdao.sortByName();
	}

	@Override
	public List<Course> sortByDuration() {
		
		return cdao.sortByDuration();
	}

}
