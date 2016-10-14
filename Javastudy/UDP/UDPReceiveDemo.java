import java.net.*;
import java.io.IOException;
public class UDPReceiveDemo{
	public static void main(String[] args)throws IOException{
		//启用一个接收端，监听2000端口
		DatagramSocket ds=new DatagramSocket(2000);
		byte[] b=new byte[1024];
        DatagramPacket dp=new DatagramPacket(b,b.length);
        //通过UDP接收数据
        ds.receive(dp);
		System.out.println(new String(dp.getData()));
	}
}