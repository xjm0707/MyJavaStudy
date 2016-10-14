public class Maxindex
{
	public static void main(String[] args) 
	{
		int[] arr1=new int[]{6,4,2,21,43,3};    //定义一个数组
		int max=arr1[0];                        //定义一个最大值
		int dex=0;                              //定义一个下标值
		for (int i=0;i<arr1.length;i++)         
		{
			for (int j=0;j<arr1.length;j++) 
			{
				if (arr1[i]>max)                //当数组中的数值大于最大值的时候
				{
					max=arr1[i];                //将该数值赋值给最大值
					dex=i;                      //该数值的下标值
				}
			}
		}
		System.out.println(dex);	            //输出下标值
	}
}