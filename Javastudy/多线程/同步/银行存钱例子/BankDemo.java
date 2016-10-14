public class BankDemo{
	public static void main(String[] args) {
		Customer c=new Customer();
		Thread t1=new Thread(c,"窗口1");
		Thread t2=new Thread(c,"窗口2");
		t1.start();
		try{
			Thread.sleep(500);
		}
		catch (Exception e) {
		}
		c.flag=false;
		t2.start();
	}
}

class Bank{
	int num=0;
	Object o=new Object();
	public synchronized void save1(int money){
		    num=money+num;
		    try{
			Thread.sleep(5);
		}
		catch (Exception e) {
		}
		    System.out.println(Thread.currentThread().getName()+"this...存了"+num);
	}
	public void save2(int money){
		synchronized(o){
		    num=money+num;
		    try{
			Thread.sleep(50);
		}
		catch (Exception e) {
		}
		    System.out.println(Thread.currentThread().getName()+"object...存了"+num);
	    }
	}
}

class Customer implements Runnable{
	boolean flag=true;
	Bank b=new Bank();
	public void run(){
		for (int i=0;i<15;i++) {
			try{
				Thread.sleep(50);
			}
			catch (Exception e) {
			}
			if (flag) {
				b.save1(100);
			}
			else{
				b.save2(100);
			}		
		}
	}
}