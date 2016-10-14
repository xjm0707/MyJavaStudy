/*
将用户在控制台输入的数据写入文件中
    (JavaWeb开发中非常常见，使用场景：将服务器的数据刷新到浏览器上)
*/
import java.io.*;
public class PrintStreamDemo{
	public static void main(String[] args) throws IOException{
		/*为了使用readLine()方法，创建出来一个BufferedReader，BufferedReader是字符流，System.in而是字节流，
		所以需要一个转换流InputStreamReader进行转换*/
		BufferedReader bw=new BufferedReader(new InputStreamReader(System.in,"GBK"));
		//加上true，可以自动刷新缓冲区，否者要加上flush()方法
		PrintWriter pw=new PrintWriter(new FileOutputStream("E:/abc.txt"),true);
		String line="";
		while((line=bw.readLine())!=null){
			if (line.equals("over")) {
				break;
			}
			pw.println(line);//将每次读出来的一行数据写到缓冲区中
		}
		pw.close();
	}
}