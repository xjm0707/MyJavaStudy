import java.util.Properties;
import java.io.*;
import java.util.Scanner;
public class TimeCountSoftwareDemo{
	public static void main(String[] args) throws IOException{
		//读入e:/software1.config日志文件并读取已使用时间和剩余时间
		File f=new File("/users/abc123/Desktop/JM/abc.txt");
		Properties p=new Properties();
		if(!f.exists()){
			f.createNewFile();
		}
		p.load(new FileInputStream(f));
		int usetime=Integer.parseInt(p.getProperty("usetime","0"));
		final int resttime=30-usetime;
		if(usetime<30){
			System.out.println("**使用软件**");
			System.out.println("剩余使用时间"+resttime+"秒");
			long time1=System.currentTimeMillis();
			//监视线程：从剩余时间开始倒计时，倒计时结束写入日志文件并System.exit(0)结束程序
			new Thread(){
				public void run(){
					for(int i=0;i<resttime;i++){
						try{
							Thread.sleep(1000);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					System.out.println("试用结束（30秒）请氪金");
					p.setProperty("usetime",30+"");
					exitSoftware(p,f);
				}
			}.start();
			//主线程：输入任意模拟结束使用软件，期间计算使用时间并写入日志
			Scanner input=new Scanner(System.in);
			System.out.println("输入任意结束使用");
			String str=input.next();
			long time2=System.currentTimeMillis();
			int time=(int)((time2-time1)/1000);
			usetime+=time;
			System.out.println("本次使用时间"+time+"秒，累计使用时间"+usetime+"秒。");
			p.setProperty("usetime",usetime+"");
			exitSoftware(p,f);
		}
		if(usetime>=30){
			System.out.println("试用结束（30秒）请氪金");
		}	
	}
	//封装方法,结束程序，保存日志
	private static void exitSoftware(Properties p,File f){
		try{
			p.store(new FileOutputStream(f),"");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
}
