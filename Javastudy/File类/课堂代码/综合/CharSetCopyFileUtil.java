import java.io.*;
/**
 * 多种方式拷贝文件
 * @author yn
 *
 */
public class CopyFileUtil{
	public static void main(String[] args) throws IOException{
		copy3("D:/gbk.txt","D:/abc.txt","gbk");
	}	

	/*
	注意：
	1、以下代码都没有带缓冲区
	2、都没有捕获异常，直接声明异常
	*/

	/*
	1、源(utf-8)   gbk(打印时要注意字节数组长度的问题) 目(utf-8)
	2、源(utf-8)   utf-8(打印时要注意字节数组长度的问题) 目(utf-8)
	3、源(gbk)     gbk(打印时要注意字节数组长度的问题) 目(gbk)
	4、源(gbk)     utf(打印时要注意字节数组长度的问题) 目(gbk)
	5、缺点：拷贝不用管编码的问题，都可以拷贝，但是打印的时候要考虑字节数组长度的问题，所以也可能出现乱码
	*/
	/**
	 * 使用字节流FileInputStream和FileOutputStream拷贝文件
	 * @param srcPath 原文件地址
	 * @param destPath 输出文件地址
	 * @param charset 指定编码，便于在控制台输出内容，实际开发中可以去掉
	 * @throws IOException 抛出IO异常
	 */
	public static void copy1(String srcPath,String destPath,String charset)throws IOException{
		FileInputStream fis=new FileInputStream(srcPath);
		FileOutputStream fos=new FileOutputStream(destPath);
		
		byte[] b=new byte[2];
		int len=0;
		while((len=fis.read(b))!=-1){
			System.out.println(new String(b,0,len,charset));
			fos.write(b,0,len);
		}
		fos.close();
		fis.close();
	}	
	
	/*
	1、字符流拷贝，不用管编码的问题，都可以拷贝，但是局限于文本文件的拷贝
	2、打印的时候不具备编码的能力，所以也可能出现乱码
	3、不存在字节数组长度的问题，但是输出的时候不具备编码的能力
	*/
	/**
	 * 使用字符流FileReader和FileWriter拷贝文件
	 * @param srcPath 原文件地址
	 * @param destPath 输出文件地址
	 * @throws IOException 抛出IO异常
	 */
	public static void copy2(String srcPath,String destPath) throws IOException{
		FileReader fr=new FileReader(srcPath);
		FileWriter fw=new FileWriter(destPath);
		
		char[] ch=new char[1];
		int len=0;
		while((len=fr.read(ch))!=-1){
			System.out.println(new String(ch,0,len));//utf-8--->gbk  你好-->浣犲ソ
			fw.write(ch,0,len);				
		}
		fr.close();
		fw.close();
	}	
	
	/*
	使用转换流拷贝文件，可以解决在拷贝过程中打印文本出现乱码的问题
	1、源(utf-8)   gbk(打印时要注意字节长度的问题) 目(utf-8)
	2、源(utf-8)   utf-8(打印时要注意字节长度的问题) 目(utf-8)
	3、源(gbk)     gbk(打印时要注意字节长度的问题) 目(gbk)
	4、源(gbk)     utf-8(打印时要注意字节长度的问题) 目(gbk) 使用UTF-8编码有问题,可以用ISO8859-1代替
	*/
	public static void copy3(String srcPath,String destPath,String charset)throws IOException{
		FileInputStream fis=new FileInputStream(srcPath);
		InputStreamReader isr=new InputStreamReader(fis,charset);//将字节流转成字符流

		FileOutputStream fos=new FileOutputStream(destPath);
		OutputStreamWriter osw=new OutputStreamWriter(fos);//将字符流转成字节流

		char[] ch=new char[1];
		int len=0;
		while((len=isr.read(ch))!=-1){
			System.out.println(new String(ch,0,len));//utf-8--->gbk  你好-->浣犲ソ
			osw.write(ch,0,len);
		}
		isr.close();
		osw.close();
	}

	/**
	 * 使用转换流实现不同编码文本文件的合并
	 * @param srcPath1 输入文件1
	 * @param charsetIn1 文件1的编码格式
	 * @param srcPath2 输入文件2
	 * @param charsetIn2 文件2的编码格式
	 * @param destPath 输出文件3
	 * @param charsetOut 文件3的编码格式
	 * @throws IOException 抛出IO异常
	 */
	public static void copy4(String srcPath1,String charsetIn1,String srcPath2,String charsetIn2,String destPath,String charsetOut)throws IOException{
		FileInputStream fis1=new FileInputStream(srcPath1);
		FileInputStream fis2=new FileInputStream(srcPath2);
		InputStreamReader isr1=new InputStreamReader(fis1,charsetIn1);//将字节流转成字符流
		InputStreamReader isr2=new InputStreamReader(fis2,charsetIn2);//将字节流转成字符流

		FileOutputStream fos=new FileOutputStream(destPath);
		OutputStreamWriter osw=new OutputStreamWriter(fos,charsetOut);//将字符流转成字节流

		char[] ch=new char[1];
		int len=0;
		while((len=isr1.read(ch))!=-1){
			System.out.println(new String(ch,0,len));//utf-8--->gbk  你好-->浣犲ソ
			osw.write(ch,0,len);
		}
		while((len=isr2.read(ch))!=-1){
			System.out.println(new String(ch,0,len));//utf-8--->gbk  你好-->浣犲ソ
			osw.write(ch,0,len);
		}
		isr1.close();
		isr2.close();
		osw.close();
	}
}
