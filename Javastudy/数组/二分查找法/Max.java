public  class Max
{
	public static void main(String[] args) 
	{
	     int[] a={2,3,5,7,8,9};
	     int index=halfSerch(a,9);
	     System.out.println("要找的数的下标是"+index);	
	}
	public static int halfSerch(int[] a,int x)
	{
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
		return -1;
	}
}