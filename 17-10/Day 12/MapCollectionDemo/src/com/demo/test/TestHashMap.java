package com.demo.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		Map<String,Integer> hm=new HashMap<>();
		hm.put("DAC", 240);
		hm.put("DBDA", 60);
		hm.put("DTISS", 65);
		//to navigate through map
		Set<String> ks=hm.keySet();  //{"DAC","DBDA","DTISS"}
		for(String s:ks) {
			System.out.println(s+"----->"+hm.get(s));
		}
		////to navigate through map
	    Set<Map.Entry<String,Integer>> es=hm.entrySet(); //{("DAC",240),("DBDA",60),("DTISS",65)}
	    for(Map.Entry<String,Integer> m:es) {
	    	System.out.println(m.getKey()+"---->"+m.getValue());
	    }
	    
	    //find number of students in DAC course
	    System.out.println("DAC students"+hm.get("DAC"));
	    //find number of students in DAC course
	    System.out.println("DVLSI students " +hm.get("DVLSI"));//DVLSI students--> null
		//display all courses in which more than 62 participants
	    for(String s:ks) {
	    	if(hm.get(s)>62) {
	    		System.out.println(s+"---->"+hm.get(s));
	    	}
	    }
	    System.out.println("check key exists DBDA : "+hm.containsKey("DBDA"));
	    if(!hm.containsKey("DBDA"))
	    	hm.put("DBDA", 100);
	    else 
	    	System.out.println("Duplicate key");
	    
	    hm.remove("DBDA"); //to remove key-value pair
	   
	    
	    
	}

}
