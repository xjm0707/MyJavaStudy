import java.lang.reflect.*;
import java.io.*;
public class ReflectTest{
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("/Users/abc123/desktop/name.txt")));
		String str="";
		while((str=br.readLine())!=null){
			Class clazz=Class.forName(str);
			Object o=clazz.newInstance();
			System.out.println("-------创建实例对象-------");
			System.out.println(o);
			System.out.println("-------输出所有属性-------");
			Field[] fs=clazz.getDeclaredFields();
			for (Field f : fs ) {
				System.out.println("属性名："+f);
				f.setAccessible(true);
				Object value=f.get(o);
				System.out.println("属性值："+value);
			}
			System.out.println("-------调用所有方法-------");
			if(str.equals("Student")){
				Method toString=clazz.getDeclaredMethod("toString",new Class[]{});
				System.out.println("方法名："+toString.getName());
				toString.invoke(o,new Object[]{});
				Method study1=clazz.getDeclaredMethod("study",new Class[]{});
				System.out.println("方法名："+study1.getName());
				study1.invoke(o,new Object[]{});
				Method study2=clazz.getDeclaredMethod("study",new Class[]{String.class});
				System.out.println("方法名："+study2.getName());
				study2.invoke(o,new Object[]{"java"});
			}
			if(str.equals("Teacher")){
				Method toString=clazz.getDeclaredMethod("toString",new Class[]{});
				System.out.println("方法名："+toString.getName());
				toString.invoke(o,new Object[]{});
				Method teach1=clazz.getDeclaredMethod("teach",new Class[]{});
				System.out.println("方法名："+teach1.getName());
				teach1.invoke(o,new Object[]{});
				Method teach2=clazz.getDeclaredMethod("teach",new Class[]{String.class});
				System.out.println("方法名："+teach2.getName());
				teach2.invoke(o,new Object[]{"java"});
				Method getMoney=clazz.getDeclaredMethod("getMoney",new Class[]{String.class});
				System.out.println("方法名："+getMoney.getName());
				getMoney.invoke(o,new Object[]{"100万"});
			}
		}
	}
}
