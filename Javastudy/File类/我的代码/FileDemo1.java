/**
*用递归的思想删除文件夹
*/
import java.io.File;
public class FileDemo1{
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Administrator\\Desktop\\abc");

		boolean b=deletDir(file);
		System.out.println(b);
	}
	public static boolean deletDir(File dir){
		if (dir.isDirectory()) {//判断是否是一个目录
			File[] list=dir.listFiles();
			for (int i=0;i<list.length;i++) {
				if (list[i].isFile()) {
					list[i].delete();//遍历删除文件
				}else{
					deletDir(list[i]);//调用自己
				}
			}
		}
		return dir.delete();
	}
}