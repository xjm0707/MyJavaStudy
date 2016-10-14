import java.io.*;
/*
对比两个文本文件的内容，将每行文字内容不相同的位置找出来，并保存的另一个文本中（行号、不相同的文字是哪两个）例如：
行号  原  新
      3	  我  你
注:对于行号，可以使用LineNumberReader，请查看jdk文档，也可以使用已学过的计数器来实现。
a)文件的读取没有问题 4
b)文本中有行号，有不相同的内容进行对比 4
*/
class Test7{
	public static void main(String[] args) throws Exception{
		int hang=1;
		FileReader fr1=new FileReader("E:/a.txt");
		FileReader fr2=new FileReader("E:/b.txt");
		BufferedReader br1=new BufferedReader(fr1);
		BufferedReader br2=new BufferedReader(fr2);
		FileWriter fw=new FileWriter("E:/hij.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		String line1=null;
		String line2=null;
		while((line1=br1.readLine())!=null&&(line2=br2.readLine())!=null){
			bw.write("行号"+hang+++"  ");
			bw.newLine();
			bw.flush();
			for (int i=0;i<(line1.length()<line2.length()?line1.length():line2.length()) ;i++ ) {
				if(line1.charAt(i)!=line2.charAt(i)){
					bw.write(line1.charAt(i)+"  "+line2.charAt(i));
					bw.newLine();
					bw.flush();
				}
			}
		}
		fr1.close();
		fr2.close();
		fw.close();
	}
}