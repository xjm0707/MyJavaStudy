/**
**这是一个判断帖子是否过期以及找出不过期帖子最多点赞数的工具
*@version v1.0
*@author 徐江民
*/
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Post
{
	public static void main(String[] args) 
	{
		/**
        *@param postStamp[] postStamp为帖子日期的数组
        *@param zan[] zan为帖子点赞数的数组
        *@param url为网站地址
        */
        while(true)
        {
        Scanner input=new Scanner(System.in);
		String[] postStamp={"20160201","20160412","20160529","20160720","20160802"};
		int[] zan={12,44,178,135,23};
		String url="http://120.32.4.343:8080/login.jsp?name=xujianmin&&password=123456&&sex=men&&login=1470277690256";
        
        /**
        *@param arr为postStamp分割后的数组
        */
        String[] arr=url.split("&&");//将字符串依次用“&&”，“＝”符号进行分割得出帐号和密码
        String[] arr2=arr[0].split("=");
        String[] arr3=arr[1].split("=");

		System.out.println("请输入用户名：");
		String admin=input.next();
		System.out.println("请输入密码：");
		String password=input.next();
		
		
		if (arr2[1].equals(admin)&&arr3[1].equals(password))//判断账号密码是否输入正确 
		{
			System.out.println("姓名："+admin);

            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");//获取当前时间并将时间格式化
            Date date=new Date();
            String dateStr=sdf.format(date);
            System.out.println("登陆时间："+dateStr);
            System.out.println("----------------------------------------");
            
            /**
            *@param daysvalue为日期的差值
            */
            Calendar calendar=Calendar.getInstance();//获取一个日历对象并得到当前时间在一年中的天数
            int dayOfYear=calendar.get(Calendar.DAY_OF_YEAR);
            
            System.out.println("您的帖子有：");
            for (int i=0;i<postStamp.length;i++) //循环输入postStamp中的日期将其设定到日历中，并计算与当天时间的差值
            {
                String yearStr=postStamp[i].substring(0,4);
                String monthStr=postStamp[i].substring(4,6);
        	    String dayStr=postStamp[i].substring(6);

        	    int year=Integer.parseInt(yearStr);
                int month=Integer.parseInt(monthStr)-1;
                int day=Integer.parseInt(dayStr);

                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
        	    calendar.set(Calendar.DATE,day);

        	    int dayOfYear1=calendar.get(Calendar.DAY_OF_YEAR);
        	    int daysvalue=dayOfYear-dayOfYear1;

                
                for(int j=0;j<postStamp.length;j++)//将时间差大于100的日期删除，得到新的数组
        	    {
        	    	if (daysvalue<100) 
        	    	{
        	    	    postStamp[j]=postStamp[i];
        	    	    zan[j]=zan[i];
                        System.out.println("日期："+postStamp[j]);
        	    	    System.out.println("点赞数："+zan[j]);
        	    	    break;       	    		
        	    	}
        	    	else
        	    	{
        	    		break;
        	    	}
        	    }       	          	
            }
            System.out.println("----------------------------------------");       
            System.out.println("点赞数最多的日期为:"+postStamp[getMax(zan)]);
            System.out.println("点赞数为:"+zan[getMax(zan)]);
            break;
		}
		else
		{
           System.out.println("用户名密码错误,请重新输入！");
		}
        }	
	}
	/**
    *最大值的计算方法
    *@param max为数组中的最大值
    *@param dex为下标值
    */
	public static int getMax(int[] arr)
	{
	    int max=arr[0];                  
		int dex=0;                          
		for (int i=0;i<arr.length;i++)         
		{
			for (int j=0;j<arr.length;j++) 
			{
				if (arr[i]>max)            
				{
					max=arr[i];      
					dex=i;
				}
			}
		}
		return dex;
	}
}