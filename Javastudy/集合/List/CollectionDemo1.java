import java.util.ArrayList;
import java.util.Iterator;
public class CollectionDemo1{
	public static void main(String[] args) {
		ArrayList al1=new ArrayList();
		Person p1=new Person("张三1",23);
		Person p2=new Person("张三2",24);
		Person p3=new Person("张三3",25);
		al1.add(p1);
		al1.add(p2);
		al1.add(p3);
		ArrayList al2=new ArrayList();
		Person p4=new Person("张三1",23);
		Person p5=new Person("张三2",24);
		Person p6=new Person("张三3",25);
		al2.add(p4);
		al2.add(p5);
		al2.add(p6);
		System.out.println(al1.equals(al2));

		Iterator it=al1.iterator();//通过集合内部的一个方法生成迭代器
		
		while(it.hasNext()){//如果有下一个元素，进行以下操作
			Object o=it.next();//取出集合的元素
			Person p=(Person)o;//将元素强转回指定类型
			p.setName("W");//可以随意更改元素的属性
			System.out.println(p.name+"..."+p.age);
		}
	}
}
class Person{
	String name;
	int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void setName(String name){
        this.name=name;
	}
	public String toString(){
		return name+":"+age;
	}
	//集合判断是否相等，需要依次判断里面的所有元素是否相等
	//判断元素是否相等又要判断元素所有属性是否相等
	public boolean equals(Object o){//重写ArrayList中的equals()方法
        Person p=(Person)o;
		if (this.age==p.age&&this.name.equals(p.name)) {
			return true;//比较元素内容相等，则返回true
		}
		return false;
	}
}