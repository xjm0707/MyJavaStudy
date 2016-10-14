import java.io.*;
/*
将指定文件夹下面的所有txt文件筛选出来，并且将内容合并到同一个文件中，注意编码转换的问题。
*/
public class Test6{
	public static void main(String[] args)throws IOException {
		File file=new File("d:");
		File [] files=file.listFiles(new FilenameFilter(){
			public boolean accept(File dir,String name){
				return name.endsWith(".txt");
			}
		});
		copy5(files,"D:/a.txt","utf-8");
	}
	/*
	文件合并
	*/
	public static void copy5(File[] fileArr,String destPath,String charsetOut)throws IOException{
		FileOutputStream fos=new FileOutputStream(destPath);
		OutputStreamWriter osw=new OutputStreamWriter(fos,charsetOut);//将字符流转成字节流

		FileInputStream fis=null;
		InputStreamReader isr=null;//将字节流转成字符流
		for (File file : fileArr) {
			fis=new FileInputStream(file.getAbsolutePath());
			isr=new InputStreamReader(fis,getCharSet(file.getAbsolutePath()));
			char[] ch=new char[1];
			int len=0;
			while((len=isr.read(ch))!=-1){
				System.out.println(new String(ch,0,len));//utf-8--->gbk  你好-->浣犲ソ
				osw.write(ch,0,len);
			}
			fis.close();
			isr.close();
		}											
		osw.close();
	}
	//下面两个方法都可以判断文件编码格式的，只能是用记事本保存的utf-8文本才可以使用，sublime不行
	public static String getCharCode(String fileName) throws IOException{
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));    
		int p = (bin.read() << 8) + bin.read();    

		String code = null;    

		switch (p) {    
			case 0xefbb:    
			code = "UTF-8";    
			break;    
			case 0xfffe:    
			code = "Unicode";    
			break;    
			case 0xfeff:    
			code = "UTF-16BE";    
			break;    
			default:    
			code = "GBK";    
		}    
		return code;  
	}
	//对于UTF-8编码格式的文本文件，其前3个字节的值就是-17、-69、-65
	public static String getCharSet(String path) throws IOException{
		File file = new File(path);
		InputStream in= new FileInputStream(file);
		byte[] b = new byte[3];
		in.read(b);
		in.close();
		if (b[0] == -17 && b[1] == -69 && b[2] == -65){
			return "utf-8";           
		}
		else{
			return "gbk";
		}
	}

}