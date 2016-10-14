public class SuperArrayUtils
{        

    //选择排序
    public static void selectSort(int[] arr)throws Exception
    { 
    	if (arr==null) 
    	{
    		throw new NullPointerException("数组不能为空");
    	}
        for (int i=0;i<arr.length;i++)               
		{
			for (int j=i+1;j<arr.length;j++) 
			{
				if (arr[i]>arr[j]) 
				{
					int tmp;
					tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}			
		}
    } 

    //冒泡排序
    public static void bubbleSort(int[] arr)throws Exception
    {    
		if (arr==null) 
		{
		    throw new NullPointerException("数组不能为空");	
		}
		for (int i=0;i<arr.length;i++)              
		{
			for (int j=0;j<arr.length-1;j++) 
			{
				if (arr[j]>arr[j+1]) 
				{
					int tmp;
					tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}			
		}
	}

    //二分查找法
	public static int halfSerch(int[] a,int x)throws Exception
	{
		for (int i=0;i<a.length;i++) {
		    if (x!=a[i]) 
		    {
		 	    throw new NoFindException("找不到数");
		    }
			
		}
		int min=0;
		int max=a.length-1;
		int mid;
		while (min<=max) 
		{
			mid=(min+max)>>1;
			if (x>a[mid]) 
			{
				min=mid+1;
			}
			else if (x<a[mid]) 
			{
				max=mid-1;
			}
			else
			{
				return mid;                                                                                                                                                                
			}
		}
		return min;
	}
}
//自定义找不到数的异常
class NoFindException extends Exception
{
	public NoFindException(String message)
	{
		super(message);
	}
}




