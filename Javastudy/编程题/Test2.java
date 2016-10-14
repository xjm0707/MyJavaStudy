import java.util.*;
/*
有一个学生数组stu[] s={学生1，学生2，...};按照学生的年龄和姓名进行自然排序。（提示：使用Arrays.sort()，具体看jdk文档）
*/

//第一种写法:让Student实现Comparable接口
public class Test2{
	public static void main(String[] args) {
		Student [] students=new Student []{new Student("张三",18),new Student("李四",17),new Student("王五",19)};
		Arrays.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}
	}
}

class Student implements Comparable<Student>{
	String name;
	int age;
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return name+","+age;
	}
	public int compareTo(Student s){
		if(this.age==s.age){
			return this.name.compareTo(s.name);
		}
		return this.age-s.age;
	}
}
//第二种写法：使用比较器
/*public class Test{
	public static void main(String[] args) {
		Student [] students=new Student []{new Student("张三",18),new Student("李四",17),new Student("王五",19)};
		Arrays.sort(students,new Comparator<Student>(){
			public int compare(Student s1,Student s2){
				if(s1.age==s2.age){return s1.name.compareTo(s2.name);}
				return s1.age-s2.age;
			}});
		for (Student s : students) {
			System.out.println(s);
		}
	}
}

class Student{
	String name;
	int age;
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return name+","+age;
	}
}*/