public class AnyClassTest{
	public static void main(String[] args) {
		// Thread thread=new Thread(){
		//     public void run(){
		// 	    System.out.println("下载");
		//     }
		// };
		// thread.start();

		// new Thread(){
		// 	public void run(){
		// 		System.out.println("看电影");
		// 	}
		// }.start();
        BusStop busStop=new BusStop();
        busStop.setStatus(0);
        int status=busStop.getStatus();

        Baoan baoan=new Baoan(){
        	public void anjian(int zhuantai){
        		if (zhuantai==0) {
        			System.out.println("安全");
        		}
        		else if (zhuantai==1) {
        			System.out.println("不安全");
        		}
        	}
        };
        busStop.check(baoan,status);

	}
}
class BusStop{
	private int status=0;

	public void setStatus(int status){
		this.status=status;
	}
	public int getStatus(){
		return status;
	}
	
	public void check(Baoan baoan,int status){
		baoan.anjian(status);
	}
	
	public void waitForBus(){
		System.out.println("候车");
	}
	
}
abstract class Baoan{
	abstract void anjian(int zhuantai);

}