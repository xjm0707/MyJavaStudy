import java.io.*;
import java.net.*;
public class TCPServer{
	public static void main(String[] args)throws Exception{
		while(true){
			ServerSocket ss=new ServerSocket(2000);
			Socket s=ss.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str="";
			while((str=br.readLine())!=null){
				if (str.equals("over")) {
					break;
				}
				System.out.println("IP:"+s.getInetAddress().getHostAddress());
				System.out.println(str);
			}

			Socket s1=new Socket("172.30.31.140",2001);
			BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
			String str1="";
			while((str1=br1.readLine())!=null){
				bw.write(str1);
			    bw.newLine();//加上回车符 服务端才能readLine
			    bw.flush();	
			    if (str1.equals("over")) {
			    	break;
			    }
			}
			s.close();
			ss.close();
		}
	}
}