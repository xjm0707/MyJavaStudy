import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;
public class TreeSetTest{
	public static void main(String[] args) {
		TreeSet ts=new TreeSet(new Comparator(){
			public int compare(Object o1,Object o2){
				int [] dateArray1=subDate((String)o1);
				int [] dateArray2=subDate((String)o2);
				if(dateArray1[0]>dateArray2[0]){
					return -1;
				}
				if(dateArray1[0]==dateArray2[0]&&dateArray1[1]>dateArray2[1]){
					return -1;
				}
				if(dateArray1[0]==dateArray2[0]&&dateArray1[1]==dateArray2[1]&&dateArray1[2]>dateArray2[2]){
					return -1;
				}
				if(dateArray1[0]==dateArray2[0]&&dateArray1[1]==dateArray2[1]&&dateArray1[2]==dateArray2[2]){
					return 0;
				}
				return 1;
			}
		});
		ts.add("05月18日2016年");
		ts.add("08月20日2016年");
		ts.add("08月19日2016年");
		ts.add("03月03日2015年");
		ts.add("04月29日2014年");
		ts.add("08月01日2010年");
		ts.add("07月16日2013年");
		ts.add("12月19日2012年");
		ts.add("01月18日2016年");
		System.out.println(ts);
		for(Iterator it=ts.iterator();it.hasNext();){
			System.out.println(it.next());
		}

		
	}
	private static int [] subDate(String s){
		int [] dateArray=new int [3];
		int month=Integer.parseInt(s.substring(0,2));
		int day=Integer.parseInt(s.substring(3,5));
		int year=Integer.parseInt(s.substring(6,10));
		dateArray[0]=year;
		dateArray[1]=month;
		dateArray[2]=day;
		return dateArray;
	}
}