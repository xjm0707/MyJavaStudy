import java.io.*;

/**
 * 使用带缓冲功能的字符流BufferedReader和BufferedWriter读写文件
 * 
 * @author yn
 * 
 */
public class BufferedDemo {
	public static void main(String[] args) throws IOException {
		// BufferedReader可以读取一整行数据
		BufferedReader br = new BufferedReader(new FileReader("E:/abc.txt"));

		/*
		 * 下面的代码可以将文本的数据一行一行的读取出来 若没有数据，readLine返回是null，所以可以通过null来判断是否读取完毕
		 */
		String str = "";
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();

		// BufferedWriter写数据到文件中
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:/b.txt"));
		char[] c = new char[] { 'a', 'b', 'c', '我' };
		bw.write(c, 0, c.length);
		bw.newLine();// 其实是写入一个\r\n
		bw.write("你好", 0, 2);
		// bw.flush();//带有缓冲区的流都必须刷新才能将数据写出
		bw.close();// 如果调用了close()可以不用flush()
	}
}