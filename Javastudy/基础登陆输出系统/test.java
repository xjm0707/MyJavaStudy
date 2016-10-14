import java.util.Scanner;
public class test{
  public static void main(String[] args) {
  	System.out.print("输入你的年龄：");
  	Scanner input=new Scanner(System.in);
    int age=input.nextInt();
 if(age>=18){
    	if(age>=30){
    		System.out.print("你已经老了！");
    	}
    	else{System.out.print("你已经成年了！");
    	}
    }
    else{
    	System.out.print("你还未成年呢！");
    }
  }
}