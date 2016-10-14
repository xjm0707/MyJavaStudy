import java.io.Serializable;

class Ticket implements Serializable,Comparable<Ticket>{//继承序列化
	private static final long seriaVersionUID=1L;//区分相同类名
	private String flight;
	private int price;
	private String time;
	public Ticket(String flight,int price,String time){
		this.flight=flight;
		this.price=price;
		this.time=time;
	}
	
	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String toString(){
		return "班次："+flight+","+"票价："+price+","+"时间："+time;
	}
	public int compareTo(Ticket ticket){
		return this.getFlight().compareTo(ticket.getFlight());    
	}
}