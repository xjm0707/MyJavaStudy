import java.lang.reflect.*;
public class FieldDemo{
	public static void main(String[] args)throws Exception{
		Class clazz=Class.forName("Student");
		Object o=clazz.newInstance();//通过类名获取一个对象

		Field f=clazz.getDeclaredField("name");//获取对象的属性
		Field f1=clazz.getDeclaredField("age");
		
		// Field[] f3=clazz.getFields();
		// for (Field f4 :f3 ) {
		// 	System.out.println(f4);
		// }

		System.out.println(f);//打印对象的属性
		System.out.println(f1);

		Object name=f.get(o);//获取对象属性的值
		int age=f1.getInt(o);
		
		System.out.println(name);//打印属性值
		System.out.println(age);

		f.set(o,"lishi");//更改属性值
		f1.set(o,30);
		Object name1=f.get(o);
		int age1=f1.getInt(o);
		System.out.println(name1);
		System.out.println(age1);
	}
}