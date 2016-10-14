import java.util.*;
/*
4、数据库中保存着飞机票（班次、票价、时间）
1）用户输入班次，则返回指定的飞机票
2）用户输入票价，则按票价低到高的顺序返回飞机票，对选出的飞机票迭代输出
3）用户输入时间，则按时间先后顺序返回飞机票，对选出的飞机票迭代输出

提示：使用TreeSet集合保存飞机票，第2、3小问可以使用我们学过的迭代来做，也可以使用tailSet()方法，具体查看jdk文档
*/
public class Test4{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.println("1->查询班次2->查询票价3->查询时间");
			switch(input.nextInt()){
				case 1:
				searchOrdtwo(input);
				break;
				case 2:
				searchPrice(input);
				break;
				case 3:
				searchTime(input);
				break;
				default:
				break;
			}
		}
	}
	private static void addIntoSet(TreeSet<AirTicket> ts){
		ts.add(new AirTicket("MU3358",550,"07:35"));
		ts.add(new AirTicket("MU3729",850,"04:49"));
		ts.add(new AirTicket("MU6668",350,"06:35"));
		ts.add(new AirTicket("MF2558",490,"17:25"));
		ts.add(new AirTicket("MF3394",1050,"14:55"));
		ts.add(new AirTicket("ME9758",1550,"19:35"));
		ts.add(new AirTicket("ME4258",3000,"22:06"));
	}
	private static void searchOrdtwo(Scanner input){
		System.out.println("输入班次:");
		String airOrdtwo=input.next();
		TreeSet<AirTicket> ts=new TreeSet<AirTicket>();
		addIntoSet(ts);
		for(AirTicket airTicket:ts){
			if(airOrdtwo.equals(airTicket.airOrdtwo)){
				System.out.println(airTicket);
				break;
			}
		}
	}
	private static void searchPrice(Scanner input){
		TreeSet<AirTicket> ts=new TreeSet<AirTicket>(new Comparator<AirTicket>(){
			public int compare(AirTicket a1,AirTicket a2){
				if(a1.price==a2.price){
					return a1.airOrdtwo.compareTo(a2.airOrdtwo);
				}
				return a1.price-a2.price;
			}
		});
		addIntoSet(ts);
		System.out.println("输入票价");
		int price=input.nextInt();
		Set<AirTicket> tailts=ts.tailSet(new AirTicket("",price,""));
		for(AirTicket airTicket:tailts){
			System.out.println(airTicket);
		}
	}
	private static void searchTime(Scanner input){
		TreeSet<AirTicket> ts=new TreeSet<AirTicket>(
			new Comparator<AirTicket>(){
			public int compare(AirTicket a1,AirTicket a2){
				if(a1.time.equals(a2.time)){
					return a1.airOrdtwo.compareTo(a2.airOrdtwo);
				}
				return a1.time.compareTo(a2.time);
			}
		});
		addIntoSet(ts);
		System.out.println("输入时间");
		String time=input.next();
		Set<AirTicket> tailts=ts.tailSet(new AirTicket("",0,time));//筛选出时间大于指定时间的机票
		for(AirTicket airTicket:tailts){
			System.out.println(airTicket);
		}
	}
}
class AirTicket implements Comparable<AirTicket>{
	String airOrdtwo;
	int price;
	String time;
	public AirTicket(String airOrdtwo,int price,String time){
		this.airOrdtwo=airOrdtwo;
		this.price=price;
		this.time=time;
	}
	public int compareTo(AirTicket airTicket){
		return airOrdtwo.compareTo(airTicket.airOrdtwo);
	}
	public String toString(){
		return "班次："+airOrdtwo+"--票价："+price+"--时间："+time;
	}
}