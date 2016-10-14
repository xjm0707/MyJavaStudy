package com.io.base;
import java.io.*;
/**
 *BufferedInputStream和BufferedOutputStream的基本使用
 * @author yn
 *
 */
public class BufferedStreamDemo{
	public static void main(String[] args) throws IOException{
		//1、BufferedInputStream的用法:
		FileInputStream fis=new FileInputStream("E:/a.txt");
		//BufferedInputStream带有缓冲区，可以提高读的效率
		BufferedInputStream bis=new BufferedInputStream(fis);//将fis中的数据一次性保存到bis中的数组
		
		byte[] b=new byte[6];
		int len=0;
		len=bis.read(b);
		System.out.println(new String(b,0,len));
		bis.close();
		
		//2、BufferedOutputStream的用法:
		FileOutputStream fos=new FileOutputStream("E:/abc.txt");
		//BufferedOutputStream带有缓冲区，可以提高写的效率
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write("你好".getBytes());
		bos.flush();//将数据从内存中刷新到硬盘中
		//bos.write("123".getBytes());//可以继续写数据
		//bos.flush();//再将数据从内存中刷新到硬盘中
		bos.close();//内部自己调用了flush()将缓冲区的数据先写到目标数据中，然后再关闭资源，关闭之后不可以再写数据了		
	
		//3、下面是使用标记进行重复读取数据的代码，基本不用
		/*System.out.println(new String(b,0,len));//abc
		bis.mark(2);
		bis.read(b);
		System.out.println(new String(b,0,len));//def
		bis.reset();
		len=bis.read(b);
		System.out.println(new String(b,0,len));//def*/			
	}
}