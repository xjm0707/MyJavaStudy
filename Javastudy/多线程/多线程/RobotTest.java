public class RobotTest{
	public static void main(String[] args) {
		Robot r=new Robot();
		r.xiwan();
		r.tuodi();
	}
}
class Robot implements Runnable{
	public void run(){}
	public void xiwan(){
		new Thread(new Runnable(){
			public void run(){
		        for (int i=0;i<100;i++) {
		        	System.out.println("洗碗---");	
		        }
		    }
		}).start();
    }
    public void tuodi(){
    	new Thread(new Runnable(){
    		public void run(){
    			for (int i=0;i<100;i++) {
		        	System.out.println("---拖地");	
		        }
		    }
    	}).start();
	    
    }
}