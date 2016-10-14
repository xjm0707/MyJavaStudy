import java.util.Scanner;
public class Copy
{
	public static void main(String[] args) 
	{
		int[] d={1,2,3,4,5,6,8,7};
		int[] arr=new int[8];
		System.arraycopy(d,3,arr,3,5);
		for (int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+" ");
		}
	}
}