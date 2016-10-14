public class ComputerTest{
	public static void main(String[] args) {
		Computer a=new Computer("电脑",2000);
		Conponent b=new SoundCard("声卡");
		Conponent c=new NetCard("网卡");
		// a.start();
		// b.open();
		// c.open();
		// b.work();
		// b.close();
		// c.close();
		// a.shutdown();

		jieru(b);
		jieru(c);
	}
	public static void jieru(Conponent c){//多态
		c.work();
	}
}
/**
*类 Computer
*/
class Computer{
	private String name;
	private int price;

	public Computer(){}
	public Computer(String name,int price){
		this.name=name;
		this.price=price;
	}
	void start(){
		System.out.println("开机");

	}
	void shutdown(){
		System.out.println("关机");

	}
}
/**
*组件类 Conponent
*  继承 类 Computer
*
*/
abstract class Conponent extends Computer{
    private String name;
	public Conponent(){}
	public Conponent(String name){
		this.name=name;
	}
		abstract void work();//抽象方法 必须需在子类中实现此方法

}
/**
*声卡类 SoundCard
*  继承 组件类 Conponent
*  接入接口 IPCI
*/
class SoundCard extends Conponent implements IPCI{
	public SoundCard(String name){
		super(name);
	}
	public void open(){
		System.out.println("接入声卡");
	}
	public void work(){
		open();
		System.out.println("工作");
		close();
	}
	public void close(){
		System.out.println("拔出声卡");
	}

}
/**
*网卡类 NetCard
*  继承 组件类 Conponent
*  接入接口 IPCI
*/
class NetCard extends Conponent implements IPCI{
	public NetCard(String name){
		super(name);
	}
	public void open(){
		System.out.println("接入网卡");
	}
	public void work(){
		open();
		System.out.println("工作");
		close();
	}
	public void close(){
		System.out.println("拔出网卡");
	}

}
/**
*接口 IPCI
*/
interface IPCI{
	public abstract void open();//接口中的抽象方法必须在实现类中实现
	public abstract void close();

}
