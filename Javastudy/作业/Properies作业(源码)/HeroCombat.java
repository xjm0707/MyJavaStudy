import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.Random;
import java.util.Properties;
import java.io.*;
public class HeroCombat{
	public static void main(String[] args) throws IOException{
		File f=new File("e:/heroCombat.config");
		Properties p=new Properties();
		if(!f.exists()){
			f.createNewFile();
		}
		p.load(new FileInputStream(f));

		Mage mage=new Mage("法师",100);
		Hunter hunter=new Hunter("猎人",100);
		Rider rider=new Rider("骑士",200);
		Thread t1=new Thread(new MageThread(mage,rider,p),"法师");
		t1.start();
		Thread t2=new Thread(new HunterThread(hunter,rider,p),"猎人");
		t2.start();
		Thread t3=new Thread(new RiderThread(rider,hunter,mage,p),"骑士");
		t3.start();

	}
}
abstract class Hero{
	private String name;
   	private int blood;
   	public Hero(String name,int blood){
   		this.name=name;
   		this.blood=blood;
   	}
   	public Hero(){}

   	abstract int fight();

   	public String getName(){
   		return name;
   	}

   	public void setBlood(int blood){
   		if(blood<0){
   			this.blood=0;
   		}else{
   			this.blood=blood;
   		}
   	}
   	public int getBlood(){
   		return blood;
   	}
   }
interface Iweapon{
	interface Sword{
		public abstract int sword();
	}
	interface Axe{
		public abstract int axe();
	}
}

class Mage extends Hero implements Iweapon.Sword{
	public Mage(String name,int blood){
		super(name,blood);
	}
	int fight(){
		return sword();
	}
	public int sword(){
		return new Random().nextInt(10);
	}
	
}

class Hunter extends Hero implements Iweapon.Axe{
	public Hunter(String name,int blood){
		super(name,blood);
	}
	int fight(){
		return axe();
	}
	public int axe(){
		return new Random().nextInt(10);
	}
}
class Rider extends Hero implements Iweapon.Sword,Iweapon.Axe{
	ReentrantLock lock=new ReentrantLock();
	Condition c1=lock.newCondition();
	Condition c2=lock.newCondition();
	Condition c3=lock.newCondition();
	public Rider(String name,int blood){
		super(name,blood);
	}
	public int sword(){
		return new Random().nextInt(10)+5;
	}
	public int axe(){
		return new Random().nextInt(20);
	}
	int fight(){
		Random ran=new Random();
		if(ran.nextInt(2)==0){
			return axe();
		}else{
			return sword();
		}
		
	}

}
//法师的线程，攻击骑士，计算血量，并唤醒猎人的线程，自己进入等待
class MageThread implements Runnable{
	private Mage mage;
	private Rider rider;
	private Properties p;
	public MageThread(Mage mage,Rider rider,Properties p){
		this.mage=mage;
		this.rider=rider;
		this.p=p;
	}
	public void run(){
		while(true){
			try{
				rider.lock.lock();
				if(mage.getBlood()<=0){
					System.out.println("法师阵亡");;
				}else if(rider.getBlood()>0){
					rider.setBlood(rider.getBlood()-mage.fight());
					System.out.println(Thread.currentThread().getName()+"攻击,"+rider.getName()+"剩余血量"+rider.getBlood());
					if(rider.getBlood()==0){
						System.out.println("正义获胜");
						int justice=Integer.parseInt(p.getProperty("justice","0"));
						justice++;
						p.setProperty("justice",justice+"");
						try{
							p.store(new OutputStreamWriter(new FileOutputStream("e:/heroCombat.config")),"");
						}catch(Exception e){
							e.printStackTrace();
						}
						System.exit(0);
						break;
					}
				}
				rider.c2.signal();
				try{
					rider.c1.await();
				}catch(Exception e){}
			}finally{
				rider.lock.unlock();
			}
		}
	}
}
//猎人的线程，攻击骑士，计算血量，并唤醒骑士的线程，自己进入等待
class HunterThread implements Runnable{
	private Hunter hunter;
	private Rider rider;
	private Properties p;
	public HunterThread(Hunter hunter,Rider rider,Properties p){
		this.hunter=hunter;
		this.rider=rider;
		this.p=p;
	}
	public void run(){
		while(true){
			try{
				rider.lock.lock();
				if(hunter.getBlood()<=0){
					System.out.println("猎人阵亡");;
				}else if(rider.getBlood()>0){
					rider.setBlood(rider.getBlood()-hunter.fight());
					System.out.println(Thread.currentThread().getName()+"攻击,"+rider.getName()+"剩余血量"+rider.getBlood());
					if(rider.getBlood()==0){
						System.out.println("正义获胜");
						int justice=Integer.parseInt(p.getProperty("justice","0"));
						justice++;
						p.setProperty("justice",justice+"");
						try{
							p.store(new OutputStreamWriter(new FileOutputStream("e:/heroCombat.config")),"heroCombat");
						}catch(Exception e){
							e.printStackTrace();
						}
						System.exit(0);
						break;
					}
				}
				rider.c3.signal();
				try{
					rider.c2.await();
				}catch(Exception e){}
			}finally{
				rider.lock.unlock();
			}
		}
	}
}
//骑士的线程，攻击法师或猎人，计算血量，并唤醒法师的线程，自己进入等待
class RiderThread implements Runnable{
	private Hunter hunter;
	private Rider rider;
	private Mage mage;
	private Properties p;
	public RiderThread(Rider rider,Hunter hunter,Mage mage,Properties p){
		this.hunter=hunter;
		this.rider=rider;
		this.mage=mage;
		this.p=p;
	}
	public void run(){
		while(true){
			try{
				rider.lock.lock();
				if(rider.getBlood()<=0){
					System.out.println("骑士阵亡");
				}else if(hunter.getBlood()==0){
					mage.setBlood(mage.getBlood()-rider.fight());
					System.out.println(Thread.currentThread().getName()+"攻击,"+mage.getName()+"剩余血量"+mage.getBlood()+hunter.getName()+"剩余血量"+hunter.getBlood());
					if(mage.getBlood()==0&&hunter.getBlood()==0){
						System.out.println("邪恶获胜");
						int evil=Integer.parseInt(p.getProperty("evil","0"));
						evil++;
						p.setProperty("evil",evil+"");
						try{
							p.store(new OutputStreamWriter(new FileOutputStream("e:/heroCombat.config")),"heroCombat");
						}catch(Exception e){
							e.printStackTrace();
						}
						System.exit(0);
					}
				}else if(mage.getBlood()==0){
					hunter.setBlood(hunter.getBlood()-rider.fight());
					System.out.println(Thread.currentThread().getName()+"攻击,"+hunter.getName()+"剩余血量"+hunter.getBlood()+mage.getName()+"剩余血量"+mage.getBlood());
					if(mage.getBlood()==0&&hunter.getBlood()==0){
						System.out.println("邪恶获胜");
						int evil=Integer.parseInt(p.getProperty("evil","0"));
						evil++;
						p.setProperty("evil",evil+"");
						try{
							p.store(new OutputStreamWriter(new FileOutputStream("e:/heroCombat.config")),"heroCombat");
						}catch(Exception e){
							e.printStackTrace();
						}
						System.exit(0);
					}
				}else{
					Random ran=new Random();
					if(ran.nextInt(2)==0){
						mage.setBlood(mage.getBlood()-rider.fight());
						System.out.println(Thread.currentThread().getName()+"攻击,"+mage.getName()+"剩余血量"+mage.getBlood()+hunter.getName()+"剩余血量"+hunter.getBlood());
					}else{
						hunter.setBlood(hunter.getBlood()-rider.fight());
						System.out.println(Thread.currentThread().getName()+"攻击,"+hunter.getName()+"剩余血量"+hunter.getBlood()+mage.getName()+"剩余血量"+mage.getBlood());
					}
				}
				rider.c1.signal();
				try{
					rider.c3.await();
				}catch(Exception e){}
			}finally{
				rider.lock.unlock();
			}
		}
	}
}
