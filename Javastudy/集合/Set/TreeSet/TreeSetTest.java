import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;
public class TreeSetTest{
	public static void main(String[] args) {
		TreeSet ts=new TreeSet(new MyComparator1());
		ts.add("aaa");
		ts.add("bbbbbb");
		ts.add("cccc");
		ts.add("ddddd");
		
		for (Iterator it=ts.iterator();it.hasNext(); ) {
			System.out.println(it.next());
		}		
	}
}
//升序排序
class MyComparator implements Comparator{
	public int compare(Object o1,Object o2){
		String str1=(String)o1;
		String str2=(String)o2;		
		return new Integer(str1.length()).compareTo(new Integer(str2.length()));		
	}
}
//降序排序
class MyComparator1 implements Comparator{
	public int compare(Object o1,Object o2){
		String str1=(String)o1;
		String str2=(String)o2;		
		if (str1.length()>str2.length()) {
			return -1;
		}
		if (str1.length()<str2.length()) {
			return 1;
		}
		return 0;		
	}
}

