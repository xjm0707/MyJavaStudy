import java.io.*;
import java.net.*;
public class UDPFileReceive{
	public static void main(String[] args)throws IOException {
		BufferedWriter bos=new BufferedWriter(new FileWriter("/Users/abc123/desktop/abc.txt"));
		DatagramSocket ds=new DatagramSocket(2000);
		while(true){
			byte[] b=new byte[100];
			DatagramPacket dp=new DatagramPacket(b,b.length);
			ds.receive(dp);
			String str=new String(dp.getData(),0,dp.getLength());
			if (str.contains("over")) {
				break;
			}
			byte[] result=dp.getData();
			bos.write(new String(result,0,dp.getLength()));
			bos.flush();
			System.out.println(str);
		}
		ds.close();
	}
}