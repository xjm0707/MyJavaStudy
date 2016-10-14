public class Student{
	private String name;
	/*private*/ int age;
	public Student(){

	}
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "student--"+name+"--"+age;
	}
	public void study(){
		System.out.println("学习");
	}
	public void study(String subject){
		System.out.println("学习"+subject);
	}
}