package com.demo.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.demo.exceptions.WrongNumberInputException;

public class GuessTheNumber {
	public static void main(String[] args)  {
		int num=23;
		Scanner sc=new Scanner(System.in);
		while(true) {
		try {
			System.out.println("enetr the  number");
			int num1=sc.nextInt();
			if(num!=num1) {
				throw new WrongNumberInputException("OOPs! you lost one attempt");
			}else {
				System.out.println("Yepeeee, you got the number"+num1);
				break;
			}
		}catch(InputMismatchException e) {
			System.out.println("cannot enter string, input should be a number");
		}catch(WrongNumberInputException e) {
			System.out.println(e.getMessage());
		}
		}
		
	}

}
