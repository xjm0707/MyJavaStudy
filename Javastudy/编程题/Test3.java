import java.text.SimpleDateFormat;
public class Test3{
	public static void main(String [] args){
		String url="http://120.32.4.343:8080/login.jsp?name=yuann&&password=123456&&sex=men&&login=1470277690256";
		String [] cut1=url.split("jsp?");
		String [] cut2=cut1[1].split("&&");
		String [] nameMap=cut2[0].split("=");
		String name=nameMap[1];
		String [] loginMap=cut2[3].split("=");
		String  login=loginMap[1];
		Long time=Long.parseLong(login);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String timeStr=sdf.format(time);
		System.out.println("姓名："+name+"登录时间"+timeStr);
	}
}