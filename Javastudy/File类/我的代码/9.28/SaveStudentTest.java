/*
将集合中的所有学生对象写入文件中
*/
import java.io.*;
import java.util.*;
public class SaveStudentTest{
	public static void main(String[] args)throws Exception{
		ArrayList<Student> al=new ArrayList<Student>();
		al.add(new Student("zhangsan",23));
		al.add(new Student("lisi",23));
		al.add(new Student("wangwu",23));

		FileOutputStream fos=new FileOutputStream("E:/w.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);

		Iterator<Student> it=al.iterator();
		while(it.hasNext()){
			Student s=it.next();
			oos.writeObject(s);
		}
		oos.close();

		FileInputStream fis=new FileInputStream("E:/w.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);

		for (int i=0;i<al.size();i++) {
			Object o=ois.readObject();
		    System.out.println(o);
		}	
		ois.close();
	}
}
class Student implements Serializable{
	public final long serialVersionUID=1L;
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