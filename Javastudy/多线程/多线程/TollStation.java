/*
多线程 继承Thread类
*/
public class TollStation{
	public static void main(String[] args) {
	    SuLiaoPingThread a=new SuLiaoPingThread();
	    PingGaiThread b=new PingGaiThread();
	    BaoZhuangThread c=new BaoZhuangThread();
	    a.start();
		b.start();
		c.start();
		
		//创建匿名对象
		new Thread(){
			public void run(){
				for (int i=0;i<15;i++) {
			        System.out.println("领导视察");
				}
			}
		}.start();
	}

}
class SuLiaoPingThread extends Thread{
	public void run(){
		System.out.println("塑料瓶生产线");
		for (int i=0;i<10;i++) {
			System.out.println((i+1)+"个塑料瓶生产完成");
		}
	}
}
class PingGaiThread extends Thread{
	public void run(){
		System.out.println("瓶盖生产线");
		for (int i=0;i<20;i++) {
			System.out.println((i+1)+"个瓶盖生产完成");
		}
	}
}
class BaoZhuangThread extends Thread{
	public void run(){
		System.out.println("产品包装流水线");
		for (int i=0;i<10;i++) {
			System.out.println((i+1)+"件产品包装完成");
		}
	}
}