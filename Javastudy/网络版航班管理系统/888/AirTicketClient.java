import java.io.*;
import java.net.*;
import java.util.Scanner;
public class AirTicketClient{
	public static void main(String[] args)throws Exception{
		Socket socket=new Socket("192.168.1.101",3000);
		PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String inputkey=null;
		String inputvalue=null;

		Scanner input=new Scanner(System.in);
		boolean flag=true;
		while(flag){
			System.out.println("**航班管理系统**");
			System.out.println("请输入1 查询班次");
			System.out.println("请输入2 查询票价");
			System.out.println("请输入3 查询时间");
			System.out.println("请输入0 退出系统");
			switch(input.nextInt()){
				case(1):
				inputkey="flight";
				System.out.println("请输入您要查询的航班");
				inputvalue=input.next();
				send(pw,inputkey,inputvalue);
				receive(br);
				break;
				case(2):
				inputkey="price";
				System.out.println("请输入您要查询的票价");
				inputvalue=input.nextInt()+"";
				send(pw,inputkey,inputvalue);
				receive(br);
				break;
				case(3):
				inputkey="time";
				System.out.println("请输入您要查询的时间");
				inputvalue=input.next();
				send(pw,inputkey,inputvalue);
				receive(br);
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
	private static void send(PrintWriter pw,String inputkey,String inputvalue){
		StringBuffer sb=new StringBuffer();

		sb.append("GET /data?"+inputkey+"="+inputvalue+" HTTP/1.1\r\n");
		sb.append("Accept: text/html, application/xhtml+xml, image/jxr, */*\r\n");
		sb.append("Accept-Language: zh-CN\r\n");
		sb.append("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586\r\n");
		sb.append("Accept-Encoding: gzip, deflate\r\n");
		sb.append("Host: localhost:3000\r\n");
		sb.append("Connection: Keep-Alive\r\n");
		sb.append("\r\n");

		pw.print(sb.toString());
		pw.flush();
		System.out.println("-----------");
	}
	private static void receive(BufferedReader br)throws IOException{
		String line=null;
		while((line=br.readLine())!=null){
			if(line.equals("!@#$%^&*()")){
				break;
			}
			System.out.println(line);
		}
	}
}
/*class MyWebBorser{
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
		pw.println("GET /data?"+key+"="+value+" HTTP/1.1");
		pw.println("Accept: text/html, application/xhtml+xml, image/jxr, *");
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
*/