import java.io.*;
public class FileInputStreamDemo{
	public static void main(String[] args) {
		FileInputStream fis=new FileInputStream("E:\\abc.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		byte[] b=new byte[6];
		int len=0;
		len=bis.read(b);
		System.out.println(new String(b,0,len,"UTF-8"));

		FileOutPutStream fos=new FileOutPutStream("E:\\abc.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		bos.write("你好".getBytes("UTF-8"));
		bos.close;
	}
}