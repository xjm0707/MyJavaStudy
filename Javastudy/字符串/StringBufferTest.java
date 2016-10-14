
public class StringBufferTest{
	public static void main(String[] args) {		
		String str1="b";
		String str2=str+str1;
		String str3=str+str1+str2;
		System.out.println(str3);//abab

		StringBuffer sb=new StringBuffer("i am a");//初始化一个StringBuffer,并设置了初始值
		sb.append(" student");//在原来的初始值的基础上添加字符串

		sb.insert(2,"safd");//在2的位置上插入一个b，插入的位置要注意是否会字符串下标越界

		sb.delete(1,3);//删除从下标1开始到下标2的字符

		sb.reverse();//反序
		System.out.println(sb.toString());//打印字符串
	}
}