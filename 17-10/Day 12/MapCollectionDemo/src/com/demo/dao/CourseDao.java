package com.demo.dao;

import java.util.List;
import java.util.Map;

import com.demo.beans.Course;
import com.demo.exceptions.CourseNotFound;
import com.demo.exceptions.NoCourseDuration;

public interface CourseDao {

boolean save(Course c);

Map<String, Course> findAll();

boolean removeByName(String cname);

boolean updateByName(String cname, int cduration, int capacity) throws CourseNotFound ;

List<Course> getByDuration(int cduration) throws NoCourseDuration;

Map<String, Course> sortByName();

List<Course> sortByDuration();

}
