public class Post{
	public static void main(String[] args) {
		String[] postStamp={"20160201","20160412","20160529","20160720","20160802"};
		int[] zan={12,44,78,135,23};
		String url="http://120.32.4.343:8080/login.jsp?name=yuann&&password=123456&&sex=men&&login=1472470146136";
		// long currentTime=System.currentTimeMillis();			//获取当前毫秒值
		// System.out.println(currentTime);
		PostTools message=new PostTools(url);
		message.print();
		message.screen(postStamp,zan);
	}
}