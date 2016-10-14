import java.util.*;
import java.io.*;
/**
 * 复制文本文件到另一个地址，并将文本中的内容进行倒序写入
 * @author yn
 *
 */
public class CopyFileTest{
	public static void main(String[] args)throws IOException {
		copyFasle("E:/abc.txt","D:/abc.txt");
	}
	/**
	 * 用LinkedList实现文本倒序输出，并且拷贝到另一个文件
	 * @param srcPath 源文件地址
	 * @param destPath 目标文件地址
	 */
	public static void copyFasle(String srcPath, String destPath) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(srcPath));
			bw = new BufferedWriter(new FileWriter(destPath));

			LinkedList<String> l = new LinkedList<String>();
			String str = "";
			while ((str = br.readLine()) != null) {
				l.addFirst(str);// 先进后出
				System.out.println(str);
			}

			Iterator<String> it = l.iterator();
			while (it.hasNext()) {
				String s = it.next();
				System.out.println(s);
				bw.write(s);// 写入
				bw.newLine();// 换行
				bw.flush();// 刷新
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 使用数组的方式实现倒序输出文本，并且拷贝到另一个文件，但是数组的长度被限定了，存在局限
	 * @param srcPath 源文件地址
	 * @param destPath 目标文件地址
	 */
	public static void copy(String srcPath, String destPath) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			fr = new FileReader(srcPath);
			br = new BufferedReader(fr);
			String[] str = new String[100];
			String str1;
			int i = 0;
			while ((str1 = br.readLine()) != null) {
				str[i] = str1;
				i++;
			}
			fw = new FileWriter(destPath);
			bw = new BufferedWriter(fw);
			for (i--; i >= 0; i--) {
				bw.write(str[i]);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e) {

			}
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}