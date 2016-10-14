import java.io.*;
import java.net.*;
public class TCPFileServer{
	public static void main(String[] args)throws Exception{
		ServerSocket ss=new ServerSocket(2000);
		Socket s=ss.accept();
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw=new PrintWriter(new FileOutputStream("E:/b.txt"));
		String str="";
		while((str=br.readLine())!=null){
			pw.println(str);
		}
		pw.close();
		br.close();
		s.close();
	}
}