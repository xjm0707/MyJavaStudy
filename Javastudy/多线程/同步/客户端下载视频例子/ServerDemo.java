public class ServerDemo{
	public static void main(String[] args) {
		Server s=new Server(98);
		Client c=new Client(s);
		c.download(4);
	}
}
class Server{
	private int total;
	public Server(int total){
		this.total=total;
	}
	public int speed(){
		return 5;
	}
	public int getTotal(){
		return total;
	}
}
class Client{
	private Server s;
	public Client(Server s){
		this.s=s;
	}
	private int aviTotal=0;
	public void download(int j){
		for (int i=1;i<j;i++) {			
			Thread t=new Thread(new Runnable(){
				public void run(){					
					while(true){
						try{
							Thread.sleep(100);
						}
						catch (Exception e) {
						}				
						synchronized (s){
							try{
								Thread.sleep(10);
							}
							catch (Exception e) {

							}					
							if (s.getTotal()<=aviTotal) {
								System.out.println(Thread.currentThread().getName()+"下载完毕！");
								break;
							}
							if ((s.getTotal()-aviTotal)<s.speed()) {
								aviTotal=aviTotal+(s.getTotal()-aviTotal);
							}
							else{
								aviTotal=aviTotal+s.speed();
							}
							System.out.println(Thread.currentThread().getName()+"下载中...已下载"+aviTotal+"M");
						}
					}
				}
			},"线程"+i);
			t.start();
		}
	}
}