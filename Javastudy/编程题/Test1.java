import java.util.Scanner;
public class Test1{
	public static void main(String[] args) {
		boolean aa = true ;  //用来判断用户输入的是否为数字
		char [] arr = new char [1024] ;
		Scanner a = new Scanner (System.in) ;
		String one = "" ;
		w:while(true){
			System.out.println("请输入第一个数字：");
			one = a.next () ;
			arr = one.toCharArray() ;
			for (char c : arr) {
				if(!(c>='0'&&c<='9')){
					System.out.println("不是数字，请重新输入!");
					continue w;
				}
			}
			break;
		}
		String two = "" ;
		w1:while(true){
			System.out.println("请输入第二个数字：");
			two = a.next () ;
			arr = two.toCharArray() ;
			for (char c : arr) {
				if(!(c>='0'&&c<='9')){
					System.out.println("不是数字，请重新输入!");
					continue w1;
				}
			}
			break;
		}	
		System.out.println("String："+add(one,two));//拼接

		int i1 = Integer.parseInt(one);  //把String转成int类型
		int i2 = Integer.parseInt(two);
		System.out.println("int："+add(i1,i2));  //int 类型相加

		float ii1 = Float.parseFloat(one);  //把String转成float
		float ii2 = Float.parseFloat(two);
		System.out.println("float："+add(ii1,ii2));
	}
	public static String add(String one, String two){   //拼接
		return one+two ; 
	}

	public static int add(int one, int two){   //整数相加
		return one+two ; 
	}
	public static float add(float one , float two){   //小数相加
		return one+two; 
	}
}