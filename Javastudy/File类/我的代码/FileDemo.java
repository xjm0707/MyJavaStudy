import java.io.File;
public class FileDemo{
	public static void main(String[] args) {
		//File既可以定义文件，也可以定义文件夹
		File file=new File("C:\\Users\\Administrator\\Desktop\\abc");//定义文件夹
		File f1=new File("C:\\Users\\Administrator\\Desktop\\abc\\abc.txt");//定义文件
		File f2=new File("C:\\Users\\Administrator\\Desktop\\abc\\def.txt");//定义文件

		file.mkdir();//创建文件夹
		try{//创建文件（需要捕获异常IOException）
			f1.createNewFile();
			f2.createNewFile();
		}catch (Exception e) {
			e.printStackTrace();
		}
		//删除
		//f.delete();
		//遍历
		String[] fileList=file.list();
		for (String s:fileList) {
			System.out.println(s);
		}
        //获取属性
		System.out.println("绝对路径"+f1.getAbsolutePath());
		System.out.println("路径"+f1.getPath());
		System.out.println("文件名"+f1.getName());
		System.out.println("父目录"+f1.getParent());

		//设置属性
		f1.setReadOnly();//将文件的权限设置为只读
        
        //判断
		System.out.println("是否是文件;"+f1.isFile());
		System.out.println("是否是目录;"+f1.isDirectory());

		//修改
		//将原来的文件移到新的目录下，还可以修改文件名
		f1.renameTo(new File("E:\\bcd.exe"));

		System.out.println(f1.toURI());
	}
}