import java.io.*;
import java.net.*;
public class TCPClient{
	public static void main(String[] args)throws Exception{
		while(true){
			Socket s=new Socket("172.30.31.140",2000);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			String str="";
			while((str=br.readLine())!=null){
				bw.write(str);
			    bw.newLine();//加上回车符 服务端才能readLine
			    bw.flush();	
			    if (str.equals("over")) {                 
			    	break;
			    }
			}

			ServerSocket ss=new ServerSocket(2001);
			Socket s1=ss.accept();
			BufferedReader br1=new BufferedReader(new InputStreamReader(s1.getInputStream()));
			String str1="";
			while((str1=br1.readLine())!=null){
				if (str1.equals("over")) {
					break;
				}
				System.out.println("IP:"+s.getInetAddress().getHostAddress());
				System.out.println(str1);
			}
			s.close();
			ss.close();
		}
	}
}