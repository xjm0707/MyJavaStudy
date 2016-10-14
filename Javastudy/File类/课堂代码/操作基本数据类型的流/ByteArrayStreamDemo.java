import java.io.*;

/**
 * 使用ByteArrayInputStream和ByteArrayOutputStream实现内存到内存的数据处理
 * 
 * @author yn
 * 
 */
public class ByteArrayStreamDemo {
	public static void main(String[] args) throws IOException {
		// ByteArrayInputStream将数据从数据源中读入
		ByteArrayInputStream bais = new ByteArrayInputStream("qwe".getBytes());
		int len = 0;
		while ((len = bais.read()) != -1) {
			System.out.println((char) len);
		}

		// ByteArrayOutputStream将数据写入内存中
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// 内存中就有了一个字节数组
		baos.write('q');// 写一个字节
		byte[] buf = "qwer".getBytes();// 写多个字节
		baos.write(buf, 0, buf.length);// 将buf这个字节数组中的内容写到内存中去（就是ByteArrayOutputStream中的缓冲区）

		// 从内存中获取数据
		String str = baos.toString();// 获取内存中的数据，返回字符串的形式
		System.out.println(str);
		byte[] b = baos.toByteArray();// 获取内存中的数据，返回字节数组的形式
		System.out.println(new String(b));
		baos.writeTo(new FileOutputStream("E:/a.txt"));// 将内存数据写入到文件中
	}

	/**
	 * 通过ByteArrayInputStream和ByteArrayOutputStream将字节数组写入缓冲区
	 * 
	 * @param resource
	 *            数据源是字节数组
	 * @throws IOException
	 *             抛出IO异常
	 */
	public static void copyStream(byte[] resource) throws IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(resource);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] b = new byte[2];
		int len = 0;
		while ((len = bais.read(b)) != -1) {
			System.out.println(new String(b));
			baos.write(b, 0, len);
		}
		System.out.println(baos.toString());
	}
}