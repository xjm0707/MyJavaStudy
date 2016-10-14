public class Teacher{
	private String name;
	/*private*/ int age;
	public Teacher(){

	}
	public Teacher(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "Teacher--"+name+"--"+age;
	}
	public void teach(){
		System.out.println("上课");
	}
	public void teach(String subject){
		System.out.println("上课"+subject);
	}
}