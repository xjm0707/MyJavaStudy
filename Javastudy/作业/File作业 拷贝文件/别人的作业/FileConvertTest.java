import java.io.*;
public class FileConvertTest{
	public static void main(String[] args) {
		BufferedReader br=null;
		BufferedWriter bw=null;
		try{
			//用InputStreamReader包装FileInputStream实现读取非默认编码的文档
			//用BufferedReader，BufferedWriter包装FileReaderWriter实现文档的换行
			bw=new BufferedWriter(new FileWriter("file:/Users/abc123/Desktop/JM/c.txt"));
			br=new BufferedReader(new InputStreamReader(new FileInputStream("file:/Users/abc123/Desktop/JM/b.txt"),"gbk"));
			String line=null;
			while((line=br.readLine())!=null){
				bw.write(line);
				bw.newLine();
			}
			br=new BufferedReader(new InputStreamReader(new FileInputStream("file:/Users/abc123/Desktop/JM/a.txt"),"utf-8"));
			while((line=br.readLine())!=null){
				bw.write(line);
				bw.newLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null){
					br.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			try{
				if(bw!=null){
					bw.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}