import java.util.Random;
public class PrintDemo{
	public static void main(String[] args) {
        StringBuffer s=new StringBuffer("aaaa");
        Print p1=new Print(s);
        Print p2=new Print(s);
        Thread t1=new Thread(p1,"打印1:");
        Thread t2=new Thread(p2,"打印2:");
        t1.start();
        t2.start();
	}
}/**
*类名 Print
*功能 实现在字符串中随机位置插入随机字母
*/
class Print implements Runnable{
	private StringBuffer s;//字符串以构造方法的方式传入
	public Print(StringBuffer s){
		this.s=s;
	}
	
	public void run(){					
		while(true) {			
		    
		    Random r=new Random();
	        String letter="abcdefghijklmnopqrstuvwxyz";
	        char c=letter.charAt(r.nextInt(26));// 随机一个字母
	        int r1=r.nextInt(50);// 随机一个0～50的数字	
		    
		    synchronized (s){
		        if (s.length()>=50) {
		        	break;
		        }
		        else{
		            try{
			            this.s=s.insert(r1,c);
		                System.out.println(Thread.currentThread().getName()+s);
		            }
		            catch (ArrayIndexOutOfBoundsException e) {
			            System.out.println(Thread.currentThread().getName()+"下标越界");
		            }			
		        }
		    }
		}
	}
}