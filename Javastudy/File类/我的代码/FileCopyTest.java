import java.io.*;
public class FileCopyTest{
	public static void main(String[] args) {
		copyDir(new File("E:\\abc"),new File("E:\\edf"));
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
	public static void copyDir(File dir1,File dir2){
		if (dir1.isDirectory()) {
			File[] list1=dir1.listFiles();
			for (int i=0;i<list1.length;i++){
				if (list1[i].isFile()) {
					copyFile(list1[i].getPath(),dir2.getPath()+"\\"+dir2.getName());
				}else{
					copyDir(list1[i],dir2);
				}
			}
		}
		copyFile(dir1.getPath(),dir2.getPath()+"\\"+dir2.getName());
	}
}