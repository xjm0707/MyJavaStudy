import java.io.*;
import java.net.*;
public class UDPFileSend{
	public static void main(String[] args)throws IOException {
		BufferedReader bis=new BufferedReader(new FileReader("/Users/abc123/desktop/JM/abc.txt"));
		String str = "";
		DatagramSocket ds=new DatagramSocket(2001);
		while((str = bis.readLine()) != null){
			byte[] b=str.getBytes();
			System.out.println(str);
			DatagramPacket dp=new DatagramPacket(b,b.length,InetAddress.getLocalHost(),2000);
			ds.send(dp);
		}
		String str1="over";
		byte[] b1=str1.getBytes();
		DatagramPacket dp1=new DatagramPacket(b1,b1.length,InetAddress.getLocalHost(),2000);
		ds.send(dp1);
		ds.close();
	}
}