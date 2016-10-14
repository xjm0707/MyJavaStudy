import java.io.*;
public class BufferedDemo{
	public static void main(String[] args)throws IOException{
		FileInputStream fis=new FileInputStream("E:/abc.txt");
		//缓冲区，提高了读的效率
		BufferedInputStream bis=new BufferedInputStream(fis);//将fis中的数据一次性保存到缓冲区中
		byte[] b=new byte[5];
		int len=0;
		while((len=bis.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}

		FileOutputStream fos=new FileOutputStream("E:/abc.txt");
		//缓冲区，提高了写的效率
		BufferedOutputStream bos=new BufferedOutputStream(fos);

		bos.write("safsdfas".getBytes());
		//bos.flush();
		bos.write("14344515".getBytes());
		//bos.flush();

		bos.close();//内部自己调用flush将缓冲区的数据先写入目标数据中，然后再关闭资源
	}
}