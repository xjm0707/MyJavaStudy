import java.util.Random;
public class ThunderDemo{
	public static void main(String[] args){
		BooleanDemo b=new BooleanDemo();
		Thunder t=new Thunder(b);

        t.download();
	}
}
/**
*类名 BooleanDemo
*定义一个布尔变量，控制下面线程的开合
*/
class BooleanDemo{
	boolean flag=false;
}
/**
*类名 Thunder 迅雷类
*方法 download() 下载方法
*内部类 Download 多线程下载类 
*/
class Thunder{
	//将布尔类中的布尔变量以构造方法的方式传入
	private BooleanDemo b;
	public Thunder(BooleanDemo b){
		this.b=b;
	}
	public void download(){
        //new一个Download对象 
		Thunder.Download d=this.new Download(); 
		//new三个下载视频的线程 将Download对象传入
		Thread t1=new Thread(d,"视频1");
		Thread t2=new Thread(d,"视频2");
		Thread t3=new Thread(d,"视频3");
		//创建多线程匿名对象
		Thread t=new Thread(new Runnable(){
			public void run(){				
				while(true) {
					//每1秒抛出一个1～1000的随机数
					Random ran=new Random();
					int r=ran.nextInt(1000);
					try{
						Thread.sleep(5);
					}
					catch(Exception e){
					}   			        							
					try{
						//当随机数为1时，捕捉蓝屏异常
						if (r==1) {
							throw new BlueScreen("电脑蓝屏，请重新启动！");			
						}								
					}
					catch (BlueScreen e) {
						System.out.println(e.getMessage());
						synchronized (b){
						/**
						*当捕捉到蓝屏异常的时候，将布尔值设为true，
						*则所有的线程（调用Download类中run方法的线程）都处于wait状态
						*直到当前线程休眠2秒后，将布尔值重新设回false，唤醒所有线程
						*/
							b.flag=true; 
							System.out.println("正在重启电脑...");
							System.out.println(); 
							try{
								Thread.sleep(2000);
							}
							catch(Exception p){
							}							
							System.out.println("已开机，继续下载");
							b.flag=false;
						}
					}
					//当所有线程（调用Download类中run方法的线程）都停止后，关闭当前线程
					if (!t1.isAlive()&&!t2.isAlive()&&!t3.isAlive()) {
						System.out.println();
						System.out.println("当前没有正在下载的视频！");
						break;
					}  
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();

		t.start();
	}
	/**
	*内部类 Download(实现Runnable接口的实现类)
	*/
	class Download implements Runnable{
		public void run(){
			int i=0;
			for (;i<100;i++) {
			    //每0.2秒抛出一个1～100的随机数				
				Random ran=new Random();
				int r=ran.nextInt(100);				
				try{
					Thread.sleep(200);
				}
				catch(Exception e){
				}
				//当随机数为1时，捕获断网异常
				try{
					if (r==1) {
						throw new NetBroke(Thread.currentThread().getName()+"意外断开了链接！");
					}					
				}
				catch (NetBroke e) {
					System.out.println(e.getMessage());
					System.out.println(Thread.currentThread().getName()+"停止下载！保存当前进度");
					break;           			
				}
				synchronized (b){
					System.out.println(Thread.currentThread().getName()+":下载中..."+i+"%");
					//当布尔值被设为true时，所有线程进入wait状态
					while(true){
						if (!b.flag) {
							try{
								wait();
							}
							catch (Exception e) {   
								break;             			
							}
						}
					}					
				}
			}
			//只有当视频下载到100％的时候才能提示下载完毕，其余的都是打印已下载到的进度
			if (i==100) {
				System.out.println(Thread.currentThread().getName()+"下载完毕！");
			}
			else{
				System.out.println(Thread.currentThread().getName()+"已下载"+i+"%");
			}			
		} 
	}
}
// 断网异常（一旦断网，停止下载，保存到当前进度）
class NetBroke extends Exception{
	public NetBroke(String message){
		super(message);
	}
}
// 蓝屏异常（一旦蓝屏，重启电脑后继续断网前进度下载）
class BlueScreen extends Exception{
	public BlueScreen(String message){
		super(message);
	}
}