package com.demo.test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestDataInputStream {

	public static void main(String[] args) {
		
		try(DataInputStream dis=new DataInputStream(new FileInputStream("test1.txt"))){
			String s=dis.readLine();
			int cnt=1;
			while(s!=null) {
				if(s.length()>10)
				    System.out.println(cnt+".  "+s);
				s=dis.readLine();
				cnt++;
			}
			
		}catch(IOException e) {
			System.out.println("file read write error");
		}

	}

}
