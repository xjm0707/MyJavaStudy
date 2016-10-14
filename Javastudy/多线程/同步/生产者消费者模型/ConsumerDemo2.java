/**
*超强版的生产消费者模型
*
*/
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
public class ConsumerDemo2{
	public static void main(String[] args) {
		Res r=new Res();
		Producer p=new Producer(r);
		Consumer c=new Consumer(r);
		Thread t1=new Thread(p,"生产商");
		Thread t2=new Thread(c,"消费者");
		Thread t3=new Thread(p,"第二生产商");
		Thread t4=new Thread(c,"第二消费者");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
//共享资源
class Res{
	String name;
	int count=0;
	boolean flag=false;
	ReentrantLock lock=new ReentrantLock();
	Condition c=lock.newCondition(); 
}

class Producer implements Runnable{
	private Res r;
	public Producer(Res r){
		this.r=r;
	}
	public void run(){
		while(r.count<99){
			//synchronized (r){
			try{
				r.lock.lock();
				while(r.flag){
					try{
						r.c.await();
					}
					catch (Exception e) {			
					}
				}
				r.count=r.count+1;
				System.out.println(Thread.currentThread().getName()+"生产商品..."+r.count+"件");
				r.flag=true;//生产完之后，将标记改为真，生产者进入等待
				r.c.signalAll();//唤醒消费者
			}finally{
				r.lock.unlock();
			}
			//}
		}
	}
}

class Consumer implements Runnable{
	private Res r;
	public Consumer(Res r){
		this.r=r;
	}
	public void run(){
		while(r.count<99){
			//synchronized (r){
			try{
				r.lock.lock();
				while (!r.flag) {//如果为假，说明没有资源，消费者需要等待
					try{
						r.c.await();
					}
					catch (Exception e) {		
					}
				}
				System.out.println(Thread.currentThread().getName()+"消费商品...."+r.count+"件");
				r.flag=false;//消费完之后，将标记改回假,消费者进入等待
				r.c.signalAll();//唤醒生产者
			}finally{
				r.lock.unlock();
			}
			//}
		}
	}
}