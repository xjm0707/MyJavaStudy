import java.io.*;
/**
 * 管道流的使用，并不能简单的实现生产消费者模式
 * @author yn
 *
 */
public class PipedStreamDemo{
	public static void main(String[] args) throws IOException{
		PipedReader pr=new PipedReader();
		PipedWriter pw=new PipedWriter();
		ReaderRunnable rr=new ReaderRunnable(pr);
		WriterRunnable wr=new WriterRunnable(pw);
		pr.connect(pw);//将输入流与输出流连接起来
		new Thread(rr).start();
		new Thread(wr).start();
	}
}
class ReaderRunnable implements Runnable{
	PipedReader pr;
	public ReaderRunnable(PipedReader pr){
		this.pr=pr;
	}
	public void run(){
		try{
			int count=0;
			while(count<10){
				count++;
				int len=0;
				System.out.println("等待数据的输入。。。");						
				len=pr.read();//read是阻塞的，如果没有数据就一直在等待数据
				System.out.println("输出的数据："+len);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}						

	}
}
class WriterRunnable implements Runnable{
	PipedWriter pw;
	public WriterRunnable(PipedWriter pw){
		this.pw=pw;
	}

	public void run(){
		try{
			int count=0;
			while(count<10){				
				count++;			
				pw.write(count);
				System.out.println("-----输入的数据"+count);
				pw.flush();			
			}
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
}