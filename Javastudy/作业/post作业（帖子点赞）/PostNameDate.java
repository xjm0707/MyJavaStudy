import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
*类名：PostNameDate
*功能描述：这是一个测试类用于查看某用户的帖子是否过期
*以及查看未过期帖子的点赞情况
*/
public class PostNameDate{
	public static void main(String[] args) {
		String [] postStamp={"20160201","20160412","20160529","20160720","20160802"};
		int [] zan={12,44,78,135,23};
		String url="http://120.32.4.343:8080/login.jsp?name=yuann&&password=123456&&sex=men&&login=1470277690256";
		String [] info=getInfo(url);
		String name=info[0];
		String psd=info[1];
		String sex=info[2];
		Calendar today=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String dateStr=sdf.format(today.getTimeInMillis());
		Scanner input=new Scanner(System.in);
		if(login(input,name,psd)){
			showInfo(name,sex,dateStr);
		}
		String [] newStamp=new String [10];
		int [] newZan=new int [10];
		for(int j=0;j<postStamp.length;j++){
			if(dateCompare(postStamp[j],today)){
				insert(newStamp,postStamp[j]);
				insert(newZan,zan[j]);
				//delete(postStamp,j);
				//delete(zan,j);
			}
		}
		System.out.println("查看我的帖子");
		garbage(newStamp,newZan);
		System.out.println("输入1查看点赞数最多的帖子");
		int index=0;
		int max=0;
		while(true){
		if(input.nextInt()==1){
			for(int i=0;i<newZan.length;i++){
				if(newZan[i]>max){
					index=i;
					max=newZan[i];
				}
			}
			System.out.println("第"+(index+1)+"个帖子");
			System.out.println(newStamp[index]);
			System.out.println("点赞数"+newZan[index]);
			break;
		}else{
			System.out.println("请重新输入");
		}
	}
	}
	/**
	*从链接中截取有用信息的方法
	*@parma str str是网址链接
	*@return 返回值是由用户名，密码，性别组成的字符串数组
	*/
	public static String [] getInfo(String str){
		String [] urls=str.split("&&");
		String name=(urls[0].split("="))[1];
		String psd=(urls[1].split("="))[1];
		String sex=(urls[2].split("="))[1];
		String [] info={name,psd,sex};
		return info;
	}
	/**
	*判断登录的方法
	*@parma input
	*@parma name name是正确的用户名
	*@parma psd psd是正确的密码
	*@return 返回boolean类型的登录信息
	*/
	public static boolean login(Scanner input,String name,String psd){
		while(true){
			System.out.println("用户登录");
			System.out.println("输入用户名");
			String loginName=input.next();
			System.out.println("请输入密码");
			String loginPsd=input.next();
			if(loginName.equals(name)&&loginPsd.equals(psd)){
				return true;
			}else{
				System.out.println("请输入正确的账号和密码");
			}
		}
	}
	/**
	*显示用户信息的方法
	*@parma name name是用户名
	*@parma sex  sex性是别
	*@parma dateStr dateStr是登录时间
	*/
	public static void showInfo(String name,String sex,String dateStr){
		System.out.println("------------------------------");
		System.out.println("登陆成功");
		System.out.println("用户名"+name);
		System.out.println(sex);
		System.out.println("登录时间"+dateStr);
	}
	/**
	*判断帖子是否过期的方法
	*@parma str str是表示帖子时间的字符串
	*@parma today today是表示今天时间的Calendar类
	*@return 返回boolean帖子是否过期信息
	*/
	public static boolean dateCompare(String str,Calendar today){
		int year=Integer.parseInt(str.substring(0,4));
		int month=Integer.parseInt(str.substring(4,6))-1;
		int day=Integer.parseInt(str.substring(6,8));
		Calendar theday=Calendar.getInstance();
		theday.set(year,month,day);
		int minus=today.get(Calendar.DAY_OF_YEAR)-theday.get(Calendar.DAY_OF_YEAR);
		if(minus<100){
			return true;
		}else{
			return false;
		}
	}
	/*public static void delete(String [] arr,int i){
		/*while(arr[i+1]!=null){
			arr[i]=arr[i+1];
			i++;
			if(i==4){
				break;
			}
		}
		arr[i]=null;*/
		/*for(int j=i;j<arr.length-1;j++){
			arr[j]=arr[j+1];
		}
		arr[arr.length-1]=null;
	}
	public static void delete(int [] arr,int i){
		/*while(arr[i+1]!=0){
			arr[i]=arr[i+1];
			i++;
			if(i==4){
				break;
			}
		}
		arr[i]=0;*/
		/*for(int j=i;j<arr.length-1;j++){
			arr[j]=arr[j+1];
		}
		arr[arr.length-1]=0;
	}*/
	/**
	*把没过期的帖子信息加入新数组中的方法
	*@parma arr arr是容纳帖子信息的数组
	*@parma str str是表示帖子信息的内容
	*/
	public static void insert(String [] arr,String str){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==null){
				arr[i]=str;
				break;
			}
		}
	}
	/**
	*把没过期的帖子信息加入新数组中的方法
	*@parma arr arr是容纳帖子信息的数组
	*@parma num num是表示帖子信息的内容
	*/
	public static void insert(int [] arr,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				arr[i]=num;
				break;
			}
		}
	}
	/**
	*打印输出数组的方法
	*@parma arr arr需要打印输出的数组
	*/
	public static void printArray(String [] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=null){
				System.out.print(arr[i]+",");
			}
		}
		System.out.println();
	}
	/**
	*打印输出数组的方法
	*@parma arr arr需要打印输出的数组
	*/
	public static void printArray(int [] arr){
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=0){
				System.out.print(arr[i]+",");
			}
		}
		System.out.println();
	}
	/*public static void myStamp(String [] postStamp,int [] zan,Scanner input){
		printArray(postStamp);
		printArray(zan);
		System.out.println("输入1查看点赞数最多的帖子");
		int index=0;
		int max=0;
		while(true){
		if(input.nextInt()==1){
			for(int i=0;i<zan.length;i++){
				if(zan[i]>max){
					index=i;
					max=zan[i];
				}
			}
			System.out.println("第"+(index+1)+"个帖子");
			System.out.println(postStamp[index]);
			System.out.println("点赞数"+zan[index]);
			break;
		}else{
			System.out.println("请重新输入");
		}
	}
	}*/
	/**
	*输出经筛选的帖子的方法
	*@parma garbageStamp garbageStamp是容纳发帖时间为超过100天的帖子的数组
	*@parma garbageZan garbageZan是相应帖子的点赞数
	*/
	public static void garbage(String [] garbageStamp,int [] garbageZan){
		printArray(garbageStamp);
		printArray(garbageZan);
	}
}