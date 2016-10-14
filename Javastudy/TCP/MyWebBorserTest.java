import java.io.*;
import java.net.*;
public class MyWebBorserTest{
	public static void main(String[] args)throws Exception{
		MyWebBorser m=new MyWebBorser("172.30.31.152",8080);
		m.getTxt();
	}
}
/**
*TCP 请求获取服务器的文本内容
*/
class MyWebBorser{
    private String ip;
    private int port;
    public MyWebBorser(String ip,int port){
    	this.ip=ip;
    	this.port=port;
    }
	public void getTxt()throws Exception{
		Socket s=new Socket(ip,port);

		OutputStream os=s.getOutputStream();
		PrintWriter pw=new PrintWriter(os,true);
		pw.println("GET http://"+ip+":"+port+"/myweb/index.html HTTP/1.1");
		pw.println("Host: "+ip+":"+port);
		pw.println("Accept: text/html, application/xhtml+xml, */*");
		pw.println("Accept-Language: zh-CN");
		pw.println();

		InputStream is=s.getInputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
        if (is.available()==0) {
        	s.close();
        }
    }
}