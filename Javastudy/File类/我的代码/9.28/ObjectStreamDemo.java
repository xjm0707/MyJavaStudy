import java.io.*;
public class ObjectStreamDemo{
	public static void main(String[] args)throws Exception{
		FileOutputStream fos=new FileOutputStream("E:/Q.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);

		oos.writeObject(new Student("李四",23));//将学生对象写入文件
		oos.close();

		FileInputStream fis=new FileInputStream("E:/Q.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);

		Object o=ois.readObject();
		System.out.println(o);
		ois.close();
	}
}
class Student implements Serializable{
	public static final long serialVersionUID=2L;
	String name;
	int age;
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return name+","+age;
	}
}