import java.io.*;
public class PipedStreamTest{
	public static void main(String[] args)throws IOException{
        FileWriter fw=new FileWriter("E:/abc.txt");
        String str1="a";
        String str2="b";
		WriterRunnable w1=new WriterRunnable(fw,str1);
		WriterRunnable w2=new WriterRunnable(fw,str2);

		new Thread(w1).start(); 
		new Thread(w2).start(); 
	}
}
class WriterRunnable implements Runnable{
	FileWriter fw;
	String str;
	public WriterRunnable(FileWriter fw,String str){
		this.fw=fw;
		this.str=str;
	}
	public void run(){
		try{
			int count=0;
			while(count<10){
				Thread.sleep(10);
				count++;
				fw.write(str);
				System.out.println(str);
				fw.flush();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
