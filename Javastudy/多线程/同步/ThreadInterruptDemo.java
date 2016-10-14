//强行让线程从冻结状态回到运行状态 interrupt()的使用
public class ThreadInterruptDemo{
	public static void main(String[] args) {
		Patient p=new Patient();
		Thread t=new Thread(p);
		t.start();
		try{
			Thread.sleep(10);
		}catch (Exception e) {			
		}
		try{
			System.out.println("一砖头被砸醒");
			t.interrupt();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//强行让线程从冻结状态回到运行状态，会抛出中断异常
		System.out.println("over");
	}
}
class Patient implements Runnable{
	public void run(){
		synchronized (this){
			try{
				System.out.println("被催眠");
				this.wait();
			}catch (Exception e) {
				System.out.println("砸醒后会受伤，所以抛出异常，这里捕获异常");
				e.printStackTrace();
			}
		}		
	}
}