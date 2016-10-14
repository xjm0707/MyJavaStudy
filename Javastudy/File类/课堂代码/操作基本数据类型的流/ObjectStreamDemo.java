package com.io.baseDataStream;
import java.io.*;

public class ObjectStreamDemo{
	public static void main(String[] args)throws Exception{
		//将一个对象写入文件中
		FileOutputStream fos=new FileOutputStream("D:/q.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(new Student("lishi",23));//将学生这个对象写到文件中
		oos.close();

		//将文件中的对象读取出来
		FileInputStream fis=new FileInputStream("D:/q.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Object o=ois.readObject();
		System.out.println((Student)o);
		ois.close();		
	}
}
/*
需要被序列化的类要实现Serializable接口，但是不用实现方法，因为没有抽象方法
*/
class Student implements Serializable,Comparable<Student>{
	private static final long serialVersionUID = 1L;//用来区分相同类名的类
	String name;
	transient int age;
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return name+","+age;
	}
	public int compareTo(Student o){
		if(this.age==o.age){
			return this.name.compareTo(o.name);
		}
		return this.age-o.age;
	}
}
