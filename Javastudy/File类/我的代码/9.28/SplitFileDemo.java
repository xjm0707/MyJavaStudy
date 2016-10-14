import java.io.*;
import java.util.*;
public class SplitFileDemo{
	public static void main(String[] args)throws IOException{
		/*
	    将文件进行分割
	    */
		FileInputStream fis=new FileInputStream("E:/11.jpg");
		FileOutputStream fos=null;
		byte[] b=new byte[1024*4];
		int len=0;
		int count=1;
		while((len=fis.read(b))!=-1){
			fos=new FileOutputStream("E:/11.part"+count++);
			fos.write(b,0,len);
		}
		fos.close();
        
        Vector<FileInputStream> v=new Vector<FileInputStream>();
        v.add(new FileInputStream("E:/11.part1"));
        v.add(new FileInputStream("E:/11.part2"));
        v.add(new FileInputStream("E:/11.part3"));
        v.add(new FileInputStream("E:/11.part4"));
        v.add(new FileInputStream("E:/11.part5"));
        v.add(new FileInputStream("E:/11.part6"));
		conbineFile(v,"E:/12.jpg");
	}
	/*
	合并多个文件
	*/
	public static void conbineFile(Vector<FileInputStream> v,String destPath)throws IOException{
        SequenceInputStream sis=new SequenceInputStream(v.elements());
        FileOutputStream fos=new FileOutputStream(destPath);
        byte[] b=new byte[2];
        int len=0;
        while((len=sis.read(b))!=-1){
        	fos.write(b,0,len);
        }
        fos.close();
        sis.close();
	}
}