import java.io.*;
import java.util.HashMap;
import java.util.Properties;
/**
 * Properties的使用，底层是HashTable与FileInputStream、FileOutputStream的结合
 * @author yn
 *
 */
public class PropertiesDemo{
	public static void main(String[] args) throws Exception{
		//如果文件中以#开头的已整行文字都不会别读取
		Properties p=new Properties();
		p.load(new FileInputStream("D:/software.config"));//加载文件

		System.out.println(p.getProperty("size"));//获取键值
		System.out.println(p.getProperty("abc","123"));//获取键值，若没有该键，则使用默认值
		p.setProperty("size","200M");//修改键值
		System.out.println(p);
		//将修改后的Properties保存到文件
		p.store(new FileOutputStream("D:/software.config"),"my software config file");

				
		//下面是Properties的load()原理
		HashMap<String,String> hs=new HashMap<String,String>();
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:/software.config"),"GBK"));
		String line="";
		String[] arr=null;
		while((line=br.readLine())!=null){
			if(line.contains("=")){
				if(line.startsWith("#")){
					continue;
				}
				arr=line.split("=");// ["count","1"]
				hs.put(arr[0],arr[1]);
			}		
		}
		br.close();
		System.out.println(hs);
	}
}