public class Sort
{
	public static void main(String[] args) 
	{
		int[] arr1=new int[]{2,7,5,9,4,3,6};          //定义一个数组1
		for (int i=0;i<arr1.length;i++)               //用选择排序的方式进行排序
		{
			for (int j=i+1;j<arr1.length;j++) 
			{
				if (arr1[i]>arr1[j]) 
				{
					int tmp;
					tmp=arr1[i];
					arr1[i]=arr1[j];
					arr1[j]=tmp;
				}
			}			
		}
		System.out.println("最大值为："+arr1[6]);
		System.out.println("最小值为："+arr1[0]);

		int[] arr2=new int[]{5,8,2,0,1,23,4};        //定义一个数组2
		for (int i=0;i<arr2.length;i++)              //用冒泡排序的方式进行排序
		{
			for (int j=0;j<arr2.length-1;j++) 
			{
				if (arr2[j]>arr2[j+1]) 
				{
					int tmp2;
					tmp2=arr2[j];
					arr2[j]=arr2[j+1];
					arr2[j+1]=tmp2;
				}
			}			
		}
		System.out.println("最大值为："+arr2[6]);     //输出的最大值为数组排序最末位的对应数值
		System.out.println("最小值为："+arr2[0]);     //输出的最小值为数组排序第一位的对应数值
	}
}