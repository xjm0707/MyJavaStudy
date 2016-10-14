import java.io.*;
public class FileInputStreamDemo{
	public static void main(String[] args) {
		try{
			//FileInputStream将数据保存在内部的数组中
			FileInputStream fis=new FileInputStream("E:\\abc.txt");
			int content=0;
			while(true){
				content=fis.read();
				if (content==-1) {
					break;
				}
				System.out.println((char)content);
			}

			//通过read方法来读取一个字节
			while((content=fis.read())!=-1){
				System.out.println((char)content);
			}
            
            //通过read(byte[])来一次读取多个字节
			byte[] b=new byte[3];
			int len=0;
			while((len=fis.read(b))!=-1){
				System.out.println(new String(b,0,len));
			
			}
		}catch (Exception e) {
			
		}
	}
}