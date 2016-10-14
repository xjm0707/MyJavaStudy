import java.io.*;
public class PipedStreamDemo{
	public static void main(String[] args)throws IOException{
		PipedInputStream pis=new PipedInputStream();
		PipedOutputStream pos=new PipedOutputStream();
		ReaderRunnable r=new ReaderRunnable(pis);
		WriterRunnable w=new WriterRunnable(pos);

		pis.connect(pos);
		new Thread(r).start(); 
		new Thread(w).start(); 
	}
}
class ReaderRunnable implements Runnable{
	PipedInputStream pis;
	public ReaderRunnable(PipedInputStream pis){
		this.pis=pis;
	}
	public void run(){
		try{
			int count=0;
			while(count<10){
				count++;
				Thread.sleep(10);
				int len=0;
				len=pis.read();
				System.out.println("-----输出的数据："+len);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class WriterRunnable implements Runnable{
	PipedOutputStream pos;
	public WriterRunnable(PipedOutputStream pos){
		this.pos=pos;
	}
	public void run(){
		try{
			int count=0;
			while(count<10){
				count++;
				pos.write(count);
				System.out.println("输入的数据-----："+count);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}