package com.demo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopyFile1 {
	public static void main(String[] args) {
		try(FileInputStream fis=new FileInputStream("test1.txt");
			FileOutputStream  fos=new FileOutputStream("test1copy.txt");) {
			int c=fis.read();
			while(c!=-1) { //Wheter reached to EOF
				fos.write(c);
				c=fis.read();
			}
		    System.out.println("File copied");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
