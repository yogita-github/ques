package com.demo.test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.demo.beans.Course;
import com.demo.exceptions.CourseNotFound;
import com.demo.exceptions.NoCourseDuration;
import com.demo.service.CourseService;
import com.demo.service.CourseServiceImpl;

public class TestCourseMgnt {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseService cservice=new CourseServiceImpl();
		int choice=0;
		do {
			System.out.println("1. add new course\n2. delete course\n3. update course\n4. display all");
			System.out.println("5. display by name\n6. display based on duration\n7. display in sorted order of course name\n8. display in sorted order of duration\n9.exit\nchoice:");
			choice=sc.nextInt();
			switch(choice) {
			case 1->{
				boolean status=cservice.addnewcourse();
				if(status) {
					System.out.println("Added successfully");
				}else {
					System.out.println("Duplicate object");
				}
			}
			case 2->{
				System.out.println("Enter course name to delete");
				String cname=sc.next();
				boolean status=cservice.deleteByName(cname);
				if(status) {
					System.out.println("deleted successfully");
				}else {
					System.out.println("Not found");
				}
				
			}
			case 3->{
				try {
					System.out.println("Enter course name to modify");
					String cname=sc.next();
					System.out.println("Enter course new  Duration");
					int cduration=sc.nextInt();
					System.out.println("Enter course new  capacity");
					int capacity=sc.nextInt();
					boolean status=cservice.modifyByName(cname,cduration,capacity);
					if(status) {
						System.out.println("Updated successfully");
					}
				}catch(CourseNotFound e) {
					System.out.println(e.getMessage());
				}
				
			}
			case 4->{
				Map<String,Course> hm1=cservice.getAll();
				Set<String> s=hm1.keySet();
				s.stream().forEach(ob->System.out.println(ob+"------->"+hm1.get(ob)));
			}
			case 5->{}
			case 6->{
				try {
					System.out.println("Enter course new  Duration");
					int cduration=sc.nextInt();
					List<Course> lst=cservice.findByDuration(cduration);
					if(lst!=null) {
						lst.forEach(System.out::println);
					}
				}catch(NoCourseDuration e) {
					System.out.println(e.getMessage());
				}
				
			}
			case 7->{
				Map<String,Course> cmap=cservice.sortByName();
				Set<String> s=cmap.keySet();
				s.stream().forEach(c->System.out.println(c+"---->"+cmap.get(c)));
			}
			case 8->{
				List<Course> clst=cservice.sortByDuration();
				
				clst.stream().forEach(c->System.out.println(c));
			}
			case 9->{
				System.out.println("Thank you for visiting.......");
				sc.close();
			}
			default->{}
			}
			
		}while(choice!=9);
		

	}

}
