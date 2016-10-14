public class Oushu{
	public static void main(String[] args) 
	{
		for (int a=0;a<=100;a++) 
		{
			if(a==66)
			{
				continue;//当a为66时 剔除该值
			}
			if(a%2==0)
			{
				System.out.println(a);//输出被2整除的偶数
			}
			
		}

    System.out.println("-------------------------------");
		//九九乘法表
		for(int i=1;i<10;i++) 
		{
			for(int j=1;j<i+1;j++)  
			{
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();
		}		
	}
}