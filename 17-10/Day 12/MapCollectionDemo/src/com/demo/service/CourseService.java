package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.beans.Course;
import com.demo.exceptions.CourseNotFound;
import com.demo.exceptions.NoCourseDuration;

public interface CourseService {

	boolean addnewcourse();

	Map<String, Course> getAll();

	boolean deleteByName(String cname);

	boolean modifyByName(String cname, int cduration, int capacity) throws CourseNotFound;

	List<Course> findByDuration(int cduration) throws NoCourseDuration;

	Map<String, Course> sortByName();

	List<Course> sortByDuration();

}
