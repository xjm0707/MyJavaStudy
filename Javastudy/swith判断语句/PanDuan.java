import java.util.Scanner;
public class PanDuan
{
	public static void main(String[] args)
	{
		int a=1;
		Scanner input=new Scanner(System.in);
		int b=input.nextInt();
		switch(b)
		{
		 case 1:
		 System.out.println("ok");
		 break;
		 case 2:
		 System.out.println("no");
		 break;
		 default:
		 System.out.println(b);

		}
	}
}