import java.io.*;
public class FileDemo2{
	public static void main(String[] args) {
		File f=new File("E:\\abc");
		//通过FilenameFilter来筛选出指定目录和名称的文件
		String[] list=f.list(new FilenameFilter(){
			public boolean accept(File dir,String name){
				if (dir.getPath().contains("E:\\abc")) {
					if (name.equals("cde")) {
						return true;
					}
					return false;
				}
				return false;
			}
		});
		//增强for循环
		for (String path:list) {
			System.out.println(path);
		}
	}
}