import java.io.*;
public class InputStreamReaderDemo{
	public static void main(String[] args)throws IOException {
/*		//InputStreamReader和OutputStreamWriter属于转换流，用于编码的转换
		FileInputStream fis=new FileInputStream("E:/abc.txt");
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		int len=0;
		while((len=isr.read())!=-1){
			System.out.println((char)len);
		}
		
		FileOutputStream fos=new FileOutputStream("E:/B.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
		osw.write("我的sdflasfj",0,5);
		osw.flush();*/
        
        copy("/Users/abc123/Desktop/JM/a.txt","/Users/abc123/Desktop/JM/c.txt","UTF-8");
	}
	public static void copy(String srcPath,String destPath,String charset)throws IOException{
		FileInputStream fis=new FileInputStream(srcPath);
		InputStreamReader isr=new InputStreamReader(fis,charset);
		FileOutputStream fos=new FileOutputStream(destPath);
		OutputStreamWriter osw=new OutputStreamWriter(fos,charset);

		char[] ch=new char[4];
		int len=0;
		while((len=isr.read(ch))!=-1){
			osw.write(ch,0,len);			
		}
		osw.close();
	}
}