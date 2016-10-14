import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class DateFormatTest
{
	public static void main(String[] args) 
	{
		for (; ; ) 
		{
		Scanner input=new Scanner(System.in);
        System.out.println("请输入日期：");
        String a=input.next();
        String b="yyyy/MM/dd";
        char[] a1=a.toCharArray();
        char[] b1=b.toCharArray();
        String a2=a.replace("/","0");
        char[] a3=a2.toCharArray();

        if (a1.length==10&&judgeChar(a3)&&judgeyear(a1)&&judgemonth(a1)&&judgeday(a1)) //判断输入的日期格式是否正确
        {
        	if (a1[4]==b1[4] && a1[7]==b1[7]) //判断输入的日期格式是否正确，与刚刚设定的d1做比较，比较／所在的位置是否一致
            {
        	   Calendar c=Calendar.getInstance();//获取一个日历对象
               int weekOfYear1=c.get(Calendar.WEEK_OF_YEAR);//获取当前日期所在的一年中的第几周
               int yearnow=c.get(Calendar.YEAR);//获取当前的年份

        	   String yearStr=a.substring(0,4);//截取输入日期的年份月份日
        	   String monthStr=a.substring(5,7);
        	   String dayStr=a.substring(8);

        	   int year=Integer.parseInt(yearStr);//将截取的字符串转换为int
        	   int month=Integer.parseInt(monthStr)-1;
        	   int day=Integer.parseInt(dayStr);

        	   c.set(Calendar.YEAR,year);//将输入的日期设置到日历中
        	   c.set(Calendar.MONTH,month);
        	   c.set(Calendar.DATE,day);

        	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");//将输入的日期格式化
        	   long time=c.getTimeInMillis();
               String d=sdf.format(time);
		       System.out.println(d);

        	   int weekOfYear2=c.get(Calendar.WEEK_OF_YEAR);//获取输入的日期所在的一年中的第几周
        	   int yearvalue=yearnow-year;//计算输入的年份和当前年份的差值

               if (weekOfYear1>weekOfYear2) 
               {
               	    int weekvalue=weekOfYear1-weekOfYear2;
               	    int value=yearvalue*48+weekvalue;//计算日期之间的差值
               	    System.out.println("与当前日期相差"+value+"周");
               }
               else
               {
               	    int weekvalue=weekOfYear2-weekOfYear1;
               	    int value=yearvalue*48+weekvalue;
               	    System.out.println("与当前日期相差"+value+"周");
               }    	
            }
            else
            {
            	System.out.println("输入日期格式有误");
            }
        }
        else
        {
        	System.out.println("输入日期格式有误");
        }
	    }
    }

	public static boolean judgeChar(char[] array)
	{//判断输入的日期是否都是数字
		boolean flag=true;
		for(int i=0;i<array.length;i++)
	    {
	    	if (array[i]<48||array[i]>57) 
	    	{
	    		flag=false;
	    		break;
	    	}
	    }
	    return flag;
	}

	public static boolean judgeyear(char[] array)
	{//判断输入的日期的年份格式
		int year1=((array[0]-48)*1000)+((array[1]-48)*100)+((array[2]-48)*10)+(array[3]-48);
        if (year1>2016||year1<1900) 
        {
        	return false;
        }
        else
        {
        	return true;
        }
	}

	public static boolean judgemonth(char[] array)
	{//判断月份格式
		int month1=((array[5]-48)*10)+(array[6]-48);
		if (month1==0||month1>12) 
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static boolean judgeday(char[] array)
	{//判断日期格式
		int day1=((array[8]-48)*10)+(array[9]-48);
		int month2=((array[5]-48)*10)+(array[6]-48);
		if (month2==2) 
        {
			if (day1==0||day1>28) 
		    {
			    return false;
		    }
		    else
		    {
			    return true;
		    }
			
		}
		else if (month2==4||month2==6||month2==9||month2==11) 
		{
			if (day1>30) 
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
            if (day1>31) 
			{
				return false;
			}
			else
			{
				return true;
			}
		} 		
	}
}