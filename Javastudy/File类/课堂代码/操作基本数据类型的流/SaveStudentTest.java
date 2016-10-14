package com.io.work;

import java.io.*;
import java.util.TreeSet;

public class SaveStudentTest {
	public static void main(String[] args)throws Exception{
		//向集合中添加学生		
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student("lishi", 23));
		ts.add(new Student("zhaoliu", 24));
		ts.add(new Student("wangwu", 25));
		
		// 将集合写入文件中
		FileOutputStream fos = new FileOutputStream("D:/object.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ts);
		oos.close();
		
		//读取文件中的集合
		FileInputStream fis=new FileInputStream("D:/object.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Object o=ois.readObject();
		System.out.println((Student)o);
		ois.close();
	}
}

/*
 * 需要被序列化的类要实现Serializable接口，但是不用实现方法，因为没有抽象方法
 */
class Student implements Serializable, Comparable<Student> {
	private static final long serialVersionUID = 2L;// 用来区分相同类名的类
	String name;
	transient int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + "," + age;
	}

	public int compareTo(Student o) {
		if (this.age == o.age) {
			return this.name.compareTo(o.name);
		}
		return this.age - o.age;
	}
}
