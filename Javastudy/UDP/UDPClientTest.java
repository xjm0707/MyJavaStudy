import java.io.*;
import java.net.*;
public class UDPClientTest{
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds=new DatagramSocket(2001);
		while(true){
			String str=br.readLine();
			byte[] b=str.getBytes();
			DatagramPacket dp=new DatagramPacket(b,b.length,InetAddress.getLocalHost(),2000);
			ds.send(dp);	

			byte[] b1=new byte[1024];
			DatagramPacket dp1=new DatagramPacket(b1,b1.length);
			ds.receive(dp1);
			System.out.println("ip"+id.getHostAddress());
			System.out.println(new String(dp1.getData(),0,dp1.getLength()));		
		}
	}
}