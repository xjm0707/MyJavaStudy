import java.util.ArrayList;
public class CollectionDemo{
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add("香蕉");
		al.add("苹果");
		al.add("葡萄");
		ArrayList al2=new ArrayList();
		al2.add("洗发水");
		al2.add("沐浴露");
		al2.add("香蕉");
		
		al.retainAll(al2);//取al和al2的交集元素
		System.out.println(al.size());
		System.out.println(al.toString());

		al.addAll(al2);//将al2中的元素添加到al中
		System.out.println(al.size());
		System.out.println(al.toString());

		// al.remove("洗发水");//将洗发水从集合中移除
		// System.out.println(al.size());
		// System.out.println(al.toString());

		// al.clear();//清除集合中的所有元素
		// System.out.println(al.size());
		// System.out.println(al.toString());

		System.out.println(al.isEmpty());//判断集合是否为空
		System.out.println(al.contains("香蕉"));//判断集合中是否包含有香蕉这个元素
		System.out.println(al.containsAll(al2));

	}
}