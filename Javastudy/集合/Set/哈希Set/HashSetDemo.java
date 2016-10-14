import java.util.HashSet;
import java.util.Iterator;
public class HashSetDemo{
	public static void main(String[] args) {
		HashSet hs=new HashSet();//最外面的一层文件夹
		
        HashSet subHs1=new HashSet();//里面的文件夹1
		subHs1.add(new MyFile("01","MP3"));
		subHs1.add(new MyFile("02","avi"));
		subHs1.add(new MyFile("03","txt"));
		subHs1.add(new MyFile("04","exe"));
		subHs1.add(new MyFile("04","exe"));
		hs.add(subHs1);

		HashSet subHs2=new HashSet();//里面的文件夹2
		subHs2.add(new MyFile("01","MP3"));
		subHs2.add(new MyFile("02","avi"));
		subHs2.add(new MyFile("03","txt"));
		hs.add(subHs2);

		HashSet subHs3=new HashSet();//文件夹2里面的文件夹3
		subHs3.add(new MyFile("01","MP3"));
		subHs3.add(new MyFile("02","avi"));
		subHs3.add(new MyFile("03","txt"));
		subHs3.add(new MyFile("03","txt"));
		hs.add(subHs3);
		
		System.out.println(hs);

		//用迭代器取出文件夹内所有文件
		Iterator it=hs.iterator();
		while(it.hasNext()){//循环外层文件夹
			HashSet h=(HashSet)it.next();
			Iterator it1=h.iterator();
			while(it1.hasNext()){//循环内层文件夹
	            System.out.println(it1.next());
			}
		}

	}
}
class MyFile{
	String name;
	String suffix;
	public MyFile(String name,String suffix){
		this.name=name;
		this.suffix=suffix;
	}
	public String toString(){
		return "("+name+"."+suffix+")";
	}
	//如果hashCode返回值一样，再调用equals方法
	public boolean equals(Object o){
		MyFile mf=(MyFile)o;
		if (this.name.equals(mf.name)&&this.suffix.equals(mf.suffix)) {
			return true;
		}
		return false;
	}
	public int hashCode(){
		return name.hashCode()+suffix.hashCode();
	}
}