/**
 * 适配器设计模式，调用者可以不改变原有的代码，使用新功能
 * @author yn
 *
 */
public class AdapterDemo{
	public static void main(String[] args) {
		/*GTwoChaZuo gcz=new GTwoChaZuo();
		Hotel h=new Hotel(gcz);
		h.useChazuo();*/


		GThreeChaZuo gtc=new GThreeChaZuo();
		CaoZuoAdapter adapter=new CaoZuoAdapter();

		adapter.setThree(gtc);
		Hotel h=new Hotel(adapter);
		h.useChazuo();
	}
}
interface ITwo{
	void useTwo();
}
interface IThree{
	void useThree();
}

class GTwoChaZuo implements ITwo{
	public void useTwo(){
		System.out.println("使用国产两相插座");
	} 
}

class GThreeChaZuo implements IThree{
	public void useThree(){
		System.out.println("使用国产三相插座");
	}
}

//让适配器同时实现多个接口
class CaoZuoAdapter implements ITwo,IThree{
	IThree t;
	public CaoZuoAdapter(IThree t){
		this.t=t;
	}
	public CaoZuoAdapter(){
	}
	public void setThree(IThree t){
		this.t=t;
	}
	//一个接口中调用另一个接口的方法，调用者不用改变原来的代码，就可以使用新的功能。
	public void useTwo(){
		System.out.println("插入两相的插座");
		useThree();
	}	
	public void useThree(){
		t.useThree();
	}
}

//旅店
class Hotel{
	ITwo chazuo;
	//只能接受实现了两相插头规则的插头
	public Hotel(ITwo chazuo){
		this.chazuo=chazuo;
	}
	//只能使用两相的插头
	public void useChazuo(){
		chazuo.useTwo();
	}
}