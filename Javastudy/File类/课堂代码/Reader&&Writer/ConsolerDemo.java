import java.io.*;
/**
 * 用户在控制台输入什么，就在控制台输出什么，并且将内容保存到文件
 * @author yn
 *
 */
public class ConsolerDemo{
	public static void main(String[] args)throws IOException {
		BufferedWriter bw=new BufferedWriter(new FileWriter("D:/abc.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line="";
		while((line=br.readLine())!=null){
			System.out.println(line);
			if(line.equals("over")){
				break;
			}
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		bw.close();					
	}
}