import java.util.ArrayList;
import java.util.Iterator;
public class ShopCarTest{
	public static void main(String[] args) {
		ArrayList shopCar=new ArrayList();
		Production p1=new Production("藿香正气水",50);
		Production p2=new Production("六味地黄丸",30);
		Production p3=new Production("藿香正气水",50);
		Production p4=new Production("老坛酸菜面",10);
		Production p5=new Production("六味地黄丸",30);
		Production p6=new Production("葵花胃康灵",20);
		Production p7=new Production("六味地黄丸",30);
		Production p8=new Production("藿香正气水",50);
		Production p9=new Production("老坛酸菜面",10);
		Production p10=new Production("六味地黄丸",30);
		Production p11=new Production("六味地黄丸",30);
        
        //将所有商品添加到集合购物车shopCar中
		shopCar.add(p1);
		shopCar.add(p2);
		shopCar.add(p3);
		shopCar.add(p4);
		shopCar.add(p5);
		shopCar.add(p6);
		shopCar.add(p7);
		shopCar.add(p8);
		shopCar.add(p9);
		shopCar.add(p10);
		shopCar.add(p11);
		
		/**
		*将shopCar中不重复的的元素传入一个新的集合购物袋shopBag当中
		*/
		ArrayList shopBag=new ArrayList();		
		Iterator it=shopCar.iterator();//通过shopCar生成一个迭代器it
		while(it.hasNext()){
			Production p=(Production)it.next();
			if (!shopBag.contains(p)) {//判断如果shopBag集合中不包含元素p，则往shopBag中添加元素p
				shopBag.add(p);
			}
		}
		
		//给商品计数
		int[] num=new int[shopCar.size()];//新建一个num数组
		for (int i=0;i<shopBag.size();i++) {
			Iterator it1=shopCar.iterator();//通过shopCar生成一个新的迭代器it1
			while(it1.hasNext()){
				Production p=(Production)it1.next();
				if (shopBag.get(i).equals(p)) {//将集合shopBag中的每一个元素和迭代器中的每一个元素循环比较
					num[i]=num[i]+1;//如果内容相同，则商品数量＋1
				}
			}
		}

		//循环输出商品内容和通过计数后的数量
		System.out.println("您的购物车中有以下物品:");
		for (int i=0;i<shopBag.size();i++) {
			System.out.print(shopBag.get(i));
			System.out.println(" 数量:"+num[i]);
		}
		
		//计算总价
		int allPrice=0;
		for (int i=0;i<shopBag.size();i++) {
		    //循环将集合shopBag中的元素强转回对象production，调用getPrice()获得单价，总价就等于单价乘以数量
			allPrice=allPrice+(((Production)shopBag.get(i)).getPrice()*num[i]);
		}
		System.out.println("您需要支付"+allPrice+"元");
	}
}
class Production{
	String name;
	int price;
	int num;
	public Production(String name,int price){
		this.name=name;
		this.price=price;
		this.num=num;
	}
	public String getName(){
		return name;
	}
	public void setPrice(int price){
        this.price=price;
	}
	public int getPrice(){
		return price;
	}

	public boolean equals(Object o){
		Production p=(Production)o;
		if (this.name.equals(p.name)&&this.price==p.price) {
			return true;
		}
		return false;
	}
	
	public String toString(){
		return "商品名称:"+name+" 商品价格:"+price+"元";
	}

}