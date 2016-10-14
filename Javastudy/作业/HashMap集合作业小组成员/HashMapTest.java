import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
public class HashMapTest{
	public static void main(String[] args) {
		HashSet hs1=new HashSet();
		hs1.add(new Student("丁建文",23));
		hs1.add(new Student("徐江民",23));
		hs1.add(new Student("倪钢强",23));
		hs1.add(new Student("李继鑫",23));

		HashSet hs2=new HashSet();
		hs2.add(new Student("刘飞",23));
		hs2.add(new Student("方源江",23));
		hs2.add(new Student("姜敏辉",23));
		hs2.add(new Student("韩宏",23));

		HashSet hs3=new HashSet();
		hs3.add(new Student("王征飞",23));
		hs3.add(new Student("张东瀛",23));
		hs3.add(new Student("王玉坤",23));
		hs3.add(new Student("朱民甲",23));

		HashSet hs4=new HashSet();
		hs4.add(new Student("叶鹏飞",23));
		hs4.add(new Student("焦冲冲",23));
		hs4.add(new Student("郑敏豪",23));
		hs4.add(new Student("赵世松",23));

		HashSet hs5=new HashSet();
		hs5.add(new Student("张艺文",23));
		hs5.add(new Student("程羽童",23));
		hs5.add(new Student("师立健",23));
		hs5.add(new Student("刘圣奇",23));

		HashSet hs6=new HashSet();
		hs6.add(new Student("郑广磊",23));
		hs6.add(new Student("楼佳程",23));
		hs6.add(new Student("张钰杰",23));

		HashMap hm=new HashMap();
		hm.put("丁建文",hs1);
		hm.put("刘飞",hs2);
		hm.put("王征飞",hs3);
		hm.put("叶鹏飞",hs4);
		hm.put("张艺文",hs5);
		hm.put("郑广磊",hs6);

		//用keySet（）和get（key）方法进行迭代
		Set set=hm.keySet();
		for(Iterator it=set.iterator();it.hasNext();){
			String key=(String)it.next();
			System.out.println(key+"组:");
			for(Iterator it1=((HashSet)hm.get(key)).iterator();it1.hasNext();){
				System.out.println(it1.next());
			}
			System.out.println();
		}

		System.out.println("---------------------------------");
		//用entrySet（）和getKey（），getValue（）方法进行迭代
		for(Iterator it=hm.entrySet().iterator();it.hasNext();){
			Map.Entry entry=(Map.Entry)it.next();
			System.out.println(entry.getKey()+"组：");
			for(Iterator it1=((HashSet)entry.getValue()).iterator();it1.hasNext();){
				System.out.println(it1.next());
			}
		}
	}
}
class Student{
	private String name;
	private int age;
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return "("+name+"--"+age+"岁)";
	}
	public boolean equals(Object o){
		Student t=(Student)o;
		if(this.name.equals(t.name)&&this.age==t.age){
			return true;
		}
		return false;
	}
	public int hashCode(){
		return name.hashCode()+age;
	}


}