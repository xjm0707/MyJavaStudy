public class DoorTest{
	public static void main(String[] args) {
		Door d=new Door();
		d.open();
		d.close();
	}
}
abstract class Door{
	abstract void open();
	abstract void close();
}
interface IMaoYan{
	public abstract void see();
}
interface IAgansitFire(){
	public abstract agansitFire();
}
class SecrityDoor extends Door implements IMaoYan{
	public void see(){
		System.out.println("观察外面的世界");
	}
}
class FireDoor extends Door implements IAgansitFire{
	public void agansitFire(){
		System.out.println("防火");
	}
}
