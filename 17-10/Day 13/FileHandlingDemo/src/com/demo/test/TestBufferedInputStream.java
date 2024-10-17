package com.demo.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBufferedInputStream {

	public static void main(String[] args) {
		File f=new File("test1copy.txt");
		BufferedOutputStream bos=null;
		try {
		if(f.exists()) {
			//effectively final
			//open the file in append mode
			bos=new BufferedOutputStream(new FileOutputStream(f,true));
		}else {
			//open the file in write mode
			bos=new BufferedOutputStream(new FileOutputStream(f));
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		try(BufferedInputStream bis=new BufferedInputStream(new FileInputStream("test1.txt"));
				BufferedOutputStream bos1=bos;){
			//read one byte and write one byte till end of the file
			int c=bis.read();
			while(c!=-1) {
				bos.write(c);
				c=bis.read();
			}
			
			
		}catch(FileNotFoundException e) {
			System.out.println("file not found");
		}catch(IOException e) {
			System.out.println("input output error occured");
		}
		

	}

}
