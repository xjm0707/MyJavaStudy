import java.io.*;
public class ByteStreamDemo{
	public static void main(String[] args)throws IOException{
		//ByteArrayInputStream的用法
		ByteArrayInputStream bais=new ByteArrayInputStream("qwe".getBytes());
		int len=0;
		while((len=bais.read())!=-1){
			System.out.println((char)len);
		}
        
        //ByteArrayOutputStream的用法
		ByteArrayOutputStream baos=new ByteArrayOutputStream();//内存中就有了一个字节数组
        //写一个字节
		baos.write('q');
		System.out.println(baos.toString());
        
        //写多个字节
		byte[] b="qwer".getBytes();
		baos.write(b,0,b.length);//将b这个字节数组中的内容写到内存中去(就是ByteArrayOutputStream的缓冲区)
		System.out.println(baos.toString());//获取内存中的数据，返回字符串的形式

		byte[] buf=baos.toByteArray();//获取内存中的数据，返回字节数组的形式
		System.out.println(new String(buf));
		baos.close();
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
			System.out.println(new String(b));
			baos.write(b,0,len);
		}
		System.out.println(baos.toString());
	}
}