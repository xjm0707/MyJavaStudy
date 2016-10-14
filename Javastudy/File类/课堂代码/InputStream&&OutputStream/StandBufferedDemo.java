import java.io.*;

/**
 * 1、通过BufferedInputStream和BufferedOutputStream来提高文件复制的效率
 * 2、使用BufferedInputStream和BufferedOutputStream的标准写法
 */
public class StandBufferedDemo {
	public static void main(String[] args) {
		// BufferedInputStream和BufferedOutputStream其实只是将InputStream和OutputStream装饰了一下，让这俩个流对象拥有了缓冲的功能
		// 实际操作文件的还是InputStream和OutputStream两个流对象
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream("E:/a.txt");
			fos = new FileOutputStream("D:/a.txt");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[1024];// 1024 byte =1kb
			int len = 0;
			while ((len = bis.read(b)) != -1) {
				bos.write(b,0,len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {// 若文件不存在，fis=null,调用close()会报空指针异常，所以这里要进行非空的判断
					bis.close();// 只要关闭BufferedInputStream，里面的FileInputStream也会被关闭
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (fos != null) {// 若文件不存在，foss=null,调用close()会报空指针异常，所以这里要进行非空的判断
					bos.close();// 只要关闭BufferedOutputStream，里面的FileOutputStream也会被关闭
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}