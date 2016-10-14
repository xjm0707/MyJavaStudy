import java.io.*;

/**
 * IO流读写文件标准写法： 
 * 1、定义一个流对象
 * 2、定义好try catch和finally 
 * 3、开始读写数据 
 * 4、关闭流对象
 */
public class CopyFileDemo {
	public static void main(String[] args) {
		copyFile("E:\\c.txt", "D:\\def.txt");
	}

	/**
	 * 普通方式拷贝文件
	 * 
	 * @param scrPath
	 *            源文件路径
	 * @param destPath
	 *            目标文件路程
	 */
	public static void copyFile(String srcPath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(srcPath);
			fos = new FileOutputStream(destPath);

			byte[] b = new byte[1024];// 1024 byte =1kb
			int len = 0;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 带有缓冲区的拷贝文件
	 * 
	 * @param scrPath
	 *            源文件路径
	 * @param destPath
	 *            目标文件路程
	 */
	public static void copy2(String srcPath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(srcPath);
			fos = new FileOutputStream(destPath);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[1024];// 1024 byte =1kb
			int len = 0;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					bis.close();// 只要关闭BufferedInputStream，里面的FileInputStream也会被关闭
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (fos != null) {
					bos.close();// 只要关闭BufferedOutputStream，里面的FileOutputStream也会被关闭
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}