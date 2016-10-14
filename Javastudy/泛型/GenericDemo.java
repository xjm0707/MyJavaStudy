public class GenericDemo{
	public static void main(String[] args) {
		Teacher t=new Teacher("老师");
		Student s=new Student("学生");
		
		Utils<Person> u=new Utils<Person>();
		u.setElements(s);
		u.setElements(t);
	}
}
class Utils<T extends Person>{
    T t;
    public Utils(){}
    public Utils(T t){
    	this.t=t;
    }
    public T get(){
    	return t;
    }
    public void setElements(T t){
        this.t=t;
        System.out.println("-----setElements-----");
    }
    public <Q>void print(Q t){
    	System.out.println(t);
    }
}

class Person{
    String name;
    public Person(String name){
    	this.name=name;
    }
}
class Teacher extends Person{
	public Teacher(String name){
        super(name);
	}
	public void teach(){
		System.out.println("教书");
	}
}
class Student extends Person{
	public Student(String name){
		super(name);
	}
	public void study(){
		System.out.println("学习");
	}
}