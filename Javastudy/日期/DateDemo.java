import java.util.Calendar;
public class DateDemo{
	public static void main(String[] args) {
		/*long currentTime=System.currentTimeMillis();
		long dayTime=24*60*60*1000;
		System.out.println(currentTime-dayTime*2);
*/
		//通过new出来的对象都在堆中
		/*Date date=new Date();//System.currentTimeMillis();
		int year=date.getYear();//获取年份 是从1900到今年的年份数
		int month=date.getMonth();//获取月份，注意月份是从0开始的
		int day=date.getDate();//获取日

		System.out.println((year+1900)+"-"+(month+1)+"-"+day);*/

		
		//获取毫秒值
		Calendar calendar=Calendar.getInstance();//获取一个日历的对象
		long time =calendar.getTimeInMillis();//获取系统当前时间的毫秒
		System.out.println(time);

		
		//获取对应时间分度
		int year=calendar.get(Calendar.YEAR);//获取年，Calendar.YEAR是一个int类型
		int month=calendar.get(Calendar.MONTH)+1;//获取月份，月份从0开始
		int day=calendar.get(Calendar.DATE);//获取日
		int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);//一个月中的第几天
		int dayOfYear=calendar.get(Calendar.DAY_OF_YEAR);//一年中的第几天
		int weekOfMonth=calendar.get(Calendar.WEEK_OF_MONTH);//一个月中的第几个星期
		int weekOfYear=calendar.get(Calendar.WEEK_OF_YEAR);

		System.out.println(year+"年"+month+"月"+day+"日");
		System.out.println(dayOfMonth);
		System.out.println(dayOfYear);
		System.out.println(weekOfMonth);



		//获取当前的时间
		Calendar calendar1=Calendar.getInstance();//获取一个日历的对象，并获取到了当前的时间
		calendar1.set(Calendar.MONTH,6);
		calendar1.set(Calendar.DATE,1);//将当前的日期改为7月1日
		int a=calendar1.get(Calendar.WEEK_OF_YEAR);//得到7月1日是一年中第几个星期
		System.out.println(weekOfYear);
		System.out.println(a);
		//相减就得到当前时间和7月1日相差了几个星期（局限是隔年就不用这样使用了，例如2015/08/01和2016/08/01）
		System.out.println(weekOfYear-a);


	}
}