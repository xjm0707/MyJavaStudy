import java.util.Scanner;
public class CarTest{
	public static void main(String[] args){
		while(true){
		    Scanner input=new Scanner(System.in);
		
		    System.out.println("-----------------------");
		    System.out.println("输入汽车品牌");
		    String name=input.next();
		
		    System.out.println("请输入剩余油量");
		    int oil=input.nextInt();
		
		    System.out.println("请输入当前时速");
		    int speed=input.nextInt();
		
		    Car car=new Car(name,speed,oil);
		    CarShop4s shop=new CarShop4s();
		    CarShop4s.Driver driver=shop.new Driver();
		
		    try{
			    driver.drive(car);                             //应该是司机调用drive方法
		    }
		    catch (BlowOutException e) {
			    //e.printStackTrace();
			    System.out.println(e.getMessage());
			    System.out.println("下车换胎");

		    }
		    catch (NoOilException e) {
			    //e.printStackTrace();
			    System.out.println(e.getMessage());
			    System.out.println("去加油站加油");
		    }
		    catch (BrokeException e) {
			    //e.printStackTrace();
			    System.out.println(e.getMessage());
			    shop.fix();
		    }
	    }
	}

}
//汽车类
class Car{
	String name;
	int speed;
	int oil;
	public Car(){}
	public Car(String name,int speed,int oil){
		this.name=name;
		this.speed=speed;
		this.oil=oil;
	}
	public String getName(){
		return name;
	}
	void run()throws BlowOutException{
		System.out.println(getName()+"飞速前进中。。");
		if (speed>200&&oil>100) {
			throw new BlowOutException("爆胎了");                        //题目是爆胎了，不是爆炸了，司机可处理
		}
		if (oil<=0) {
			throw new NoOilException("没油了");
		}
		if (speed>150) {
			throw new BrokeException("抛锚了");
		}

	}

}

//汽车修理店
class CarShop4s{
	private String name;
	public void fix(){
		System.out.println("进厂维修");
	}
	//内部类 修理店工作人员
    class Driver{
    	private String name;
    	public void drive(Car car)throws BlowOutException{
    		try{
    			car.run();
    		}
    		catch (BlowOutException e) {
    			throw e;                             //这里应该有throw e；加这一行是drive（）方法抛出去异常的，意思是司机无法处理抛出异常
    		}                                                    //你不加是编译的时候是run（）抛出的异常，虽然结果一样，但是逻辑不清。

    	}

    }

}
//汽车爆炸异常
class BlowOutException extends Exception{
	public BlowOutException(String message){
		super(message);
	}
}
//汽车没油异常
class NoOilException extends RuntimeException{
	public NoOilException(String message){
		super(message);
	}
}
//汽车抛锚异常
class BrokeException extends RuntimeException{
	public BrokeException(String message){
		super(message);
	}
}