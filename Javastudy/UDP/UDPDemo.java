import java.net.*;
import java.io.IOException;
public class UDPDemo{
	public static void main(String[] args)throws IOException{
		String str="你好";
		byte[] b=str.getBytes();
		//相当于寄快递，需要物品(数据)、收货地址(IP和端口号)
		DatagramPacket dp=new DatagramPacket(b,b.length,InetAddress.getLocalHost(),2000);//指定的接收端口
		//通过UDP发送数据
		DatagramSocket ds=new DatagramSocket(2001);//发送端口
		ds.send(dp);

		byte[] b1=new byte[1024];
        DatagramPacket dp1=new DatagramPacket(b1,b1.length);
        ds.receive(dp1);
		System.out.println(new String(dp1.getData(),0,dp1.getLength()));
		ds.close();
	}
}