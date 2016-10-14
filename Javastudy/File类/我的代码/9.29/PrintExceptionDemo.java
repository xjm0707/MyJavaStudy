/**
*将异常信息保存到本地
*/
import java.io.*;
import java.util.Date;
public class PrintExceptionDemo{
	public static void main(String[] args) {
		try{
            int[] arr=new int[]{1,2};
            System.out.println(arr[3]);
            // int[] arr=null;
            // System.out.println(arr[0]);
		}catch(Exception e){
            PrintWriter pw=null;
            try{
               pw=new PrintWriter(new FileWriter("E:/abc.txt",true),true);//可以追加异常信息
               Date d=new Date();
               pw.println(d);
            }catch (Exception e1) {
            	System.out.println("创建异常文件失败");
            }
            System.out.println(e.getMessage()+",具体请查看异常日志文件");
            e.printStackTrace(pw);

		}
	}
}