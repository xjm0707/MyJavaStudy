public class ConsumerDemo{
	public static void main(String[] args) {
		Res r=new Res();
		Producer p=new Producer(r);
		Consumer c=new Consumer(r);
		Thread t1=new Thread(p,"生产商");
		Thread t2=new Thread(c,"消费者");
		t1.start();
		t2.start();
	}
}
//共享资源
class Res{
	String name;
	int count;
	boolean flag=false;
}

class Producer implements Runnable{
	private Res r;
	public Producer(Res r){
		this.r=r;
	}
	public void run(){
		while(r.count<100){
			synchronized (r){
				try{
					Thread.sleep(10);
				}catch (Exception e) {
					
				}
				if (r.flag) {//如果为真，说明有资源，生产者需要等待
					try{
						r.wait();
					}
					catch (Exception e) {			
					}
				}
				else{
					r.count=r.count+1;
					System.out.println(Thread.currentThread().getName()+"生产商品..."+r.count+"件");
					r.flag=true;//生产完之后将标记改为真，让自己进入等待状态
					r.notify();//唤醒消费者
				}
			}
		}
	}
}

class Consumer implements Runnable{
	private Res r;
	public Consumer(Res r){
		this.r=r;
	}
	public void run(){
		while(r.count<=100){
			synchronized (r){
				try{
					Thread.sleep(10);
				}catch (Exception e) {
					
				}
				if (!r.flag) {//如果为假，说明没有资源，消费者需要等待
					try{
						r.wait();
					}
					catch (Exception e) {		
					}
				}
				else{
					System.out.println(Thread.currentThread().getName()+"消费商品...."+r.count+"件");
					r.flag=false;//消费完之后，将标记改回假
					r.notify();//唤醒生产者
				}
			}
		}
	}
}