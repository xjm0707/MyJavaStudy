 import java.util.Scanner;
 public class Password
 {
     public static void main(String[] args) 
     {         
         System.out.println("请输入你的帐号");
  	     Scanner input=new Scanner(System.in);
         String a=input.next();
  	     
         for(;;)
         {
  	         System.out.println("请输入你的密码");
             int b=input.nextInt();
             if(b==6423)
             {
    	     System.out.println("恭喜你登陆成功！");
    	     break;
             }
             else
             {
    	     System.out.println("密码输入错误！");
             }
         }

     }
 }