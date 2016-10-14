import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
public class HashMapKeySetDemo{
	public static void main(String[] args) {
		HashMap hm=new HashMap();
		hm.put(1,new Game("DOTA","MOBA"));
		hm.put(2,new Game("CS","FTS"));
		hm.put(3,new Game("魔兽世界","MMO"));
		hm.put(4,new Game("GTA5","ARPG"));
		hm.put(5,new Game("战神4","ACT"));
        //keySet()  取出所有键（钥匙key）放到Set集合中
		Set s=hm.keySet();
		Iterator it=s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		System.out.println("------------------------------");

        //values()  取出所有值（锁value）放到Collection集合中
		Collection c=hm.values();
		Iterator it1=c.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}

		System.out.println("------------------------------");
        
        //entrySet可以将键和值整对的取出来，放到Set集合中
		Set s1=hm.entrySet();
		Iterator it2=s1.iterator();
		while(it2.hasNext()){
			Map.Entry em=(Map.Entry)it2.next();
			//从键值对关系中获取键
			Integer key=(Integer)em.getKey();
            //从键值对关系中获取值
            Game value=(Game)em.getValue(); 
            System.out.println(key+","+value);
		}
	}
}
class Game{
	String name;
	String type;
	public Game(String name,String type){
        this.name=name;
        this.type=type;
	}
	public String toString(){
		return "("+name+","+type+")";
	}
}