import java.util.*;
public class CollectionsDemo{
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add(new Game("DOTA","MOBA"));
		al.add(new Game("战神4","ACT"));
		al.add(new Game("魔兽世界","MMO"));
		al.add(new Game("GTA5","ARPG"));
		al.add(new Game("战神4","ACT"));

		// Collections.fill(al,new Game("战神4","ACT"));
		// System.out.println(al);

		Collections.replaceAll(al,al.get(3),new Game("魔兽世界","MMO"));
		System.out.println(al);
		
		Collections.swap(al,1,2);
		System.out.println(al);
	}
}
class Game{
	String name;
	String type;
	public Game(String name,String type){
        this.name=name;
        this.type=type;
	}
	public String toString(){
		return "("+name+","+type+")";
	}
}