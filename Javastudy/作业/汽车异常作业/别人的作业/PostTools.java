/**
*这是一个判断帖子是否过期以及找出不过期帖子最多点赞数的工具
*@version v1.0
*@author 程羽童
*/

import java.util.Calendar;
import java.text.SimpleDateFormat;
public class PostTools{
	private String url;
	private String name;
	private long time;
	private	int index;
	/**
	*格式化时间并输出的方法
	*/
	void print(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");			//时间格式化
		String dateStr=sdf.format(time);
		System.out.println("姓名："+name+"  登录时间："+dateStr);
	}

	/**
	*筛选帖子是否过期的方法
	*@parma postStamp[] postStamp数组是帖子日期的数组
	*@parma zan[] zan数组对应帖子是点赞个数的数组
	*/

	void screen(String[] postStamp,int[] zan){
		System.out.print("过期的帖子有：");
		int sum=0;
		int max=0;
		int index=0;
		for (int i=0;i<postStamp.length ;i++ ) {
			String yearStr=postStamp[i].substring(0,4);					//分别提取年月日
			String monthStr=postStamp[i].substring(4,6);
			String dayStr=postStamp[i].substring(6);
			// int year=Integer.parseInt(yearStr);
			int month=Integer.parseInt(monthStr);
			int day=Integer.parseInt(dayStr);
			Calendar calendar=Calendar.getInstance();				
			int dayNow=calendar.get(Calendar.DAY_OF_YEAR);				//一年中的第几天
			calendar.set(Calendar.MONTH,month-1);						//将时间设置成发帖的时间
			calendar.set(Calendar.DATE,day);
			long time=calendar.getTimeInMillis();
			int daySet=calendar.get(Calendar.DAY_OF_YEAR);
			int value=dayNow-daySet;
			if (value>99) {												//判断是否超过100天
				System.out.print(postStamp[i]+" ");
				sum++;
			}else{
				for (int j=0;j<zan.length ;j++ ) {
					if(zan[j]>max){
						index=j;
						max=zan[j];
					}
				}
			}
		}
		System.out.println();
		System.out.println("一共有"+sum+"篇");
		System.out.println("其中点赞数最多的有"+max+"个赞，是第"+(index-1)+"篇");
	}

	/**
	*从url中提取信息的构造函数
	*@parma url[] url是一个网站地址
	*/
	public PostTools(String url){
		StringBuffer buffer=new StringBuffer(url);
		buffer=buffer.delete(0,35);
		url=buffer.toString();
		String[] str=url.split("&&");			//分割&&字符串
		name=str[0].split("=")[1];				//分割=字符串
		time=Long.parseLong(str[3].split("=")[1]);		//用了一个二维数组来提取想要的信息
	}
}