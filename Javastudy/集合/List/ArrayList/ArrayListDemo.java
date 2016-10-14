import java.util.List;
import java.util.ArrayList;
public class ArrayListDemo{
	public static void main(String[] args) {
		ArrayList a1=new ArrayList();
		a1.add("java01");
		a1.add("java02");
		a1.add("java03");
		a1.add("java04");
		a1.set(1,"c++");//将位置1的元素改为“c++”

		List a2=a1.subList(1,3);//截取1~3位置的元素 不包括3
		System.out.println(a1);
		System.out.println(a2);
		System.out.println();

		a1.add(1,"php");//在位置1添加元素“php”
		for (int i=0;i<a1.size();i++) {
			System.out.println(a1.get(i));
		}

		//System.out.println(a1);

		a1.remove(1);//移除位置1的元素
		System.out.println();
		for (int i=0;i<a1.size();i++) {
			System.out.println(a1.get(i));
		}
	}
}