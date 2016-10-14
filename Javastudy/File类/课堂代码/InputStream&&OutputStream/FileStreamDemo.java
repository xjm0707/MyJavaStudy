package com.io.base;
import java.io.*;
/**
 * FileInputStream和FileOutputStream的用法
 * @author yn
 *
 */
public class FileStreamDemo{
	public static void main(String[] args) throws IOException{
		FileInputStream fis=new FileInputStream("E:/a.txt");		
		byte[] b=new byte[6];
		int len=0;
		len=fis.read(b);
		System.out.println(new String(b,0,len));//可以通过String的构造方法指定字符集
		fis.close();
		
		FileOutputStream fos=new FileOutputStream("E:/b.txt");		
		fos.write("你好".getBytes("UTF-8"));//通过getBytes()来指定字符集
		fos.close();	
	}
}