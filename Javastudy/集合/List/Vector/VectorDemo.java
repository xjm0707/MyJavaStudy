import java.util.Vector;
import java.util.Enumeration;
public class VectorDemo{
	public static void main(String[] args) {
		Vector v=new Vector();
		v.addElement("香蕉");
		v.addElement("苹果");
		v.addElement("西瓜");

		v.add(1,"葡萄");//指定位置添加元素
		
		System.out.println(v);
		System.out.println();

		Enumeration e=v.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	}
}