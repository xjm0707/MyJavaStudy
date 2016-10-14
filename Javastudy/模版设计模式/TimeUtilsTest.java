public class TimeUtilsTest{
	public static void main(String[] args) {
		SubTimeUtils1 s1=new SubTimeUtils1();
		SubTimeUtils2 s2=new SubTimeUtils2();
		System.out.println(s1.getTime());
		System.out.println(s2.getTime());
	}
}

abstract class TimeUtils{
	long getTime(){
	    long l1=System.currentTimeMillis();
	    reduce();
	    long l2=System.currentTimeMillis();
	    return l2-l1;
	}
	abstract void reduce();
}

class SubTimeUtils1 extends TimeUtils{
	void reduce(){
		for (int i=0;i<10000;i++) {
			System.out.print("牛逼");		
		}

	}
}
class SubTimeUtils2 extends TimeUtils{
	void reduce(){
		int i=0;
		while(i<1000){	
			System.out.print("好人");
			i++;		
		}
	}
}