package com.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
	public static void main(String[] args) {
		List<Integer> lst=List.of(2,3,12,34,56,78);
		System.out.println("max: "+Collections.max(lst));
		System.out.println("min: "+Collections.min(lst));
		List<Integer> lst1=new ArrayList<>();
		for(Integer i:lst) {
			lst1.add(i);
		}
		for(int i=0;i<5;i++) {
		   Collections.shuffle(lst1);
		   System.out.println("after shuffle");
		   System.out.println(lst1);
		}
		
	}

}
