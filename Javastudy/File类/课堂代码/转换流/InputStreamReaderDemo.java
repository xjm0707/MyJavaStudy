import java.io.*;

/**
*InputStreamReader和OutputStreamWriter转换流的使用
*@author yn
*
*/
public class InputStreamReaderDemo{
	public static void main(String[] args) throws IOException{
		//输入转换流InputStreamReader的使用
		FileInputStream fis=new FileInputStream("E:/aa.txt");
		//将输入流传入转换流的构造函数，并指定编码，若不指定使用默认的字符集
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		int len=0;
		len=isr.read();
		System.out.println((char)len);
		isr.close();
		
		FileOutputStream fos=new FileOutputStream("E:/b.txt");
		//将输出流传入转换流的构造函数，并指定编码，若不指定使用默认的字符集
		OutputStreamWriter osw=new OutputStreamWriter(fos,"UTf-8");
		osw.write("qwert",0,5);
		osw.flush();
		osw.close();
	}
	public static void copy(String srcPath,String destPath,String charset)throws IOException{
		FileInputStream fis=new FileInputStream(srcPath);
		InputStreamReader isr=new InputStreamReader(fis,charset);//将字节流转成字符流

		FileOutputStream fos=new FileOutputStream(destPath);
		OutputStreamWriter osw=new OutputStreamWriter(fos,charset);//将字符流转成字节流

		char[] ch=new char[4];
		int len=0;
		while((len=isr.read(ch))!=-1){
			osw.write(ch,0,len);
		}
		osw.close();
		isr.close();
	}
}