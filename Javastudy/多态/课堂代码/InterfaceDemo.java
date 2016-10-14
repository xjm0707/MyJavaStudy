public class InterfaceDemo{
	public static void main(String[] args) {
		Fu f=new Fu();

	}
}

//多层继承
interface A{
	public void menthod1();
}
interface B extends A{
	public void menthod1();
}
interface C extends B{
	public void menthod3();
}

class Fu implements A,B,C{
	public void menthod1(){}
	public void menthod3(){}
}

//多继承
interface D{
	public void menthod1(){}
}
interface E{
	public void menthod1(){}
}
interface F extends E,D{
	public void menthod3();
}

class Zi implements F{
	public void menthod3(){}
	public void menthod1(){}
}

