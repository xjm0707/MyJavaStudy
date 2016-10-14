import java.lang.reflect.*;
import java.util.Scanner;
public class Classtest{
	public static void main(String[] args)throws Exception{
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.println("请输入类名:");
			String className=input.next();
			System.out.println("已创建无参的实例对象(学生信息)");
			Object o=getInstance(className);
			System.out.println(o);
			System.out.println();

			System.out.println("请输入姓名");
			String name=input.next();
			System.out.println("请输入年龄");
			int age=input.nextInt();
			
			Object[] params=new Object[]{name,new Integer(age)};
			Class[] types=new Class[]{String.class,int.class};

			System.out.println("已创建有参的实例对象(学生信息)");
			Object o1=getInstance(className,types,params);
			System.out.println(o1);
		}
	}
	/**
	*通过类名和参数创建出无参的实例对象
	*@param className 类名
	*@param Object 返回创建好的实例对象
	*/
	public static Object getInstance(String className)throws Exception{
		Class clazz=Class.forName(className);
		return clazz.newInstance();
	}
	/**
	*通过类名和参数创建出有参的实例对象
	*@param className 类名
	*@param types 所有参数的类型
	*@param params 所有参数的值
	*@param Object 返回创建好的实例对象
	*/0
	public static Object getInstance(String className,Class[] types,Object[] params)throws Exception{
		Class clazz=Class.forName(className);
		Constructor con=clazz.getConstructor(types);
		return con.newInstance(params);
	}
}