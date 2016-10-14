import java.io.*;
import java.net.*;
public class MyURLBorserTest{
	public static void main(String[] args)throws Exception{
		MyURLBorser m=new MyURLBorser("https://www.baidu.com/img/bd_logo1.png","D:/123.png");
		m.getJpg();
	}
}
class MyURLBorser{
	private String urlStr;
	private String fileName;
	public MyURLBorser(String urlStr,String fileName){
		this.urlStr=urlStr;
		this.fileName=fileName;
	}
	public void getJpg()throws Exception{
		URL url=new URL(urlStr);
		URLConnection con=url.openConnection();
		InputStream is=con.getInputStream();
		FileOutputStream fos=new FileOutputStream(fileName);
		byte[] b=new byte[1024*10];
		int len=0;
		while((len=is.read(b))!=-1){
			fos.write(b,0,len);
		}
		fos.close();
	} 
}