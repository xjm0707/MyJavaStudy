import java.io.*;
import java.lang.reflect.*;
public class Test{
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("t.txt"));
		String line=null;
		while((line=br.readLine())!=null){
			Class<?> cls=Class.forName(line);
			Object o=cls.getConstructor(new Class[]{String.class,int.class}).newInstance(new Object[]{line.equals("Student")?"赵同学":"薛老师",line.equals("Student")?20:30});
			System.out.println(o);
			Field [] fields=cls.getDeclaredFields();
			for(Field f:fields){
				f.setAccessible(true);
				System.out.println(f+"---"+f.get(o));
			}
			if(line.equals("Student")){
				Method toString=cls.getDeclaredMethod("toString",new Class[]{});
				System.out.println(toString.invoke(o,new Object[]{}));
				Method study1=cls.getDeclaredMethod("study",new Class[]{});
				study1.invoke(o,new Object[]{});
				Method study2=cls.getDeclaredMethod("study",new Class[]{String.class});
				study2.invoke(o,new Object[]{"java"});
			}
			if(line.equals("Teacher")){
				Method toString=cls.getDeclaredMethod("toString",new Class[]{});
				System.out.println(toString.invoke(o,new Object[]{}));
				Method teach1=cls.getDeclaredMethod("teach",new Class[]{});
				teach1.invoke(o,new Object[]{});
				Method teach2=cls.getDeclaredMethod("teach",new Class[]{String.class});
				teach2.invoke(o,new Object[]{"java"});
			}
		}
	}
}