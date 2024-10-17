package com.demo.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestDataStream {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("testdata.txt"))){
			System.out.println("enter number");
			int num=sc.nextInt();
			dos.writeInt(num);
			System.out.println("enter name");
			String s=sc.next();
			dos.writeUTF(s);
			System.out.println("enter salary");
			double sal=sc.nextDouble();
			dos.writeDouble(sal);
		}catch(IOException e) {
			System.out.println("error while using file");
		}
		try(DataInputStream dis=new DataInputStream(new FileInputStream("testdata.txt"))){
			int n=dis.readInt();
			String s=dis.readUTF();
			double sal=dis.readDouble();
			System.out.println(n+","+s+","+sal);
			
			
		}catch(IOException e) {
			System.out.println("error while using file");
		}

	}

}
