import java.io.*;
import java.net.*;
import java.util.Random;
public class TCPThreadFileServer{
	public static void main(String[] args)throws Exception {
		ServerSocket ss=new ServerSocket(2000);
		while(true){
			Socket s=ss.accept();
			new Thread(new ReceiveRunnable(s)).start();		
		}
	}
}
class ReceiveRunnable implements Runnable{
	private Socket s;

	public ReceiveRunnable(Socket s){
		this.s=s;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+"正在传入文件...");
		BufferedReader br=null;
		PrintWriter pw=null;
		Random r=new Random();
		int i=r.nextInt(100);
		try{
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw=new PrintWriter(new FileOutputStream("D:/"+i+".txt"));
			String str="";
			while((str=br.readLine())!=null){
				pw.println(str);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if (br!=null) {
					br.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (pw!=null) {
					pw.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				s.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}