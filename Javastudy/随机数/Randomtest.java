import java.util.Random;
import java.util.Scanner;
public class Randomtest{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Random ran=new Random();
		while(true) 
		{	
			int a=input.nextInt();
			int b=ran.nextInt(10)+1;
			if(a==b) 
			{
				System.out.println("恭喜中奖");
			}
			else{
				System.out.println("再来一次");
			}
		}
        
	}
}