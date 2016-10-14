import java.io.*;
public class FileReaderDemo{
	public static void main(String[] args)throws IOException{
		//FileReader比FileInputStream更适合处理文本文件
		FileReader fr=new FileReader("E:\\abc.txt");
		int ch=0;
		while((ch=fr.read())!=-1){
			System.out.println((char)ch);
		}
		FileWriter fw=new FileWriter("E:\\a.txt","E:\\abc.txt");
		fw.write("你safv",true);
		fw.flush();

		BufferedReader br=new BufferedReader(new FileReader("E:\\abc.txt"));
		String str="";
		while((str=br.readLine())!=null){
            System.out.println(str);
		}
	}
}