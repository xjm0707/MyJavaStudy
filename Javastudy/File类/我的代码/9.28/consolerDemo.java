import java.util.Scanner;
import java.io.*;
public class consolerDemo{
	public static void main(String[] args) {
		InputStream in=System.in;
		Scanner scan=new Scanner(System.in);
		while(true){
			String s=scan.next();
			System.out.println(s);
		}
		
	}
}