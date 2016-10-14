import java.io.*;
public class PrintStreamDemo{
	public static void main(String[] args) throws IOException{
		BufferedReader bw=new BufferedReader(new InputStreamReader(new FileInputStream("E:/abc.txt"),"GBK"));
		PrintWriter pw=new PrintWriter(new FileOutputStream("D:/abc.txt"),true);
		String line="";
		while((line=bw.readLine())!=null){
			pw.println(line);
		}
		pw.close();
		bw.close();
	}
}