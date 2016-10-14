import java.util.Random;
public class StringDemo
{
	public static void main(String[] args) 
	{
		String str=new String("字符串的查找和截取！");
		char a=str.charAt(2);
		System.out.println(a);
		String b=str.substring(4,10);
		System.out.println(b);


		// String ss="0123456789";
		// String aa="abcdefghijklmnopqrstuvwxyz";
		// Random ran=new Random();
		// for (int i=0;i<2;i++) 
		// {
		// 	int b=ran.nextInt(1);
		// 	switch (b) 
		// 	{
		// 		case 0:
		// 		for (int k=0;k<2;k++) 
		// 		{
		// 			int f=ran.nextInt(10);
		// 			char e=ss.charAt(f);
		// 			System.out.print(e);
		// 			break;
		// 		}
		// 		case 1:
		// 		for (int k=0;k<2;k++) 
		// 		{
		// 			int g=ran.nextInt(26);
		// 			char c=aa.charAt(g);   
		// 			System.out.print(c);
		// 			break;
		// 		}

		// 	}
		// }
			
		

        //字符的首尾判断
		String str="hello world!";
		boolean blStart=str.startsWith("e");
		boolean blEnd=str.endsWith("!");
		System.out.println(blStart);
		System.out.println(blEnd);
        

        String s=" sdf sdfsmr er erwqr tg ddgf    ";
        System.out.println(s.trim());//去除首尾空格

        System.out.println(s.replace("d","D"));//将所有d替换成D

        String d=s.replace(" ","");

        System.out.println(d.toLowerCase());//所有字符大写转小写
        System.out.println(d.toUpperCase());//所有字符小写转大写
        
        char[] c=d.toCharArray();//将字符串转化为数组
        for (int i=0;i<c.length;i++) 
        {
        	if(i==c.length-1)
        	{
        		System.out.print(c[i]);
        	}
        	else
        	{
        		System.out.print(c[i]+",");
        	}
        }

        
        // //计数器思想
        // String str="iasdfinvcxvpoiarnpvcxzfsd";
        // int count=0;
        // char[] str2=str.toCharArray();
        // for (int i=0;i<str2.length;i++) 
        // {
        // 	if (str2[i]=='a') 
        // 	{
        // 		count++;
        // 	}
        // }
        // System.out.print(count);



        // String str1="1,2,3,4,5,6";
        // String[] c3=str1.split(",");
        // for (int i=0;i<c3.length;i++) 
        // {
        // 	System.out.print(c[i]+" ");	
        // }


        




	}
}