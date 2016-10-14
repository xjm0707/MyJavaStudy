import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
public class LinkedListTest{
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		Student s1=new Student("张三",23,"男");
		Student s2=new Student("李四",25,"男");
		Student s3=new Student("王五",24,"女");
		Student s4=new Student("张三",23,"男");
		Student s5=new Student("赵六",25,"女");
		l.add(s1);
		l.add(s2);
		l.add(s3);
		l.add(s4);
		l.add(s5);

		LinkedList l2=new LinkedList();
		
		Iterator it=l.iterator();
		while(it.hasNext()){
			Student s=(Student)it.next();
			if (!l2.contains(s)) { 
				l2.addFirst(s);
			}
		}
		System.out.println(l2);
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