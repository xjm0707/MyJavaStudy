import java.util.*;
import java.io.*;
public class PropertiesTest{
	public static void main(String[] args)throws Exception{
		Properties p=new Properties();
		File f=new File("/users/abc123/Desktop/JM/abc.txt");		
		int count=0;		
		p.load(new FileInputStream(f));			
		p.getProperty("nowTime","0");//nowTime为当前时间
		p.getProperty("firstUseTime","0");//firstUesTime为过去时间
		count=Integer.parseInt(p.getProperty("count","0"));

        if (count==0) {//用户第一次登陆count一定为0，执行以下操作
        	System.out.println("欢迎试用本软件,试用时间为30秒");
        	System.out.println("您已使用本软件时间为0");
        	long currentTime=System.currentTimeMillis();//获取当前时间毫秒值
            count=(int)currentTime;
			p.setProperty("count","1");//重设本地文件count值为1
			p.setProperty("firstUseTime",count+"");//重设本地文件nowTime值为当前时间
			p.store(new FileOutputStream(f),"");
        }
        else{//用户之后登陆count一定不为0，执行以下操作
        	long currentTime=System.currentTimeMillis();//再次获取当前时间
        	count=(int)currentTime;
        	p.setProperty("nowTime",count+"");//重设本地文件nowTime值为当前时间

        	int a=Integer.parseInt(p.getProperty("nowTime"))-Integer.parseInt(p.getProperty("firstUseTime"));//定义一个a为当前时间和过去时间的差值
        	if (a<30000) {//如果差值在30秒(30000毫秒)之内，执行以下操作
        		System.out.println("欢迎使用");
        		System.out.println("您已使用本软件时间为"+(a/1000)+"秒");
        		p.store(new FileOutputStream(f),"");
        	}
        	else{//超过30秒则需购买正版
                 System.out.println("试用结束,请购买正版软件");
            }
        }	
    }
}