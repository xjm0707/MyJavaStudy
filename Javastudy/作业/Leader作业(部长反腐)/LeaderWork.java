/**
*这是一个测试类
*
*/
public class LeaderWork{
	public static void main(String[] args) {
		Minister m=new Minister("M部长",43);
		Director d=new Director("D局长",39);
		Director.Assistant a=d.new Assistant("A秘书",21);
		
		m.lead();
		d.lead();
		d.dateAssistant();
		a.useMoney();	
		if (d.getMoney()<100) {
            if (m.getLevel()>=10) {
            	m.against();
            	d.setMoney(0);
            	System.out.println("局长可用资金为"+d.getMoney());			
            }
            else{
            	System.out.println("部长级别不够，无法进行反腐工作");
            }			
		}
		else{
			d.showMoney();
		
		}
	}
}
/**
*父类 Leader 领导类
*/
class Leader{
	String name;
	int age;

	public Leader(){}
	public Leader(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
    }
	public void lead(){
		System.out.println(this.getAge()+"岁的"+this.getName()+"领导工作");
	}

}
/**
*子类 Minister 部长类
*/
class Minister extends Leader{

	private int level=10;
	
	public Minister(){}
	public Minister(String name,int age){
		//super(name,age);
		this.name=name;
		this.age=age;
	}
	public void setLevel(int level){
        this.level=level;
	}

	public int getLevel(){
		return level;
	}
    public void against(){
    	System.out.println("等级为"+this.getLevel()+"的"+this.getName()+"进行反腐工作");
    }
}
/**
*子类 Director 局长类
*/
class Director extends Leader{

	private int money=100;

	public Director(){}
	public Director(String name,int age){
		//super(name,age);
		this.name=name;
		this.age=age;
	}
	public void setMoney(int money){
		this.money=money;
	}
	public int getMoney(){
		return money;
	}
	public void dateAssistant(){
		System.out.println(this.getName()+"约小秘");
	}
	public void showMoney(){
		System.out.println(this.getName()+"剩余资产为"+this.getMoney()+"万");
	} 
	/**
	*内部类 Assistant 秘书类
	*/
	class Assistant {
		
		private String name;
		private int age;

		public Assistant(String name,int age){
			//super(name,age);
			this.name=name;
			this.age=age;
		}
		public void setName(String name){
			this.name=name;
		}
		public String getName(){
			return name;
		}
		public void setAge(int age){
			this.age=age;
		}
		public int getAge(){
			return age;
		}

		public void useMoney(){
            money=money-80;
            System.out.println(this.getAge()+"岁的"+this.getName()+"让局长资产只剩"+money+"万");
		}
	}
}
