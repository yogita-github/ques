package com.demo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopyFile {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			//file should exists, otherwise throws exception FileNotFound
			fis=new FileInputStream("test1.txt");
			//If file doesnot exists, it will create the file, if exists it will
			//overwrite the file
			 fos=new FileOutputStream("test1copy.txt");
			int c=fis.read();
			while(c!=-1) { //Wheter reached to EOF
				fos.write(c);
				c=fis.read();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
