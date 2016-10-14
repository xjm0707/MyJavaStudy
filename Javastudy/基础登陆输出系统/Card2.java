import java.util.Scanner;
public class Card2
{
	public static void main(String[] args) 
	{
	    int money=10000;//定义金额为10000元
		System.out.print("请输入你的金额");
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int c=(int)a/money;
		switch(c)//判断输出金额a的数值
		{
			case 0:
			System.out.println("你已经穷了");
			break;
		    case 1:	
			System.out.println("你太有钱了");
			default:
		    System.out.println("你太有钱了");
		}		

	}
}