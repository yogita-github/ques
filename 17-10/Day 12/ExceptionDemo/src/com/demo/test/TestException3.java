package com.demo.test;

import java.util.Scanner;

public class TestException3 {
	private static int division(int num, int num1) {
		try {
			int a=num/num1;
			return a;
		}catch(ArithmeticException e) {
			System.out.println("cannot divide by zero in division function");
			throw e;   //rethrow the exception
		}
	
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enetr number 1");
			int num=sc.nextInt();
			System.out.println("enetr number 2");
			int num1=sc.nextInt();
			int ans=division(num,num1);
			System.out.println("Division : "+ans);
			try {
				String s=null;
				System.out.println(s.length());
			}catch(NullPointerException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("in outer try block");
			
			
	   }catch(ArithmeticException e) {
		   System.out.println("cannot divide by zero");
	   }

	}

	

}
