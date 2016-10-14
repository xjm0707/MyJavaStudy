import java.io.*;
import java.net.*;
import java.util.Scanner;
public class AirTicketClient{
	public static void main(String[] args)throws Exception{
		System.out.println("**航班管理系统**");
		System.out.println("请输入1 查询班次");
		System.out.println("请输入2 查询票价");
		System.out.println("请输入3 查询时间");
		System.out.println("请输入0 退出系统");
		boolean flag=true;
		while(flag){
			Scanner input=new Scanner(System.in);
			int i=input.nextInt();
			switch(i){
				case(1):
				sortFlight();
				break;
				case(2):
				sortPrice();
				break;
				case(3):
				sortTime();
				break;
				case(0):
				flag=false;
				break;
				default:
				System.out.println("输入有误，请重新输入！");
				break;
			}	
		}
	}
	public static void sortPrice()throws Exception{
		System.out.println("请输入您要查询的票价:");
		Scanner input=new Scanner(System.in);
		String price=input.next();
		MyWebBorser m=new MyWebBorser("rigou",3000,"price",price);
		m.getMessage();
	}
	public static void sortTime()throws Exception{
		System.out.println("请输入您要查询的时间:");
		Scanner input=new Scanner(System.in);
		String time=input.next();
		MyWebBorser m=new MyWebBorser("rigou",3000,"time",time);
		m.getMessage();
	}
	public static void sortFlight()throws Exception{
		System.out.println("请输入您要查询的航班:");
		Scanner input=new Scanner(System.in);
		String flight=input.next();
		MyWebBorser m=new MyWebBorser("rigou",3000,"flight",flight);
		m.getMessage();
	}
}
class MyWebBorser{
    private String ip;
    private int port;
    private String name;
    private String str;
    public MyWebBorser(String ip,int port,String name,String str){
    	this.ip=ip;
    	this.port=port;
    	this.name=name;
    	this.str=str;
    }
	public void getMessage()throws Exception{
		Socket s=new Socket(ip,port);

		OutputStream os=s.getOutputStream();
		PrintWriter pw=new PrintWriter(os,true);
		pw.println("GET /data?"+name+"="+str+" HTTP/1.1");
		pw.println("Accept: text/html, application/xhtml+xml, image/jxr, */*");
		pw.println("Accept-Language: zh-CN");
		pw.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586");
		pw.println("Accept-Encoding: gzip, deflate");
		pw.println("Host: localhost:3000");
		pw.println("Connection: Keep-Alive");
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