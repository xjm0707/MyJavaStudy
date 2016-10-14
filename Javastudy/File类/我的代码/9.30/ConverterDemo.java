public class ConverterDemo{
	public static void main(String[] args) {
		ThreeChazuo t=new ThreeChazuo();
		Adapter a=new Adapter(t);

        a.setThree(t);
		Hotel h=new Hotel(a);
		h.useChazuo();
	}
}
interface ITwo{
	void useTwo();
}
interface IThree{
	void useThree();
}
class TwoChazuo implements ITwo{
    public void useTwo(){
    	System.out.println("使用两相插座");
    }
}
class ThreeChazuo implements IThree{
	public void useThree(){
		System.out.println("使用三相插座");
	}
}
class Adapter implements ITwo,IThree{
	IThree t;
	public Adapter(){}
	public Adapter(IThree t){
        this.t=t;
	}
	public void setThree(IThree t){
		this.t=t;
	}
	public void useTwo(){
		System.out.println("插入两相插座");
	}
	public void useThree(){
		t.useThree();
	}
}
class Hotel{
	ITwo chazuo;
	public Hotel(ITwo chazuo){
		this.chazuo=chazuo;
	}
	public void useChazuo(){
		chazuo.useTwo();
	}
}