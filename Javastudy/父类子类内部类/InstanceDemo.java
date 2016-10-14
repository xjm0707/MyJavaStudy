/**
*单例设计模式
*
*
*/
public class InstanceDemo{
	public static void main(String[] args) {
		Utils a=Utils.getInstance();
		
	}
	//饿汉式 单例设计模式
	class Utils{
		int num=10;
		private Utils(){}
		static Utils u=new Utils();
		public static Utils getInstance(){
			return u;
		}
		void caozuo(){
			num=num-1;
			System.out.println(num);
		}
	}
    //懒汉式 单例设计模式
	class Utils1{
		int num=10;
		private Utils1(){}
		static Utils1 u=null;
		public static synchronized Utils1 getInstance(){
			if(u=null){
				u=new Utils1();
			}
			return u;
		}
		void caozuo(){
			num=num-1;
			System.out.println(num);
	}

}
}