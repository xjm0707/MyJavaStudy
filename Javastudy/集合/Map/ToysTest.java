import java.util.*;
public class ToysTest{
	public static void main(String[] args) {
		TreeMap tm=new TreeMap(new MyComparator1());
		tm.put(new Toys("1纸飞机",100),"中国");
		tm.put(new Toys("2变形金刚",100),"美国");
		tm.put(new Toys("3布娃娃",100),"中国");
		tm.put(new Toys("4高达",100),"日本");

		Set s=tm.keySet();
		Iterator it=s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
class Toys implements Comparable{
    String name;
    int price;
    public Toys(String name,int price){
    	this.name=name;
    	this.price=price;
    }
    public int compareTo(Object o){
    	Toys t=(Toys)o;
    	if (this.price>t.price) {
    		return 1;
    	}
    	if (this.price==t.price) {
    		return this.name.compareTo(t.name);
    	}
    	return -1;
    }
    public String toString(){
    	return "("+name+","+price+")";
    }
}
class MyComparator1 implements Comparator{
	public int compare(Object o1,Object o2){
		Toys p1=(Toys)o1;
		Toys p2=(Toys)o2;
		if (p1.price>p2.price) {
    		return 1;
    	}
    	if (p1.price==p2.price) {
    		return p1.name.compareTo(p2.name);
    	}
    	return -1;
	}
}
class MyComparator2 implements Comparator{
	public int compare(Object o1,Object o2){
		Toys p1=(Toys)o1;
		Toys p2=(Toys)o2;
		if (p1.price<p2.price) {
    		return 1;
    	}
    	if (p1.price==p2.price) {
    		return p2.name.compareTo(p1.name);
    	}
    	return -1;
	}
}