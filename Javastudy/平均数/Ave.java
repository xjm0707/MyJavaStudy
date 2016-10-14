import java.util.Scanner;
public class Ave{//求累加的平均值
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int sum=0;
		int j=0;
        while(j<5){
        	int a=input.nextInt();
        	sum=sum+a;
        	j++;
        }
        int ave=sum/j;
        System.out.println(ave);
        System.out.println(sum);
	}
}