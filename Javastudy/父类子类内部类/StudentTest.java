/**
*继承
*父类 子类
*
*/
public class StudentTest{
	public static void main(String[] args) {
		
		JavaStudent j=new JavaStudent("sdf",20,1);
		CStudent c=new CStudent("wef",19,0);

		j.introduce();
		j.study();
		j.sleep();

		c.introduce();
		c.study();
		//c.sleep();
	}
}
/**
*父类 Student
*  1.子类构造函数的第一行一定会调用父类的构造函数
*  2.通过super（参数）来调用父类的有参构造函数
*  3.如果父类不写默认的构造函数，那么子类必须手动调用父类中的有参构造函数，super（参数）
*
*/
class Student{
	String name;
	int age;
	int sex;
	//public Student(){}
	public Student(String name,int age,int sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	void study(){
		System.out.println("学习");
	}
	void sleep(){
		System.out.println("睡觉");
	}
	void introduce(){
		System.out.println(name+" "+age+" "+sex);
	}
}
/**
*两个子类：JavaStudent  CStudent
*
*/
class CStudent extends Student{

	//public CStudent(){}
	public CStudent(String name,int age,int sex){
         super(name,age,sex);
		// this.name=name;
		// this.age=age;
		// this.sex=sex;
    }	
	void study(){
		super.sleep();//通过super 来调用父类中的方法
		System.out.println("学习c语言");
	}

}
class JavaStudent extends Student{

	//public JavaStudent(){}
	public JavaStudent(String name,int age,int sex){
		super(name,age,sex);
		// this.name=name;
		// this.age=age;
		// this.sex=sex;
    }
	void study(){
		System.out.println("学习java");
	}

}