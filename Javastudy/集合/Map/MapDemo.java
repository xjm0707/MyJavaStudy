import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
public class MapDemo{
	public static void main(String[] args) {
		HashMap hm=new HashMap();
		hm.put("key","velue");
		hm.put("钥匙2","锁2");
		hm.put("钥匙3","锁3");
		hm.put("钥匙4","锁4");

		Collection c=hm.values();
		Iterator it=c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}
}