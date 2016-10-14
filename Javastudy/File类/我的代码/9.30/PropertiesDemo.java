import java.util.Properties;
import java.io.*;
public class PropertiesDemo{
	public static void main(String[] args)throws IOException{
		Properties p=new Properties();
		//默认去除#开头的整行文字
		p.load(new FileInputStream("D:/Software.config"));
		System.out.println(p);
        //打印出size（键）对应的值
		System.out.println(p.getProperty("size"));
		//重设size（键）对应的值
		p.setProperty("size","0");
		System.out.println(p);

		p.store(new FileOutputStream("D:/Software.config"),"my software config file");

		File f=new File("D:/Software.config");
		if (!f.exists()) {
			f.createNewFile();
		}
		int count=0;
		Properties p=new Properties();
		p.load(new FileInputStream(f));

		count=Integer.parseInt(p.getProperty("count","0"));
		if (count<=2) {
			System.out.println("欢迎使用，已使用"+(count+1)+"次");
			count++;
			p.setProperty("count",count+"");
			p.store(new FileOutputStream("D:/Software.config"),new String("我的软件配置".getBytes(),"ISO8859-1"));
		}else{
			System.out.println("请购买正版");
		}
	}
}