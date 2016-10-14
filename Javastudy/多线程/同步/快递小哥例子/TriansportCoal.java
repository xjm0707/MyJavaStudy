public class TriansportCoal{
	public static void main(String[] args)throws Exception{
		Coal c=new Coal();
		Truck1 a=new Truck1(c);
        Truck2 b=new Truck2(c);
		Thread t1=new Thread(a,"卡车1");
		Thread t2=new Thread(b,"卡车2");
		// t1.setPriority(Thread.MAX_PRIORITY);
		// t1.setPriority(Thread.MIN_PRIORITY);//设置优先级
		t1.start();
		// t1.join();//等待该线程终止，就是t1没有执行完，主线程就一直等着 
		t2.start();
	}
}

class Coal{
	private int amount=0;
	public int getAmount(){
        return amount;
	}
	// public void add(int num){
	// 	amount=amount+num;
	// }
}

class Truck1 implements Runnable{
	private Coal c;
	public Truck1(Coal c){
		this.c=c;
	}
	public void run(){
		while (true) {
			synchronized (c){
				// try{
				// 	Thread.sleep(1000);

				// }catch (Exception e) {
					
				// }
				if (c.getAmount()<5000) {
					// c.add(80);
					c.getAmount()=c.getAmount()+50;
					System.out.println(Thread.currentThread().toString()+"运煤后。。总量为"+c.getAmount()+"吨");
				}
				else{
					break;
				}				
			}		
		}
	}
}
class Truck2 implements Runnable{
	private Coal c;
	public Truck2(Coal c){
		this.c=c;
	}
	public void run(){
		while (true) {
			synchronized (c){
				if (c.getAmount()<5000) {
					c.getAmount()=c.getAmount()+80;
					System.out.println(Thread.currentThread().toString()+"运煤后。。总量为"+c.getAmount()+"吨");
				}
				else{
					break;
				}	
			}		
		}
	}
} 