public class Student{
	private String name="无名同学";
	private String name1="无姓同学";
	private int age=0;
	public Student(){} 
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	Student(String name){
		this.name=name;
	}
	public void study(){
		System.out.println("学习");
	}
	public void study(String subject){
		System.out.println("学习"+subject);
	}
	public String toString(){
		return "姓名："+name+" 年龄："+age+ " 姓名："+name1+" 年龄："+age;
	}
}
class Teacher{
	private String name="无名老师";
	private String name1="无姓老师";
	private int age=0;
	public Teacher(){} 
	public Teacher(String name,int age){
		this.name=name;
		this.age=age;
	}
	Teacher(String name){
		this.name=name;
	}
	public void teach(){
		System.out.println("教学");
	}
	public void teach(String subject){
		System.out.println("教学"+subject);
	}	
	public void getMoney(String money){
		System.out.println("挣钱"+money);
	}
	public String toString(){
		return "姓名："+name+" 年龄："+age+ " 姓名："+name1+" 年龄："+age;
	}
}