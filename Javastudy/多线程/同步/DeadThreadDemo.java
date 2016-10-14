public class DeadThreadDemo{
	public static void main(String[] args) {
		MyRunnable r=new MyRunnable();
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		t1.start();
		t2.start();
	}
}
class MyRunnable implements Runnable{
	boolean flag=true;
	public void run(){
		if (flag) {
			while(true){
				synchronized (Mylock.lock1){
					System.out.println("");
					synchronized(Mylock.lock2){
						System.out.println("");
					}
				}
			}
		}else{
			while(true){
				synchronized(Mylock.lock2){
					System.out.println("");
					synchronized(Mylock.lock1){
						System.out.println("");
					}
				}
			}
		}
	}
}
class Mylock{
	
}