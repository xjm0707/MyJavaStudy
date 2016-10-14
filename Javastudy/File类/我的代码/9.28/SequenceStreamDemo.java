import java.io.*;
public class SequenceStreamDemo{
	public static void main(String[] args)throws IOException{
		
		BufferedInputStream bis1=new BufferedInputStream(new FileInputStream("E:/a.txt"));
		BufferedInputStream bis2=new BufferedInputStream(new FileInputStream("E:/b.txt"));

		//将多个流文件按顺序整合到一起
		SequenceInputStream sis=new SequenceInputStream(bis1,bis2);
	    FileOutputStream fos=new FileOutputStream("E:/c.txt");

	    byte[] b=new byte[2];
	    int len=0;
	    while((len=sis.read(b))!=-1){
	    	fos.write(b,0,len);
	    }
	    sis.close();
	    fos.close();
	}
	/*
	合并多个文件
	*/
	public static void conbineFile(Vetor v,String destPath){
        SequenceInputStream sis=new SequenceInputStream(e.element());
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