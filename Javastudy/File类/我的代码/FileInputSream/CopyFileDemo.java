import java.io.*;
public class CopyFileDemo{
	public static void main(String[] args) {
		copyFile("E:\\abc.txt","D:\\abc.txt");
	}
	public static void copyFile(String srcPath,String destPath){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try{
			fis=new FileInputStream(srcPath);
			fos=new FileOutputStream(destPath);

			byte[] b=new byte[4];//一次读取4字节
			int len=0;
			while((len=fis.read(b))!=-1){
				fos.write(b);
			}
		}catch (Exception e) {
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
            try{
            	if (fos!=null) {
            		fos.close();
            	}
            }catch (Exception e) {
            	e.printStackTrace();
            }
		}
	}
}