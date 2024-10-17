package com.demo.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader {
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new FileReader("test1.txt"));){
			String s=br.readLine();
			while(s!=null) {
				System.out.println(s);
				s=br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
