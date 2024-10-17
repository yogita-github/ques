package com.demo.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestMap1 {

	public static void main(String[] args) {
		Map<String,String> hm=new Hashtable<>();
		//hm.put(null, null);
		hm.put("x", "y");
		System.out.println(hm);
		

	}

}
