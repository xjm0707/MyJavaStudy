import java.io.*;
import java.net.*;
public class TCPFileClient{
	public static void main(String[] args)throws Exception{
		Socket s=new Socket("172.30.31.140",2000);
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("E:/a.txt")));
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		String str="";
		while((str=br.readLine())!=null){
			pw.println(str);
		}
		s.shutdownOutput();
		pw.close();
		br.close();
		s.close();
	}
}