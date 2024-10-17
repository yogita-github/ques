package com.demo.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestException2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++) {
		try {
				System.out.println("enetr number 1");
				int num=sc.nextInt();
				System.out.println("enetr number 2");
				int num1=sc.nextInt();
				int ans=num+num1;
				System.out.println("Answer : "+ans);
				ans=num/num1;
				System.out.println("Division : "+ans);
				String s=null;
				System.out.println(s.length());
				break;
		}catch(InputMismatchException e) {
			System.out.println("pls enter number");
			sc.nextLine();
			///System.out.println(e.getMessage());
		}catch(ArithmeticException|ArrayIndexOutOfBoundsException e) {
			System.out.println("cannot divide by zero");
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println("error occured");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("in finally block");
			sc.close();
		}
		
		}
		System.out.println("resume the execution of remaining program");
		
	}

}
