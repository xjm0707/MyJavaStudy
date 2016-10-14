import java.io.File;
/**
 * File类的使用
 * @author yn
 *
 */
public class FileDemo{
	public static void main(String[] args) {
		File file=new File("E:\\abc");//定义文件夹
		boolean b=deleteDir(file);
		System.out.println(b);
	}

	/**
	 * 递归删除文件夹及其子文件
	 * @param dir 待删除的文件夹
	 * @return 返回是否删除成功
	 */
	public static boolean deleteDir(File dir){
		if(dir.isDirectory()){
			File[] list=dir.listFiles();//File数组中可能存的是文件或者文件夹
			for(int i=0;i<list.length;i++){
				if(list[i].isFile()){//判断是否是文件
					list[i].delete();//删除
				}else{
					deleteDir(list[i]);//继续调用自己，重写判断是否时候文件夹
				}
			}
		}
		return dir.delete();
	}
}