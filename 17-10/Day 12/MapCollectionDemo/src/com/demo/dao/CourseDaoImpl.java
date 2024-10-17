package com.demo.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.demo.beans.Course;
import com.demo.exceptions.CourseNotFound;
import com.demo.exceptions.NoCourseDuration;

public class CourseDaoImpl implements CourseDao {

	static Map<String,Course> hm;
	static{
		hm=new HashMap<>();
		hm.put("DAC", new Course("DAC",10000.00,200,300));
		hm.put("DBDA", new Course("DBDA",15000.00,100,250));
	}
	@Override
	public boolean save(Course c) {
		Course c1=hm.putIfAbsent(c.getCname(), c);
		if(c1==null)
			return true;
		return false;
		
	}
	@Override
	public Map<String, Course> findAll() {
		
		return hm;
	}
	@Override
	public boolean removeByName(String cname) {
		// TODO Auto-generated method stub
		Course c1=hm.remove(cname);
		if(c1!=null) {
			return true;
		}
		return false;
		
		
	}
	@Override
	public boolean updateByName(String cname, int cduration, int capacity) throws CourseNotFound {
		Course c=hm.get(cname);
		if(c!=null) {
			c.setDuration(cduration);
			c.setCapacity(capacity);
			return true;
		}
		throw new CourseNotFound("Course Not found "+cname);
	}
	@Override
	public List<Course> getByDuration(int cduration) throws NoCourseDuration {
		Set<String> s=hm.keySet();
		List<Course> clst=new ArrayList<>();
		for(String s1:s) {
			Course c=hm.get(s1);
			if(c.getDuration()>cduration) {
				clst.add(c);
			}
			
		}
		if(clst.size()>0) {
			return clst;
		}
		
		throw new NoCourseDuration("No course with duration > "+cduration);
	}
	@Override
	public Map<String, Course> sortByName() {
		Map<String,Course> tm=new TreeMap<>();
		Set<String> s=hm.keySet();
		for(String s1:s) {
			tm.put(s1,hm.get(s1));
			
		}
		return tm;
	}
	@Override
	public List<Course> sortByDuration() {
		List<Course> lst=new ArrayList<>();
		Comparator<Course> c=(c1,c2)->{
			System.out.println("in compare method of comparator "+c1.getCname()+"----"+c2.getCname());
			return c1.getDuration()-c2.getDuration();};
		Set<String> cset=hm.keySet();
		for(String course:cset) {
			lst.add(hm.get(course));
			
		}
		//this will call compare method of Comparator
		lst.sort(c);
	    // this will call compareTo method of Comparable
		//lst.sort(null);
		return lst;
	}

}
