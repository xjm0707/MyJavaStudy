import java.io.*;
/**
 * FileReader和FileWriter的用法
 * @author yn
 *
 */
public class FileReaderDemo{
	public static void main(String[] args)throws IOException{
		FileReader fr=new FileReader("E:/abc.txt");			
		//读一个打印一次
		/*int ch=0;
		while((ch=fr.read())!=-1){
			System.out.println((char)ch);
		}*/
			
		//读一串打印一次，两种写法，推荐第二种
		/*while(true){
		int ch=fr.read();//读出来的字符
		if(ch==-1){
			break;
		}
		System.out.println((char)ch);
		}*/
		char[] c=new char[2];//一个char类型2字节
		int len=0;
		while((len=fr.read(c))!=-1){
			System.out.println(new String(c,0,len));
		}
		fr.close();
		
		
		FileWriter fw=new FileWriter("E:/abc.txt",true);//true代表了文件内容的追加
		fw.write("你好");
		fw.append('b');//向缓冲区添加内存
		//fw.flush();//只有刷新了缓冲区，数据才会写到文件中
		fw.close();//close()内部会调用flush()方法
	}	
}
