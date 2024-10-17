package com.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBufferedreader1 {
public static void main(String[] args) {
	try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));){
		String s=br.readLine();
		int num=Integer.parseInt(s);
		System.out.println(num);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
