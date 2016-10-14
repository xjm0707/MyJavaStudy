import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;
public class TreeSetDate{
	public static void main(String[] args) {
		TreeSet ts=new TreeSet(new MyComparator());
		ts.add(new DateAdd(2016,5,1));
		ts.add(new DateAdd(2013,8,20));
		ts.add(new DateAdd(2014,8,9));
		ts.add(new DateAdd(2013,4,20));
		ts.add(new DateAdd(2016,6,16));
		ts.add(new DateAdd(2011,5,6));
		ts.add(new DateAdd(2013,3,21));
		ts.add(new DateAdd(2010,12,20));
		ts.add(new DateAdd(2013,7,20));
		ts.add(new DateAdd(2016,12,16));

		for (Iterator it=ts.iterator();it.hasNext();) {
			System.out.println(it.next());
		}
	}
}
class DateAdd{
	int yearNum;
    int monthNum;
    int dayNum;
	public DateAdd(int yearNum,int monthNum,int dayNum){
		this.yearNum=yearNum;
		this.monthNum=monthNum;
		this.dayNum=dayNum;
	}
	public String toString(){	
		if (monthNum<10) {
			if (dayNum<10) {
				return "0"+monthNum+"月0"+dayNum+"日"+yearNum+"年";
			}
			return "0"+monthNum+"月"+dayNum+"日"+yearNum+"年";
		}
		return monthNum+"月"+dayNum+"日"+yearNum+"年";
		
	}
}
class MyComparator implements Comparator{
	public int compare(Object o1,Object o2){
		DateAdd da1=(DateAdd)o1;
		DateAdd da2=(DateAdd)o2;
		//判断年份日期的大小 按日期的大小从大到小排序
		if (da1.yearNum==da2.yearNum) {
            if (da1.monthNum==da2.monthNum) {
            	if (da1.dayNum==da2.dayNum) {
            		return 0;
            	}
            	if (da1.dayNum<da2.dayNum) {
            		return 1;
            	}
            	return -1;
            }
            if (da1.monthNum<da2.monthNum) {
            	return 1;
            }
            return -1;
		}
		if (da1.yearNum<da2.yearNum) {
			return 1;
		}
		return -1;
	}
}