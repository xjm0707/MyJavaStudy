@public class Jux
{
	public static void main(String[] args) 
	{
		/*
		***** 尖角朝下改变初始值 尖角朝上改变判断条件
		****
		***
		**
		*
		*/
		for(int i=0;i<10;i++) 
		{
			for(int j=0;j<10;j++) 
			{	
				System.out.print("*");	
			}
			System.out.println();
		}
		int z=10;
		for(int i=0;i<10;i++) 
		{
			for(int j=0;j<z;j++) 
			{
				System.out.print("*");
			}
            z--;
            System.out.println();		
		}
		int z1=0;
		for(int i=0;i<10;i++) 
		{
			for(int j=z1;j<10;j++) 
			{
				System.out.print("*");
			}
            z1++;
            System.out.println();
        }   	
		for(int i=0;i<10;i++) 
		{
			for(int j=i;j<10;j++) 
			{
			    System.out.print("*");	
			}
			System.out.println();
		}
		/*
		*
		**
		***
		****
		*****
		******
		*/
		for(int i=0;i<10;i++) 
		{
			for(int j=0;j<i+1;j++) 
			{
			    System.out.print("*");	
			}
			System.out.println();
		}
		/*
         正三角
         －－－－＊
         －－－＊＊＊
         －－＊＊＊＊＊
         －＊＊＊＊＊＊＊
		*/
		for(int i=0;i<10;i++) 
		{
			for(int j=i;j<10;j++) 
			{
	            System.out.print(" ");  	
			}			
		    for(int j=0;j<i+1;j++) 
		    {
		     	System.out.print("* ");
		    }
		    System.out.println();
	    }
	    for(int i=0;i<10;i++) 
		{
			for(int j=0;j<i+1;j++) 
			{
	            System.out.print(" ");  	
			}			
		    for(int j=i;j<10;j++) 
		    {
		     	System.out.print("* ");
		    }
		    System.out.println();
	    }
	}
}