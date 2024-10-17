package com.demo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopyAppendFile2 {

	public static void main(String[] args) {
		File f=new File("test1copy.txt");
		FileOutputStream fos=null;
		try {
		if(f.exists()) {
			//fos has to be effectively final
			     ///second parameter true opens the file in append mode
				fos=new FileOutputStream(f,true);
			
		}else {
			//create a file and open it in write mode
			 fos=new FileOutputStream(f);
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(FileInputStream fis=new FileInputStream("test1.txt");
			FileOutputStream fos1=fos;	){
			int c=fis.read();
			while(c!=-1) {
				fos1.write(c);
				c=fis.read();
			}
			System.out.println("file copied");
			
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
