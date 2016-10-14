import java.io.*;
/**
 * 装饰设计模式，可以在不改变原有代码的基础上扩展原有代码的代码的功能。
 * IO流体系中大量使用了装饰设计模式，例如BufferReader可以对传入的FileReader添加缓冲的功能。
 * @author yn
 *
 */
public class DecoratePattern{
	public static void main(String[] args) throws IOException{
		MyLineReader mlr=new MyLineReader(new FileReader("E:/abc.txt"));
		String str=mlr.readLine();
		System.out.println(str);
	}
}
/**
 * 自定义装饰设计模式，模仿BufferedReader对FileReader进行装饰，实现readLine()的功能
 * @author yn
 *
 */
class MyLineReader{
	private FileReader fr;
	public MyLineReader(FileReader fr){
		this.fr=fr;
	}
	public String readLine() throws IOException{
		StringBuffer sb=new StringBuffer();
		int len=0;
		while((len=fr.read())!=-1){
			if(len=='\r'){
				continue;
			}
			else if(len=='\n'){
				return sb.toString();
			}else{
				sb.append((char)len);
			}
		}	
		return null;			
	}
}