import java.io.*;
public class FileConvertTest{
	public static void main(String[] args) {
		OutputStreamWriter osw=null;
		InputStreamReader isr1=null;
		InputStreamReader isr2=null;
		try{
			//使用InputStreamReader和OutputStreamWriter转换流，进行编码的转换
			osw=new OutputStreamWriter(new FileOutputStream("/Users/abc123/Desktop/JM/c.txt"));
			//读取a.txt 写入c.txt
			isr1=new InputStreamReader(new FileInputStream("/Users/abc123/Desktop/JM/a.txt"),"UTF-8");
			char[] ch=new char[4];
			int len=0;
			while((len=isr1.read(ch))!=-1){
				osw.write(ch,0,len);
				osw.flush();
			}
			//读取b.txt 写入c.txt
			isr2=new InputStreamReader(new FileInputStream("/Users/abc123/Desktop/JM/b.txt"),"GBK");
			char[] ch1=new char[4];
			int len1=0;
			while((len1=isr2.read(ch1))!=-1){
				osw.write(ch1,0,len1);
				osw.flush();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(osw!=null){
					osw.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			try{
				if(isr1!=null){
					isr1.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			try{
				if(isr2!=null){
					isr2.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}     
	}
}