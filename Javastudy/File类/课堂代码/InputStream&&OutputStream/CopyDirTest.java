package com.io.work;

import java.io.*;

/**
 * 1、拷贝指定目录下面的所有文件夹和文件到另一个目录下
 * 2、递归算法+文件拷贝
 */
public class CopyDirTest {
	public static void main(String[] args) throws IOException {
		copyDir(new File("E:\\abc"), new File("D:"));
	}

	/**
	 * 递归拷贝文件
	 * @param src 待拷贝的文件夹路径
	 * @param des 目标文件夹路径
	 * @throws IOException 抛出IO异常
	 */
	private static void copyDir(File src, File des) throws IOException {
		des.mkdir();
		if (src != null) {
			File[] files = src.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile()) {
						FileInputStream fis = new FileInputStream(file);
						FileOutputStream fos = new FileOutputStream(
								des.getAbsolutePath() + "\\" + file.getName());
						byte[] buf = new byte[1024];
						int len = 0;
						while ((len = fis.read(buf)) != -1) {
							fos.write(buf, 0, len);
						}
						fis.close();
						fos.close();
					} else {
						copyDir(file, new File(des.getAbsolutePath() + "\\"+ file.getName()));
					}
				}
			}
		}
	}
}
