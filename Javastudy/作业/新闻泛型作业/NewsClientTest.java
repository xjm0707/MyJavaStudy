/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;*/
import java.util.*;
public class NewsClientTest{
	public static void main(String[] args) {
		
		HashMap<String,ArrayList<Cirtle>> hm=new HashMap<String,ArrayList<Cirtle>>();
		
		ArrayList<Cirtle> al1=new ArrayList<Cirtle>();
		al1.add(new Cirtle("朝鲜军事",23));
		al1.add(new Cirtle("美国军事",10));
		al1.add(new Cirtle("中国军事",45));

		ArrayList<Cirtle> al2=new ArrayList<Cirtle>();
		al2.add(new Cirtle("韩国娱乐",10));
		al2.add(new Cirtle("印度娱乐",30));
		al2.add(new Cirtle("日本娱乐",50));

		ArrayList<Cirtle> al3=new ArrayList<Cirtle>();
		al3.add(new Cirtle("奥运会",30));
		al3.add(new Cirtle("世界杯",500));
		al3.add(new Cirtle("亚运会",55));

		hm.put("军事",al1);
		hm.put("娱乐",al2);
		hm.put("体育",al3);

		Set<String> s=hm.keySet();
		Iterator<String> it=s.iterator();
		while(it.hasNext()){
			String l=it.next();
			System.out.println("---------------");			
			System.out.println("新闻热点："+l);			
			ArrayList<Cirtle> m=hm.get(l);
			Iterator<Cirtle> it1=m.iterator();
			while(it1.hasNext()){
				Cirtle w=it1.next();
				System.out.println(w);
			}
		}
	}
}
class Cirtle{
	String name;
	int num;
	public Cirtle(String name,int num){
		this.name=name;
		this.num=num;
	}
	public boolean equals(Object o){
		Cirtle c=(Cirtle)o;
		if(this.name.equals(c.name)&&this.num==c.num){
			return true;
		}
		return false;
	}
	public String toString(){
		return "文章标题："+name+"  点赞数："+num;
	}
}