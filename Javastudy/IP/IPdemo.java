import java.net.*;
public class IPdemo{
	public static void main(String[] args)throws UnknownHostException{
		//获取本机信息
		InetAddress id=InetAddress.getLocalHost();
		System.out.println(id);
        //获取ip地址
		String ip=id.getHostAddress();
		//获取主机名
		String name=id.getHostName();
		System.out.println(name+"/"+ip);
        //通过主机名获取主机信息
		InetAddress id2=InetAddress.getByName("www.qq.com");
		System.out.println(id2);
        //获取指定主机名的所有ip地址
		InetAddress[] id3=InetAddress.getAllByName("www.qq.com");
		for (InetAddress i:id3) {
			System.out.println(i.getHostAddress());
		}
	}
}