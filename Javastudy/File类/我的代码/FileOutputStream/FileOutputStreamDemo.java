import java.io.*;
public class FileOutputStreamDemo{
    public static void main(String[] args)throws IOException {
    	FileOutputStream fos=new FileOutputStream(new File("E:/qwe.txt"));
    	//可以直接写入一个字符，也可将字符串转成字节数组
    	fos.write('a');
    	fos.write("98573我".getBytes());
    	fos.close();
    }
}