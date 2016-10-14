public class FastMail{
	public static void main(String[] args) {
		Packages p=new Packages();
		SendMan1 s1=new SendMan1(p);
		SendMan2 s2=new SendMan2(p); 
		Thread t1=new Thread(s1,"快递员1");
		Thread t2=new Thread(s2,"快递员2");
		t1.start();
		t2.start();
	}
}

class Packages{
	int sum=500;
	public void send(int num){
        sum=sum-num;
	}
}

class SendMan1 implements Runnable{
	int count=0;
	Object o=new Object();
	private Packages p;
	public SendMan1(Packages p){
		this.p=p;
	}
	public void run(){
		// synchronized (o){
			while(true){
				if (p.sum>0) {	
					p.send(50);
					System.out.println(Thread.currentThread().getName()+"派送完后，仓库还剩"+p.sum);
					count++;
					System.out.println(Thread.currentThread().getName()+"送了"+count+"天");
				}
				else{
					break;
				}
			}
		// }
	}

}
class SendMan2 implements Runnable{
	int count=0;
	Object o=new Object();
	private Packages p;	
	public SendMan2(Packages p){
		this.p=p;
	}
	public void run(){
		// synchronized (o){
			while(true){
				if (p.sum>0) {	
					p.send(50);
					System.out.println(Thread.currentThread().getName()+"派送完后，仓库还剩"+p.sum);
					count++;
					System.out.println(Thread.currentThread().getName()+"送了"+count+"天");
				}
				else{
					break;
				}
			}
		// }
	}
}