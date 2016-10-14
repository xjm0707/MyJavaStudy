public class CompanyDemo{
	public static void main(String[] args) {
		Company c=new Company("gongsi",100);
		c.employ();
	}
}
abstract class Worker{
	abstract void work();
}

class Company{
	private String name;
	private int money;

	public Company(){}
	public Company(String name,int money){
		this.name=name;
		this.money=money;
	}
	public void employ(){
	    new Worker(){
	    	void work(){
	    		System.out.println("工作");
	    		paoniu();
	    	}
	    	void paoniu(){
	    		System.out.println("泡妞");
	    	}
	    }.work();

	// 	class Agency extends Worker{
	// 		void work(){
	// 			System.out.println(Company.this.name);
	// 			System.out.println("工作");
	// 			paoniu();
	// 		}
	// 		void paoniu(){
	// 			System.out.println("泡妞");
	// 		}
	// 	}
	// new Agency().work();
	 }
}