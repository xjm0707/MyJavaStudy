import java.util.Scanner;
import java.util.Calendar;
public class Huiyuan{
	public static void main(String[] args) {
		String[] info={"zhansan","123456","20160101"};
		System.out.println("请输入用户名和密码");
		Scanner input=new Scanner(System.in);

		String userName=input.next();//获取用户名
		String password=input.next();//获取密码
		//字符串内容的比较实用equals
		String name=info[0];
		String pass=info[1];
		String regist=info[2];

		//判断用户名和密码是否正确
		if(userName.equals(name) && password.equals(pass)){
			System.out.println("登录成功，您的信息是："+name+" "+regist);//用户信息显示

			Calendar c=Calendar.getInstance();//获取当前时间
			int dayOfYear1=c.get(Calendar.DAY_OF_YEAR);//当前时间在一年中第几天

			//获取到了注册时间的年月日
			String yearStr=regist.substring(0,4);
			String monthStr=regist.substring(4,6);
			String dayStr=regist.substring(6);

			//将字符串的年月日转换成int类型的年月日
			int year=Integer.parseInt(yearStr);//将字符串年转成int类型的年，"2016"--->2016
			int month=Integer.parseInt(monthStr)-1;//要减1，才是6月
			int day=Integer.parseInt(dayStr);

			//修改日期
			c.set(Calendar.YEAR,year);
			c.set(Calendar.MONTH,month);
			c.set(Calendar.DATE,day);

			int dayOfYear2=c.get(Calendar.DAY_OF_YEAR);//20160601是一年中的第几天

			if((dayOfYear1-dayOfYear2)>100){
				System.out.println("您已是VIP用户");
			}else{
				System.out.println("继续努力");
			}			
		}else{
			System.out.println("登录失败");
		}
	}
}