/*
多线程 实现Runnable接口
*/
public class RunnableTest{
	public static void main(String[] args) {
		MyRunnable r=new MyRunnable();
		Thread t=new Thread(r);
		t.start();
		
        //创建匿名对象
		new Thread(new Runnable(){
			int num=60;
			public void run(){
				while(num>0){
					System.out.println(num);
					num--;
				}
	        }
		}).start();
	}
}
class MyRunnable implements Runnable{
	int num=60;
	public void run(){
		while(num>0){
			System.out.println(num);
			num--;
		}
	}
}