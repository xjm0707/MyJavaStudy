import java.lang.reflect.*;
public class MethodDemo{
	public static void main(String[] args)throws Exception{
		Class clazz=Class.forName("Student");
		//拿到实例对象
		Object o=clazz.newInstance();
		Method m=clazz.getDeclaredMethod("study",new Class[]{});
		m.invoke(o,new Object[]{});//调用无参方法
		Method m1=clazz.getDeclaredMethod("study",String.class);
		m1.invoke(o,"java");//调用有参方法
	}
}