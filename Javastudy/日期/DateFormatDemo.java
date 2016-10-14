import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateFormatDemo{
	public static void main(String[] args) {

		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(Calendar.YEAR);//获取年，Calendar.YEAR是一个int类型
		int month=calendar.get(Calendar.MONTH)+1;//获取月份，月份从0开始
		int day=calendar.get(Calendar.DATE);//获取日
		//如果要输出多种格式的日期，则需要自己手动来定义，非常麻烦
		System.out.println(year+"-"+month+"-"+day);
		System.out.println(year+"年"+month+"月"+day+"日");
		System.out.println(month+"/"+day+"/"+year);


		//通过new的方式创建一个简单的日期格式工具类
		//传入一个自定义的时间格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=new Date();
		//传入的是一个Date类型对象，并进行时间格式化
		String dateStr=sdf.format(date);
		System.out.println(dateStr);

		//传入的是一个long类型的毫秒值，并进行时间格式化
		long time=System.currentTimeMillis();
		String dateStr1=sdf.format(time);
		System.out.println(dateStr1);
	}
}