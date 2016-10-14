import java.io.*;
import java.util.Date;
/**
 * 使用PrintWrtier将异常信息保存为日志文件
 * @author yn
 *
 */
public class PrintExceptionTest{
	public static void main(String[] args) {
		//下面使用的是FileWriter
		try{
			//数组越界异常
			int[] arr=new int[]{1,2};
			System.out.println(arr[5]);
			//空指针异常
			/*String str=null;
			str.substring(1,2);*/
		}catch (Exception e) {			
			System.out.println(e.getMessage()+",具体异常信息请查看日志文件");
			e.printStackTrace(saveException("D:/exception.log",true));//将异常信息通过PrintWriter保存到本地
		}	
	}
	/**
	 * 构建一个带日期可以追加文本内的PrintWriter
	 * @param filePath 待保存的文本文件地址
	 * @param isAppend 内容是否追加
	 * @return PrintWriter
	 */
	public static PrintWriter saveException(String filePath,boolean isAppend){
		PrintWriter ps=null;
		try{
			//PrintWriter如果使用两个参数的构造函数，传入一个true，可以实现自动刷新
			//FileWriter的两个参数的构造函数，传入一个true，可以实现异常信息的追加
			ps=new PrintWriter(new FileWriter(filePath,isAppend),true);
			Date d=new Date();
			ps.println(d);//向日志中添加日期信息
			}catch (Exception e) {
				System.out.println("创建异常日志文件失败");
			}
		return ps;			
	}
}