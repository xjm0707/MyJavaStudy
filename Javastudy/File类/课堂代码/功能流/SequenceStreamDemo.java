import java.io.*;
import java.util.*;
/**
 * SequenceInputStream的使用
 * @author yn
 *
 */
public class SequenceInputStreamDemo{
	public static void main(String[] args) throws IOException{
		/*
		 无论是什么流对象，使用方式基本一样：
		1、根据需求定义流对象（输入流，输出流）
		2、是否需要提高效率，如果要，就是用Buffered
		3、拷贝的基本写法(数组byte[]、char[]、变量、while,read(),write())
		4、关闭流对象
		*/
		
		//两个文件的合并
		BufferedInputStream bis1=new BufferedInputStream(new FileInputStream("D:/a.txt"));
		BufferedInputStream bis2=new BufferedInputStream(new FileInputStream("D:/b.txt"));

		SequenceInputStream sis=new SequenceInputStream(bis1,bis2);
		FileOutputStream fos=new FileOutputStream("D:/c.txt");

		byte[] b=new byte[2];
		int len=0;
		while((len=sis.read(b))!=-1){
			fos.write(b,0,len);
		}
		sis.close();
		fos.close();
		
		//将多个文件进行合并
		Vector<FileInputStream> v=new Vector<FileInputStream>();
		v.add(new FileInputStream("D:/utf8.txt"));
		v.add(new FileInputStream("D:/utf81.txt"));
		//v.add(new FileInputStream("D:/c.txt"));
		conbineFile(v,"D:/d.txt");
	}
	/**
	 * 合并多个文件，使用默认的字符集编码，一般用于媒体文件的合并，相同编码格式的文本进行合并没有问题，不同则会出现乱码
	 * 不同编码格式的文本文件的合并，请使用CopyFileUtil.java中的copy4()方法
	 * @param v Vector集合，用于添加多个文件
	 * @param destPath 合并后的文件地址
	 * @throws IOException 抛出IO异常
	 */ 
	public static void conbineFile(Vector<FileInputStream> v,String destPath)throws IOException{
		SequenceInputStream sis=new SequenceInputStream(v.elements());
		FileOutputStream fos=new FileOutputStream(destPath);
		byte[] b=new byte[3];
		int len=0;
		while((len=sis.read(b))!=-1){
			fos.write(b,0,len);
		}
		fos.close();
		sis.close();
	}	
}