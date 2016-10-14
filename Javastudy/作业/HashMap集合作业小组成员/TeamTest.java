/*import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;*/
import java.util.*;
public class TeamTest{
	public static void main(String[] args) {
        //创建一个HashMap集合，其中键（key）为项目经理，值（value）为小组成员
		HashMap hm=new HashMap();
        //创建一个HashSet集合，将小组成员传入其中
		HashSet hs1=new HashSet();
		hs1.add(new Members("徐江民"));  
		hs1.add(new Members("李继鑫"));  
		hs1.add(new Members("倪刚强")); 
		
		HashSet hs2=new HashSet();
		hs2.add(new Members("蜘蛛侠"));  
		hs2.add(new Members("黑寡妇"));   
		hs2.add(new Members("幻视")); 

		HashSet hs3=new HashSet();
		hs3.add(new Members("冬兵"));  
		hs3.add(new Members("蚁人"));  
		hs3.add(new Members("猩红女巫"));
        
        hm.put(new Leader("丁建文"),hs1);
		hm.put(new Leader("钢铁侠"),hs2);
		hm.put(new Leader("美国队长"),hs3);

		System.out.println(hm);
        
        //使用keySet方式进行元素的迭代
		Set s=hm.keySet();
		Iterator it=s.iterator();
		while(it.hasNext()){
			Leader l=(Leader)it.next();//获取键（项目经理）
			System.out.println("---------------");			
			System.out.println("项目经理:"+l);//输出经理			
			HashSet m=(HashSet)hm.get(l);//通过键获取值（小组成员的集合）
			//继续将小组成员的集合进行迭代
			Iterator it1=m.iterator();
			while(it1.hasNext()){
				TeamMember w=(TeamMember)it1.next();
				System.out.println("成员:"+w);//输出成员
			}
		}
        
	}
}
class TeamMember{
    String name;
    public TeamMember(String name){
    	this.name=name;
    }
    public String toString(){
    	return name;
    }
    public boolean equals(Object o){//重写HashSet的equals方法去重
		TeamMember tm=(TeamMember)o;
		if (this.name.equals(tm.name)) {
			return true;
		}
		return false;
	}
	public int hashCode(){//重写哈西代码去重
		return name.hashCode();
	}

}
class Leader extends TeamMember{
	public Leader(String name){
		super(name);
	}
}
class Members extends TeamMember{
	public Members(String name){
		super(name);
	}
}
