import java.io.*;
import java.util.Scanner;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 使用Properties来记录软件的使用时间和次数
 * @author yn
 *
 */
public class SoftwareTest{
	public static void main(String[] args) throws Exception{
		//观看时间操作15秒，就要付费
		File f = new File("D:/software.config");
		if(!f.exists()){
			f.createNewFile();
		}
		final Properties p = new Properties();
		p.load(new FileInputStream("D:/software.config"));
		final int time = Integer.parseInt(p.getProperty("time","0"));

		if(time==15000){
			System.out.println("免费使用时间已到，请购买");
			System.exit(0);//让程序自动退出
		}
		
		//使用定时器
		Timer timer=new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("您的免费使用时间已到，请购买");
				p.setProperty("time",15000+"");
				try {
					p.store(new FileOutputStream("D:/software.config"),null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
				System.exit(0);						
			}
		},15000-time);

		//用一个普通的线程代替定时器，到指定时间开启任务
		/*new Thread(new Runnable(){
			public void run(){
				try{
					Thread.sleep(15000-time);
					System.out.println("您的免费使用时间已到，请购买");
					p.setProperty("time",15000+"");
					p.store(new FileOutputStream("D:/software.config"),null);
					System.exit(0);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}			
		}).start();*/

		//用户可以选择操作
		Scanner scan=new Scanner(System.in);
		w:while(true){
			System.out.println("观看视频中...若停止请按1，其他继续观看");
			long time1=System.currentTimeMillis();
			int index=scan.nextInt();
			if(index==1){
				long time2=System.currentTimeMillis();
				p.setProperty("time",(time2-time1)+"");
				p.store(new FileOutputStream("D:/software.config"),null);
				//timer.cancel();//把定时器任务停止
				break;
			}else{
				System.out.println("继续观看");
				continue w;
			}
		}
		scan.close();
		
		//下面是使用次数达到3次就要付费
		/*File f=new File("D:/software.config");
		if(!f.exists()){
			f.createNewFile();
		}
		int count=0;
		Properties p=new Properties();
		p.load(new FileInputStream(f));
		
		count=Integer.parseInt(p.getProperty("count","0"))+1;
		if(count<=3){
			
			System.out.println("欢迎使用，已使用"+count+"次");
			count++;
			p.setProperty("count",count+"");
			p.store(new FileOutputStream(f),new String("我的软件配置".getBytes(),"ISO8859-1"));
		}else{
			System.out.println("请购买正版软件");
		}*/
	}
}