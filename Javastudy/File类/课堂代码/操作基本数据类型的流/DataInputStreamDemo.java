package com.io.baseDataStream;
import java.io.*;
/**
 * 通过DataInputStream和DataOutputStream可以完成对基本数据类型的读写
 * @author yn
 *
 */
public class DataInputStreamDemo{
	public static void main(String[] args) throws IOException{
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("D:/abc.txt"));
		//dos.writeInt(123456);//4字节
		dos.writeDouble(100.0);//写入一个double类型的数据，占8字节
		dos.close();
		
		DataInputStream dis=new DataInputStream(new FileInputStream("D:/abc.txt"));
		double d=dis.readDouble();//读取一个double类型的数据，8字节；注意：若读取的大小超过了文本的大小，会报EOFException异常
		System.out.println(d);
		dis.close();
	}
}