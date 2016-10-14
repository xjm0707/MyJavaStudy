import java.io.*;
import java.util.Vector;
/**
 * 文件的分割与合并
 * @author yn
 *
 */
public class SplitAndConbineFileTest {
	public static void main(String[] args) throws IOException{
		File file=new File("D:/11.jpg");
		int count=splitFile(file);
		Vector<FileInputStream> v=new Vector<FileInputStream>();
		int index=0;
		while(index<count){
			v.add(new FileInputStream(file.getAbsolutePath().replace("jpg", "part")+(++index)));
		}
		conbineFile(v, "D:/12.jpg");
	}
	/**
	 * 分割图片文件
	 * @param f 图片文件
	 * @return 分割的分数
	 * @throws IOException 抛出IO异常
	 */
	public static int splitFile(File f)throws IOException{
		//这个函数还可以继续改进，例如，让用户自定义分割的份数，或者每一份文件的大小
		FileInputStream fis=new FileInputStream(f);
		FileOutputStream fos=null;
		int len=0;
		byte[] b=new byte[1024*10];//10kb
		int count=0;
		while((len=fis.read(b))!=-1){
			count++;
			//每次创建一个新的FileOutputStream，其实相当于创建一个新的文件，从而实现文件的分割
			fos=new FileOutputStream(f.getAbsolutePath().replace("jpg", "part")+count);
			fos.write(b,0,len);
			fos.flush();
		}
		//这里记得关闭流资源，不然在合并的文件后，可能出项临时文件无法删除的情况
		fos.close();
		fis.close();
		return count;
	}
	/**
	 * 合并多个文件，使用默认的字符集编码，一般用于媒体文件的合并，相同编码格式的文本进行合并没有问题，不同则会出现乱码
	 * 不同编码格式的文本文件的合并，请使用CopyFileUtil.java中的copy4()方法
	 * @param v Vector集合，用于添加多个文件
	 * @param destPath 合并后的文件地址
	 * @throws IOException 抛出IO异常
	 */ 
	public static void conbineFile(Vector<FileInputStream> v,String destPath)throws IOException{
		SequenceInputStream sis=new SequenceInputStream(v.elements());
		FileOutputStream fos=new FileOutputStream(destPath);
		byte[] b=new byte[3];
		int len=0;
		while((len=sis.read(b))!=-1){
			fos.write(b,0,len);
		}
		//这里记得关闭流资源，不然在合并的文件后，可能出项临时文件无法删除的情况
		fos.close();
		sis.close();
	}
}