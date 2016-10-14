public class ClassDemo{
	public static void main(String[] args)throws Exception{
		Class clazz=Student.class;
		Class clazz1=new Student("lisi",10).getClass();
		Class clazz2=Class.forName("Student");
		System.out.println(clazz);
	}
}
class Student{
	private String name="无名";
	private String name1="无姓";
	private String name2="大名";
	private String name3="心无";
	private int age=0;
	private int sex;
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
		return "姓名："+name+" 年龄："+age;
	}
}