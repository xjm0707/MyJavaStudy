import java.util.Random;
public class ThunderDemo{
    public static void main(String[] args) {
        Thunder thunder=new Thunder();
        thunder.download();
    }
}

class Thunder{
    private String flag[] = {"true"};
    public void download(){
        Thunder.ToDownload tod=this.new ToDownload();
        Thread t1=new Thread(tod,"视频1：");
        Thread t2=new Thread(tod,"视频2：");
        Thread t3=new Thread(tod,"视频3：");
        Thread t4=new Thread(new Runnable(){           //监视线程，监视电脑是否会发生异常以及所有视频是否下载完
            public void run(){
            Random random=new Random();
            while(true){                             //大致意思是没0.5秒生成一个随机数0-4，如果为0抛出断网异常，处理方法是等待5秒来网继续下载
                try{                                 //如果为1则抛出蓝屏异常，处理方法是等待5秒重启继续下载
                    Thread.sleep(500);
                }catch(Exception e){
                    e.printStackTrace();
                }
                try{
                    int j=random.nextInt(5);
                    if(j==0){
                        throw new NetBrokenException("断网了");
                    }
                    if(j==1){
                        throw new ScreenBlueException("蓝屏了");
                    }
                }catch(NetBrokenException e){
                    System.out.println(e.getMessage());
                    synchronized (flag) {                 
                        flag[0] = "false";  
                        System.out.println();
                        try{
                            Thread.sleep(5000);
                        }catch(InterruptedException p){
                            p.printStackTrace();
                        }
                        System.out.println("来网了");
                        System.out.println("继续下载");
                        System.out.println();
                        flag[0] = "true";
                    } 
                }catch(ScreenBlueException e){
                    System.out.println(e.getMessage());
                    synchronized (flag) {  
                        flag[0] = "false";  
                        System.out.println();
                        System.out.println("重启电脑");
                        try{
                            Thread.sleep(5000);
                        }catch(InterruptedException p){
                            p.printStackTrace();
                        }
                        System.out.println("继续下载");
                        System.out.println();
                        flag[0] = "true";
                    } 
                }
            if(!t1.isAlive()&&!t2.isAlive()&&!t1.isAlive()){           //判断123线程是否运行完，如果是则关闭监视线程
               System.out.println("所有视频下载完毕");
               break;
           }
            }
        }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    class ToDownload implements Runnable{
        public void run(){
            for(int i=1;i<11;i++){
                try{
                    Thread.sleep(500);
                }catch(Exception e){
                    e.printStackTrace();
                }
                synchronized (flag) { //用flag控制线程暂停 
                    while (flag[0] != "true") { 
                        try {  
                            flag.wait();
                        } catch (InterruptedException e) {  
                            e.printStackTrace();  
                        }  
                    } 
                }     
                System.out.println(Thread.currentThread().getName()+10*i+"%");
            }
            System.out.println(Thread.currentThread().getName()+"下载完成。");
        }
    }
    
}
class ScreenBlueException extends Exception {
    public ScreenBlueException(String message){
        super(message);
    }
}
class NetBrokenException extends Exception {
    public NetBrokenException(String message){
        super(message);
    }
}