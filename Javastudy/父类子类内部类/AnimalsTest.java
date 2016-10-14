public class AnimalsTest{
	public static void main(String[] args) {
		Rabbit r=new Rabbit("兔子",50,1);
		Tiger t=new Tiger("老虎",200,2);

		r.introduce();
		r.eat();
		r.sleep();
		System.out.println("-------------");
		t.introduce();
		t.eat();
		t.sleep();

	}
}

class Animals{
	String name;
    int weigth;
	int sex;

	public Animals(){}
	public Animals(String name,int weigth,int sex){
		this.name=name;
		this.weigth=weigth;
		this.sex=sex;
	}
	void introduce(){
		System.out.println(name+" "+weigth+" "+sex);
	}

	void eat(){
		System.out.println("吃");
	}
	void sleep(){
		System.out.println("睡觉");
	}
	void run(){
		System.out.println("跑动");
	}
}
class Rabbit extends Animals{

	public Rabbit(){}
	public Rabbit(String name,int weigth,int sex){
		this.name=name;
		this.weigth=weigth;
		this.sex=sex;
	}

	void eat(){
		System.out.println("吃草");
	}
	void sleep(){
		super.run();
		System.out.println("睡觉");
	}
}
class Tiger extends Animals{

	public Tiger(){}
	public Tiger(String name,int weigth,int sex){
		this.name=name;
		this.weigth=weigth;
		this.sex=sex;
	}

	void eat(){
		System.out.println("吃肉");
	}
	void sleep(){
		super.run();
		System.out.println("睡觉");
	}
}