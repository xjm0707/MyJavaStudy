import java.util.Scanner;
public class Shape
{
  public static void main(String[] args) 
  {
  	Scanner input=new Scanner(System.in);     
    for (; ; ) //让用户循环选择输入数字1或2，输入其他数字退出
    { 
      System.out.println("请输入1或2");
      int a=input.nextInt();//定义一个数字a
      if(a==1)
      {
        for (int i=0;i<10;i++) 
        {
          for (int j=0;j<i+1;j++) 
          {
            int g=i+j;
            if(g%7==0)//被7整除的数用＊代替
            {
              System.out.print("* ");
              continue;
            }
            else 
            { 
              System.out.print(g+" ");        
            }
          }
          System.out.println();
        }
      continue;
      }
      else if(a==2)
      {     
        for(int i=0;i<6;i++) 
        {
          for(int j=i;j<6;j++) 
          {
            System.out.print("-");  
          }  
          for(int j=0;j<i+1;j++) 
          {
            int h=i+j;
            if(h%3==0)//被3整除的数用＃代替
            {
              System.out.print("# ");
              continue;
            }
            else 
            {
              System.out.print(h+" ");
            }     
          }
          System.out.println();
        } 
        continue; 
      }
      else//a不是1或2 程序退出
      {
        break;
      }   
    }
  }
}