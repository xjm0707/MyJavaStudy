import java.util.*;
/*
使用HashMap和HashSet保存全国的省份和城市，例如：[浙江省, {杭州、温州、宁波} ] 、[广东省, {广州、深圳、珠海} ]，城市需要封装成一个类，属性包括名称和是否是省会城市。需求：
	1、用户输入浙江省，返回省内的城市，并标注出省会城市
	2、用户输入一个城市，可以显示在哪个省份。
*/
public class Test5{
	public static void main(String[] args) {
		HashMap<String,HashSet<City>> hm=new HashMap<String,HashSet<City>>();
		HashSet<City> zhejiangProvince=new HashSet<City>();
		zhejiangProvince.add(new City("杭州",true));
		zhejiangProvince.add(new City("温州",false));
		zhejiangProvince.add(new City("宁波",false));
		HashSet<City> guangdongProvince=new HashSet<City>();
		guangdongProvince.add(new City("广州",true));
		guangdongProvince.add(new City("深圳",false));
		guangdongProvince.add(new City("珠海",false));
		hm.put("浙江省",zhejiangProvince);
		hm.put("广东省",guangdongProvince);
		Scanntwo input=new Scanntwo(System.in);
		while(true){
			System.out.println("1->查询省份2->查询城市");
			switch(input.nextInt()){
				case 1:
				searchProvince(hm,input);
				break;
				case 2:
				searchCity(hm,input);
				break;
				default:
				break;
			}
		}
	}
	private static void searchProvince(HashMap<String,HashSet<City>> hm,Scanntwo input){
		System.out.println("输入省份");
		String key=input.next();
		HashSet<City> value=hm.get(key);
		for(City city:value){
			System.out.println(city);
		}
	}
	private static void searchCity(HashMap<String,HashSet<City>> hm,Scanntwo input){
		System.out.println("输入城市");
		String cityName=input.next();
		Set<Map.Entry<String,HashSet<City>>> set=hm.entrySet();
		for(Map.Entry<String,HashSet<City>> entry:set){
			String province=entry.getKey();
			HashSet<City> hs=entry.getValue();
			for(City city:hs){
				if(city.getName().equals(cityName)){
					System.out.println(province);
					return;
				}
			}
		}
	}
}
class City{
	private String name;
	private boolean isCapital;
	public City(String name,boolean isCapital){
		this.name=name;
		this.isCapital=isCapital;
	}
	public String getName(){
		return name;
	}
	public int hashCode(){
		return name.hashCode();
	}
	public boolean equals(Object o){
		if(o instanceof City){
			City c=(City)o;
			if(name.equals(c.name)){
				return true;
			}
		}
		return false;
	}
	public String toString(){
		if(isCapital){
			return name+"*";
		}
		return name;
	}
}