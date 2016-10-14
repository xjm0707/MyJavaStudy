import java.io.*;

/**
 * 读取字符串并替代特定的字符串
 */
public class StringReplaceTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("E:/abc.txt");
		byte[] b = new byte[fis.available()];
		int len = 0;
		String str = "";
		while ((len = fis.read(b)) != -1) {
			str = new String(b, 0, len);
			if (str.contains("视频")) {
				str = str.replaceAll("视频", "@*");
			}
			System.out.println(str);
		}
		fis.close();
	}
}