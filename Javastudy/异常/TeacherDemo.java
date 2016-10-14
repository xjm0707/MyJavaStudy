public class TeacherDemo{
	public static void main(String[] args)throws Exception{
		JavaTeacher a=new JavaTeacher();
		Random ran=new Random();
		int r=ran.nextInt(4);
		try{
			a.teach(r);
		}
		catch(LanpingException e){	
			System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("修复电脑");
		}
		catch(PinghuaiException e){
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			throw e;
		}
		catch(ShengbingException e){
			System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("老师吃药");
		}
		System.out.println("上课中");
}
}

abstract class Teacher{
	private String name;
	abstract  void teach(int i)throws Exception;
}

class JavaTeacher extends Teacher{

	public void teach(int i)throws Exception{
		System.out.println("授课");
		if (i==0) {
			throw new LanpingException("电脑蓝屏了");
		}
		if (i==1) {
			throw new PinghuaiException("电脑显示屏坏了");
		}
		if (i==2) {
			throw new ShengbingException("老师生病了");
		}
	}

}
class LanpingException extends Exception{
	public LanpingException(String message){
		super(message);
	}
} 
class PinghuaiException extends Exception{
	public PinghuaiException(String message){
		super(message);
	}
} 
class ShengbingException extends Exception{
	public ShengbingException(String message){
		super(message);
	}
} 