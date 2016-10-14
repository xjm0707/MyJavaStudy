import java.io.*;
import java.util.*;
public class SoftwareConfigDemo{
	public static void main(String[] args)throws IOException{
		HashMap<String,String> hs=new HashMap<String,String>();
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:/Software.config"),"GBK"));
		String line="";
		String[] arr=null;
		while((line=br.readLine())!=null){
			if(line!=""){
				if (line.contains("#")) {
					continue;
				}
				arr=line.split("=");
				hs.put(arr[0],arr[1]);			
			}
		}
		br.close();
		System.out.println(hs);
	}
}