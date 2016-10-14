import java.util.Scanner;
public class JudgeIDcard
{
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		while(true) 
		{
			System.out.println("请输入您的身份证号码：");
			String id=input.next();                       //定义一个用户需要输入的身份证号
			char[] a=id.toCharArray();                    //将该身份证号转换为数组
			if (a.length==15)                             //当数组的长度为15时执行下列操作
			{
				System.out.println("15位身份证号码");
				if (a[a.length-1]%2==0)                   //数组的倒数第一位与2取余
				{
					System.out.println("女性");
				}
				else
				{
					System.out.println("男性");
				}
				String brith=id.substring(6,11);          //字符串的截取
				System.out.println("出生日期为:"+brith);
			}
			else if (a.length==18) 
			{
				System.out.println("18位身份证号码");
				if (a[a.length-2]%2==0) 
				{
					System.out.println("女性");
				}
				else
				{
					System.out.println("男性");
				}
				String brith=id.substring(6,14);
				System.out.println("出生日期为:"+brith);
			}
			else
			{
				System.out.println("输入有误");
				break;
			}
			
		}
	}
}