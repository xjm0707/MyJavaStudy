public class InstrumentTest{
	public static void main(String[] args) {
		Instrument a=new Piano();
		Instrument b=new Violin();
		test(a);
		test(b);

	}
	public static void test(Instrument c){//多态可用数组 类 接口 进行接收
        c.play();
	}
}

abstract class Instrument{
	abstract void play();
}

class Piano extends Instrument{
	void play(){
		System.out.println("弹奏钢琴");
	}
}

class Violin extends Instrument{
	void play(){
		System.out.println("拉小提琴");
	}
}