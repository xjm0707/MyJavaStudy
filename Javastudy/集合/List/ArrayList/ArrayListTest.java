import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class ArrayListTest{
	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		Student s1=new Student("张三",23,"男");
		Student s2=new Student("李四",25,"男");
		Student s3=new Student("王五",24,"女");
		Student s4=new Student("张三",23,"男");
		Student s5=new Student("赵六",25,"女");
		a1.add(s1);
		a1.add(s2);
		a1.add(s3);
		a1.add(s4);
		a1.add(s5);

		ArrayList a2=new ArrayList();
		
		Iterator it=a1.iterator();
		while(it.hasNext()){
			Student s=(Student)it.next();
			//如果a2集合中不包含元素s，则往a2中添加元素s
			if (!a2.contains(s)) { //contains是调用的equals()方法,所以需要重写equals()方法
				a2.add(s);
			}
		}
		System.out.println(a2);
	}
}
class Student{
	String name;
	int age;
	String sex;
	public Student(String name,int age,String sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	public boolean equals(Object o){
		Student s=(Student)o;
		if (this.name.equals(s.name)&&this.age==s.age&&this.sex.equals(s.sex)) {
			return true;
		}
		return false;
	}
	public String toString(){
		return "("+name+":"+age+"岁,"+sex+")";
	}
}