import java.io.*;
public class DataStreamDemo{
	public static void main(String[] args)throws IOException {
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("E:/a.txt"));
		dos.writeInt(123456);
		DataInputStream dis=new DataInputStream(new FileInputStream("E:/a.txt"));
		int i=dis.readInt();
		System.out.println(i);
	}
}