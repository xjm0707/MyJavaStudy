import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class NewsClient{
	public static void main(String[] args) {
		ArrayList<Cirtle> armyList=new ArrayList<Cirtle>();
		armyList.add(new Cirtle("armyNews1",2540));
		armyList.add(new Cirtle("armyNews2",5580));
		armyList.add(new Cirtle("armyNews3",930));

		ArrayList<Cirtle> funList=new ArrayList<Cirtle>();
		funList.add(new Cirtle("funNews1",3650));
		funList.add(new Cirtle("funNews2",8620));
		funList.add(new Cirtle("funNews3",260));

		ArrayList<Cirtle> sportList=new ArrayList<Cirtle>();
		sportList.add(new Cirtle("sportNews1",2680));
		sportList.add(new Cirtle("sportNews2",580));
		sportList.add(new Cirtle("sportNews3",4930));

		HashMap<String,ArrayList<Cirtle>> newsMap=new HashMap<String,ArrayList<Cirtle>>();
		newsMap.put("军事",armyList);
		newsMap.put("娱乐",funList);
		newsMap.put("体育",sportList);

		/*System.out.println(newsMap);*/

		//通过entrySet（）方法进行迭代
		Set<Map.Entry<String,ArrayList<Cirtle>>> set=newsMap.entrySet();
		for(Iterator<Map.Entry<String,ArrayList<Cirtle>>> it=set.iterator();it.hasNext();){
			Map.Entry<String,ArrayList<Cirtle>> entry=it.next();
			System.out.println(entry.getKey());
			for(Iterator<Cirtle> it1=entry.getValue().iterator();it1.hasNext();){
				System.out.println(it1.next());
			}
		}
	}
}
/**
*新闻类
*/
class Cirtle{
	private String name;
	private int num;
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
		return "("+name+"--"+num+")";
	}
}