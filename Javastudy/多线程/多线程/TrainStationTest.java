public class TrainStationTest{
	public static void main(String[] args) {
		// Thread t1=new WindowsOne("窗口1");
		// Thread t2=new WindowsTwo("窗口2");
		// t1.start();
		// t2.start();
		WindowsThree w=new WindowsThree();
		Thread t1=new Thread(w,"窗口1");
		Thread t2=new Thread(w,"窗口2");
		Thread t3=new Thread(w,"窗口3");
		Thread t4=new Thread(w,"窗口4");
		Thread t5=new Thread(w,"窗口5");
		Thread t6=new Thread(w,"窗口6");
		Thread t7=new Thread(w,"窗口7");
		Thread t8=new Thread(w,"窗口8");
		t5.start();
		t3.start();
		t6.start();
		t7.start();
		t2.start();
		t1.start();
		t4.start();
		
		t8.start();
	}
}
class WindowsThree implements Runnable{
	int num=100;
	Object o=new Object();
	public void run(){
		while(num>0){
			synchronized(o){
				if(num>0){
					try{
						Thread.sleep(100);
						System.out.println(Thread.currentThread().getName()+"卖票:"+num);
						num--;
					}catch (Exception e) {
						e.printStackTrace();
					}
				}			
			}
		}
	}
}
// class WindowsOne extends Thread{
// 	int num=50;
// 	public WindowsOne(String name){
// 		super(name);
// 	}
// 	public void run(){
// 		for (int i=num;i>0;i--) {
// 			try{
// 			    Thread.sleep(1000);
// 			    System.out.println(Thread.currentThread().getName()+"卖票:"+num);
// 			    num--;
// 			}catch (Exception e) {
// 				e.printStackTrace();
// 			}
// 		}
// 	}
// }
// class WindowsTwo extends Thread{
// 	int num=50;
// 	public WindowsTwo(String name){
// 		super(name);
// 	}
// 	public void run(){
// 		for (int i=num;i>0;i--) {
// 			try{
// 			    Thread.sleep(2000);
// 			    System.out.println(Thread.currentThread().getName()+"卖票:"+num);
// 			    num--;
// 			}catch (Exception e) {
// 				e.printStackTrace();
// 			}
// 		}
// 	}
// }