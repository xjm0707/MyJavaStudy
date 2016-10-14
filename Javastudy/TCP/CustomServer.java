import java.io.*;
import java.net.*;
public class CustomServer{
	public static void main(String[] args)throws Exception{
		ServerSocket ss=new ServerSocket(2000);
		Socket s=ss.accept();
		InputStream in=s.getInputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=in.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		s.close();
	}
}