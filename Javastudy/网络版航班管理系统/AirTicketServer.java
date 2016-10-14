import java.io.*;
import java.net.*;
import java.util.*;
public class AirTicketServer{
	public static void main(String[] args) {
		
	}
}
class AirTicket implements Comparable{
	String flight;
	int price;
	String time;
	public AirTicket(String flight,int price,String time){
        this.flight=flight;
        this.price=price;
        this.time=time;
	}
	public String toString(){
		return "班次："+flight+" 票价："+price+"元 时间："+time;
	}
	public int compareTo(Object o){
		AirTicket at=(AirTicket)o;
		if (this.flight>at.flight) {
			return 1;
		}
		if (this.flight==at.flight) {
			return 0;
		}else{
			return -1;
		}
	}
}
class MyComparator implements Comparator{
	public int compare(Object o1,Object o2){
		AirTicket at1=(AirTicket)o1;
		AirTicket at2=(AirTicket)o2;
		if (at1.price>at2.price) {
			return 1;
		}
		if (at1.price==at2.price) {
			return 0;
		}else{
			return -1;
		}
	}
}
class MyComparator1 implements Comparator{
	public int compare(Object o1,Object o2){
		AirTicket at1=(AirTicket)o1;
		AirTicket at2=(AirTicket)o2;
		if (at1.time>at2.time) {
			return 1;
		}
		if (at1.time==at2.time) {
			return 0;
		}else{
			return -1;
		}
	}
}
