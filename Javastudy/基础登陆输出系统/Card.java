import java.util.Scanner;
public class Card
{
  public static void main(String[] args) 
  {
    for(;;)
    {

    int money=10000;
  	System.out.println("请输入你的金额");
  	Scanner input=new Scanner(System.in);
  	int a=input.nextInt();
    if(a>=money)
    {
    	System.out.println("土豪！我们做朋友吧！");
    }
    else
    {
    	System.out.println("矮穷挫给我闪一边去！");
    }
    }
  }
}