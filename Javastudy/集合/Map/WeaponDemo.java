/*import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;*/
import java.util.*;
public class WeaponDemo{
	public static void main(String[] args) {
		//武器库
		HashMap hm=new HashMap();
		//武器1集合
		TreeSet ts1=new TreeSet();
		ts1.add(new Sword("倚天剑",100));  
		ts1.add(new Sword("鼻血剑",80));  
		ts1.add(new Sword("寒冰剑",90)); 
        //武器2集合
		TreeSet ts2=new TreeSet();
		ts2.add(new Knife("屠龙刀",70));  
		ts2.add(new Knife("杀猪刀",100));  
		ts2.add(new Knife("偃月刀",60)); 
        //将两个武器集合放到武器库中
		hm.put("剑",ts1);
		hm.put("刀",ts2);
        
        //使用keySet方式进行元素的迭代
		Set s=hm.keySet();
		Iterator it=s.iterator();
		while(it.hasNext()){
			String key=(String)it.next();//获取键
			TreeSet t=(TreeSet)hm.get(key);//通过键获取值
            //对TreeSet集合进行元素的迭代
			Iterator it1=t.iterator();
			while(it1.hasNext()){
				Weapon w=(Weapon)it1.next();
				System.out.println(w);
			}
		}
		
		System.out.println("---------------------------");
		
		//使用entrySet方式进行元素的迭代
		Set e=hm.entrySet();
		Iterator it2=e.iterator();
		while(it2.hasNext()){
			Map.Entry em=(Map.Entry)it2.next();
			String key=(String)em.getKey();
			TreeSet value=(TreeSet)em.getValue();
			Iterator it3=value.iterator();
			while(it3.hasNext()){
				Weapon w=(Weapon)it3.next();
				System.out.println(w);
			} 
		}
	}
}
class Weapon implements Comparable{
    String name;
    int hurt;
    public Weapon(String name,int hurt){
    	this.name=name;
    	this.hurt=hurt;
    }
    public String toString(){
    	return "("+name+","+hurt+")";
    }
    public int compareTo(Object o){
    	Weapon w=(Weapon)o;
    	if (this.hurt<w.hurt) {
    		return -1;
    	}
    	if (this.hurt==w.hurt) {
    		return this.name.compareTo(w.name);
    	}
    	return 1;
    }
}
class Sword extends Weapon{
	public Sword(String name,int hurt){
		super(name,hurt);
	}
}
class Knife extends Weapon{
	public Knife(String name,int hurt){
		super(name,hurt);
	}
}
