import java.io.*;
import java.net.*;
public class UDPFileSend{
	public static void main(String[] args)throws IOException {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("/Users/abc123/desktop/JM/abc.txt"));
		byte[] b=new byte[2];
		int len=0;
		DatagramSocket ds=new DatagramSocket(2001);
		while((len=bis.read(b))!=-1){
			System.out.println(new String(b,0,len));
			DatagramPacket dp=new DatagramPacket(b,b.length,InetAddress.getLocalHost(),2000);
			ds.send(dp);
		}
		String str="over";
		byte[] b1=str.getBytes();
		DatagramPacket dp1=new DatagramPacket(b1,b1.length,InetAddress.getLocalHost(),2000);
		ds.send(dp1);
		ds.close();
	}
}