import java.util.Arrays;
import java.util.Scanner;
public class Arrtest
{
	public static void main(String[] args) 
	{
		int[] d={8,34,54,3,13,5,10};
		Scanner input=new Scanner(System.in);
		System.out.println("请输出上标：");
		int a=input.nextInt();
		System.out.println("请输入下标：");
		int b=input.nextInt();
		while (true) 
		{
			if (a>0&&a<=b&&b<=d.length) 
			{
				copyarr(d,a,b);
				break;
			}
            else 
            {
			    System.out.println("输入有误");
			    break;  	
            }				
		}	    		
	}
	public static int copyarr(int arr[],int a,int b)
	{
		int[] arr1=new int[b-a+1];
		for (int i=a-1;i<b;i++) 
		{
			arr1[i-(a-1)]=arr[i];
		}
		for (int i=0;i<arr1.length;i++) 
		{
			System.out.print(arr1[i]+" ");
		}
		return -1;
	}
}