import java.io.*;
public class StreamDemo{
	public static void main(String[] args)throws IOException{
		FileInputStream fis=new FileInputStream("E:/abc.txt");
		byte[] b=new byte[2];
		int len=0;
		while((len=fis.read(b))!=-1){
			copyStream(b);
			System.out.println("------readStream------");
		}
	}
	/*
    内存数据的拷贝
    */
	public static void copyStream(byte[] resource)throws IOException{
        ByteArrayInputStream bais=new ByteArrayInputStream(resource);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] b=new byte[2];
        int len=0;
        while((len=bais.read(b))!=-1){
			System.out.println("--copyStream--");
			baos.write(b,0,len);
		}
		System.out.println(baos.toString());
	}
}