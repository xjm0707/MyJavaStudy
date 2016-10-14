import java.io.*;
/**
 * 使用FilenameFilter来筛选出指定文件
 * @author yn
 *
 */
public class FilenameFilterDemo{
	public static void main(String[] args) {
		File f=new File("E:\\abc");
		//通过FilenameFilter来筛选出指定目录和名称的文件
		String[] list=f.list(new FilenameFilter(){
			public boolean accept(File dir,String name){
				//这里面的判断根据需求来写
				if(dir.getPath().contains("E:\\abc")){
					if(name.equals("cde")){
						return true;
					}
					return false;
				}
				return false;
			}
		});
		//增强for循环使用范围为：数组、Collection接口的集合 List Set
		//Map不可以用增强for循环
		for (String path:list ) {
			System.out.println(path);
		}
	}
}
