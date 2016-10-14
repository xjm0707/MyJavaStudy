public class ComputerTest{
	public static void main(String[] args) {
		Computer c=new Computer("联想电脑",5000);
		c.start();
		SoundCard s=new SoundCard("华硕");
		jieru3(s);//s=new SoundCard();
		function(s);
		NetCard n=new NetCard("因特尔");

		jieru3(n);
		function(n);
		c.shutdown();
	}
	// public static void jieru(SoundCard card){//参数定义数据类型包括：基本数据类型（8种）+引用数据类型（3种）
	// 	card.open();
	// 	card.work();
	// 	card.close();
	// }
	// public static void jieru1(NetCard card){//参数定义数据类型包括：基本数据类型（8种）+引用数据类型（3种）
	// 	card.open();
	// 	card.work();
	// 	card.close();
	// }
	//将上面的代码改为下面的代码
	public static void jieru3(IPCI c){
		//Conponent c=new SoundCard()
		//IPCI c=new SoundCard()
		c.open();
		c.close();
	}


	// public static void function(IPCI c){//c=s card
	// 	SoundCard card=(SoundCard)c;//double c=10.0;int i=(double)c;
	// 	card.work();
	// }
	// public static void function1(IPCI c){//c=s card
	// 	NetCard card=(NetCard)c;//double c=10.0;int i=(double)c;
	// 	card.work();
	// }
	//将上面的代码改为下面的代码
	public static void function(IPCI c){//c=new SoundCard()
		//instanceof 判断类型，其实判读的是内存中对象的类型
		if(c instanceof SoundCard){
			SoundCard s=(SoundCard)c;//将父类强转为子类，或者将接口强转为实现类
			s.tinge();
		}else if(c instanceof NetCard){
			NetCard s=(NetCard)c;
			s.shanWan();
		}
	}
	
}

class Computer{
	String name;
	int price;
	public Computer(String name,int price){
		this.name=name;
		this.price=price;
	}
	public void start(){
		System.out.println(name+"开机");
	}
	public void shutdown(){
		System.out.println(name+"关机");
	}
}
abstract class Conponent implements IPCI{//is-a
	String name;
	abstract void work();
}
//声卡
class SoundCard extends Conponent {
	public SoundCard(String name){
		this.name=name;
	}
	public void open(){
		System.out.println(name+"接入声卡");
	}
	public void work(){
        System.out.println("播放声音");
	}
	public void close(){
		System.out.println(name+"拨出声卡");
	}
	public void tinge(){
		System.out.println("听歌");
	}
}
//网卡
class NetCard extends Conponent{
	public NetCard(String name){
		this.name=name;
	}
	public void open(){
		System.out.println(name+"接入网卡");
	}
	public void work(){
        System.out.println("上网");
	}
	public void close(){
		System.out.println(name+"拨出网卡");
	}
	public void shanWan(){
		System.out.println("上网");
	}
}
interface IPCI{
	public abstract void open();
	public abstract void close();
}
