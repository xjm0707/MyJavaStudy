import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;
public class TreeSetDemo{
	public static void main(String[] args) {
		TreeSet ts=new TreeSet(new MyComparator2());
		ts.add(new Phone("1诺基亚",1000));
		ts.add(new Phone("3苹果",1000));
		ts.add(new Phone("2htc",1000));
		ts.add(new Phone("5meizu",1000));
		ts.add(new Phone("4三星",1000));

		for (Iterator it=ts.iterator();it.hasNext(); ) {
			System.out.println(it.next());
		}		
	}
}
class Phone implements Comparable{
	String name;
	int price;
	public Phone(String name,int price){
		this.name=name;//次要判断条件
		this.price=price;//主要判断条件
	}
	public int compareTo(Object o){
		Phone p=(Phone)o;
		if (this.price>p.price) {
			return 1;
		}
		if (this.price==p.price) {
			return this.name.compareTo(p.name);
		}
		return -1;
	}
	public String toString(){
		return "("+name+","+price+")";
	}
}
//升序排序
class MyComparator implements Comparator{
	public int compare(Object o1,Object o2){
		Phone p1=(Phone)o1;
		Phone p2=(Phone)o2;
		//String类型本身就有compareTo的方法 如果是基本数据类型就必须将其封装
		return p1.name.compareTo(p2.name);//比较手机品牌
		//return new Integer(p1.price).compareTo(new Integer(p2.price));//比较价格
	}
}
//降序排序
class MyComparator2 implements Comparator{
	public int compare(Object o1,Object o2){
		Phone p1=(Phone)o1;
		Phone p2=(Phone)o2;
		if (p1.name.compareTo(p2.name)>0) {
			return -1;
		}
		if (p1.name.compareTo(p2.name)<0) {
			return 1;
		}
		return 0;
	}
}