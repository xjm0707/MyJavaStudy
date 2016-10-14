import java.lang.reflect.*;
/*
反射的应用 通过反射机制修改被封装的数据(破解专用！)
*/
public class FieldTest{
	public static void main(String[] args)throws Exception{
		Class clazz=Class.forName("Student");
		//拿到实例对象
		Object o=clazz.newInstance();
		// Constructor con=clazz.getConstructor(String.class,int.class);
		// Object o=con.newInstance("lisi",23);

		/*
		   筛选合适的属性
		   f1.getModifiers()==Modifier.PRIVATE   判断属性的修饰符是否为private
		   f1.getType()==String.class   判断属性的类型(比较地址 也可用equals)
		*/
		Field[] f=clazz.getDeclaredFields();//得到所有的属性
		for (Field f1 :f ) {
			if (f1.getModifiers()==Modifier.PRIVATE&& f1.getType()==String.class) {
				f1.setAccessible(true);//true 取消 Java 语言访问检查 就可以修改private封装的属性 
				String p1=(String)f1.get(o);//得到属性值 
				String p2=p1.replaceAll("无","有");//修改
				f1.set(o,p2);//属性值重设
				System.out.println(f1.get(o));		
			}
		}

	}
}