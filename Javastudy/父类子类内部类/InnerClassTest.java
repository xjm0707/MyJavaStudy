/**
*
*
*
*/
public class InnerClassTest{
	public static void main(String[] args) {
		Company c=new Company("宝强有限公司",200);

		c.show();

		Company.Agency agency=c.new Agency();
		
		agency.setName("宋喆");
		agency.playgirls();
	}
}
/**
*外部类 Company
*内部类 Agency
*
*/
class Company{
	private String name;
	private int money;

	public Company(String name,int money){
		this.name=name;
		this.money=money;
	}
	public void show(){
		System.out.println("公司名称："+name+" "+"公司资金："+money+"万");
	}
	class Agency{
		private String name;
		private int sex;

		public void setName(String name){
			this.name=name;
		}
		public void setSex(int sex){
			this.sex=sex;
		}
		public void playgirls(){
			money=money-100;
			System.out.println(name+"泡妞，"+"导致公司目前资金只剩"+money+"万");
		}
	}
}