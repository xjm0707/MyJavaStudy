import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Date;
public class MyProperties{
	public Map<String,String> mapping;
	//读取文件中的键值对，并保存到Map容器中
	public void load(InputStream is)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		mapping=new HashMap<String,String>();
		String line=null;
		while((line=br.readLine())!=null){
			if(line.contains("=")){
				String [] keyValues=line.split("=");
				mapping.put(keyValues[0],keyValues[1]);
			}
		}
		br.close();
	}
	//从Map容器中根据键取出值
	public String getProperty(String key){
		return mapping.get(key);
	}
	//从Map容器中根据键取出值，如果不存在该键，则存入指定值的键值对
	public String getProperty(String key,String defaultValue){
		String value=null;
		if((value=mapping.get(key))==null){
			mapping.put(key,defaultValue);
			return defaultValue;
		}
		return mapping.get(key);
	}
	//更改指定键对应的值
	public String setProperty(String key,String value){
		return mapping.put(key,value);
	}
	//将Map容器中的信息写入指定的输入流中	
	public void store(OutputStream ops,String comments)throws IOException{
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(ops));
		bw.write("#"+comments);
		bw.newLine();
		bw.write("#"+new Date().toString());
		bw.newLine();
		Set<Entry<String, String>> entrys = mapping.entrySet();
		for(Entry<String,String> entry:entrys){
			bw.write(entry.getKey()+"="+entry.getValue());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	//测试方法，测试了load，get，set，和store方法
	public static void main(String[] args) throws IOException{
		File f=new File("e:/software1.config");
		MyProperties mp=new MyProperties();
		if(!f.exists()){
			f.createNewFile();
		}
		mp.load(new FileInputStream(f));
		String aaa=null;
		aaa=mp.getProperty("aaa");
		mp.setProperty("aaa","358");
		System.out.println(aaa);
		System.out.println(mp.mapping);
		mp.store(new FileOutputStream("e:/software1.config"),"");

	}
}
