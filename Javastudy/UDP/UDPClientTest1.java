import java.io.*;
import java.net.*;
public class UDPClientTest1{
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds=new DatagramSocket(2000);
		while(true){
			byte[] b1=new byte[1024];
			DatagramPacket dp1=new DatagramPacket(b1,b1.length);
			ds.receive(dp1);
			System.out.println("ip"+id.getHostAddress());
			System.out.println(new String(dp1.getData(),0,dp1.getLength()));		

			String str=br.readLine();
			byte[] b=str.getBytes();
			DatagramPacket dp=new DatagramPacket(b,b.length,InetAddress.getLocalHost(),2001);
			ds.send(dp);			
		}
	}
}