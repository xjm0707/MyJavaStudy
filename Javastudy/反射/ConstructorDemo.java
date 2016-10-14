import java.lang.reflect.*;
/*
通过反射创建实例对象
*/
public class ConstructorDemo{
	public static void main(String[] args)throws Exception{
		//通过无参的构造方法创建实例对象
		Class clazz=Class.forName("Student");
		Student s=(Student)clazz.newInstance();
		System.out.println(s);
		/*
		通过getConstructor()获取有参的构造方法
		可变参数，你要几个参数，就写几个参数
		*/
		Constructor con=clazz.getConstructor(String.class,int.class);
		//通过构造方法创建实例对象
		Object o=con.newInstance("lishi",20);
		System.out.println(o);
		//获取任意修饰符的有参构造函数
		Constructor con1=clazz.getDeclaredConstructor(String.class);
		Object o1=con1.newInstance("lishi");
		System.out.println(o1);
		/*
		获取所有public修饰的构造函数
		*/
		Constructor[] constructors=clazz.getConstructors();
		for (Constructor c:constructors) {
			System.out.println(c);
		}
		/*
		获取所有构造函数
		*/
		Constructor[] constructors1=clazz.getDeclaredConstructors();
		for (Constructor c:constructors1) {
			System.out.println(c);
		}
	}
}