import java.util.Scanner;
public class CarExceptionDemo{
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		while (true) {
			System.out.println("请设定当前气温");
			float temperature=scan.nextFloat();
			System.out.println("请设定当前时速");
			int speed=scan.nextInt();
			System.out.println("请输入剩余油量");
			float oil=scan.nextFloat();
			try{
				new Car(temperature,speed,oil).run();
			}catch (CarTireException e) {
				e.printStackTrace();
				new CarShop_4S().fit(new CarShop_4S().new Driver());
			}catch (ZeroOilException e) {
				e.printStackTrace();
			}catch (BrokenDownException e) {
				e.printStackTrace();
			}
		}
	}
}

class Car{
	float temperature;
	int speed;
	float oil;
	public Car(){}
	public Car(float temperature,int speed,float oil){
		this.temperature=temperature;
		this.speed=speed;
		this.oil=oil;
	}
	void run()throws CarTireException{//汽车行进
		if (temperature>20.5) {
			throw new CarTireException("boom！！叽叽咔咔~~~砰！");
		}
		if (oil<=0) {
			throw new ZeroOilException("没油了，请前往加油站加油");
		}
		if (speed>150) {
			throw new  BrokenDownException("速度太快，引擎冒烟了");
		}
	}
}
class CarShop_4S{
	String name;
	void fit(Driver driver){//汽车维修
		System.out.println("汽车进厂维修");
	}
	class Driver{
		String name;
		void drive(Car car)throws CarTireException{//驾驶员开车
			try{
				car.run();
			}catch (CarTireException e) {
				e.printStackTrace();
			}
		}
	}
}

class CarTireException extends Exception{
	public CarTireException(String message){
		super(message);
	}
}
class ZeroOilException extends RuntimeException{
	public ZeroOilException(String message){
		super(message);
	}
}
class BrokenDownException extends RuntimeException{
	public BrokenDownException(String message){
		super(message);
	}
}