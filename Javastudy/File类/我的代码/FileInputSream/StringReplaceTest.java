/**
*替换字符串中的字符
*/
import java.io.*;
public class StringReplaceTest{
	public static void main(String[] args) {
		try{
			FileInputStream fis=new FileInputStream("E:\\file.txt");
			byte[] b=new byte[fis.available()];//一次性读取所有内容
			int len=0;
			while((len=fis.read(b))!=-1){
				String str=new String(b,0,len); 
				if (str.contains("视频")) {//判断是否包含需要替换的字符
					System.out.println(str.replace("视频","@*"));//replace()方法进行替换
				}else{
					System.out.println(str);
				}
			}
		}catch (Exception e) {			
		}		 
	}
}