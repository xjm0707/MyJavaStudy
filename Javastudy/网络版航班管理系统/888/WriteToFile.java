import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

public class WriteToFile {
	public static void main(String[] args) throws Exception{
		TreeSet<Ticket> al=new TreeSet<Ticket>();
		al.add(new Ticket("CZ6412",968,"2016/10/10"));
		al.add(new Ticket("YG6412",899,"2016/10/28"));
		al.add(new Ticket("FG6852",1400,"2016/11/23"));
		al.add(new Ticket("WE6412",2500,"2016/10/24"));
		al.add(new Ticket("TY7812",875,"2016/10/26"));
		al.add(new Ticket("TY6412",1800,"2016/11/01"));
		al.add(new Ticket("YU1212",1500,"2016/10/20"));
		al.add(new Ticket("DG6412",988,"2016/10/03"));
		al.add(new Ticket("JK6012",2800,"2016/10/07"));
		al.add(new Ticket("DF1312",2500,"2016/10/09"));
		al.add(new Ticket("CV6322",759,"2016/10/10"));
		al.add(new Ticket("GN6412",2300,"2016/10/25"));
		al.add(new Ticket("AW6572",875,"2016/10/15"));
		al.add(new Ticket("CZ6412",1875,"2016/10/16"));
		al.add(new Ticket("FG6412",873,"2016/10/13"));
		al.add(new Ticket("CZ6892",988,"2016/10/26"));
		al.add(new Ticket("QW7412",1200,"2016/10/17"));
		al.add(new Ticket("AW9612",875,"2016/10/19"));
		al.add(new Ticket("GH4512",1050,"2016/10/08"));
		ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream("/Users/abc123/desktop/abc.txt"));
		oo.writeObject(al);
		System.out.println(al);
		oo.close();
	}
}
