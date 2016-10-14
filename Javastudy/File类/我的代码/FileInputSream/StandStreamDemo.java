//基本结构
import java.io.*;
public class StandStreamDemo{
	public static void main(String[] args) {
		File file=new File("E:\\zxc.txt");
		FileInputStream fis=null;
		try{
			fis=new FileInputStream(file);
			byte[] b=new byte[4];
			int len=0;
			while((len=fis.read(b))!=-1){
				System.out.println(new String(b,0,len));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try{
				if (fis!=null) {
					fis.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("over");
	}
}