package com.demo.test;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestBackedCollection {
	public static void main(String[] args) {
		TreeSet<Integer> ts=new TreeSet<>();
		ts.add(12);
		ts.add(5);
		ts.add(15);
		ts.add(20);
		ts.add(3);
		System.out.println(ts); //[3, 5, 12, 20]
		SortedSet<Integer> hs=ts.headSet(15);
		SortedSet<Integer> tails=ts.tailSet(15);
		System.out.println(hs);   //[3,5,12]
		System.out.println(tails); 
		ts.add(7);
		ts.add(25);
		ts.add(11);
		System.out.println(hs); 
		System.out.println(tails); 
	}

}
