import java.util.*;
public class StudentMenu{
	public static void main(String[] args) {
		TreeSet<Student> tm1=new TreeSet<Student>();
		tm1.add(new Student("张三",23,new int []{84,76,79}));
		tm1.add(new Student("李四",22,new int []{84,51,67}));
		tm1.add(new Student("王五",21,new int []{73,99,52}));

		TreeSet<Student> tm2=new TreeSet<Student>();
		tm2.add(new Student("张九",20,new int []{54,77,68}));
		tm2.add(new Student("陆小",24,new int []{53,75,68}));
		tm2.add(new Student("黑白",21,new int []{52,68,77}));

		TreeSet<Student> tm3=new TreeSet<Student>();
		tm3.add(new Student("法克",24,new int []{62,77,69}));
		tm3.add(new Student("敌法",19,new int []{69,75,72}));
		tm3.add(new Student("吴起",24,new int []{62,77,69}));

		HashMap<Integer,TreeSet<Student>> hm=new HashMap<Integer,TreeSet<Student>>();
		hm.put(1,tm1);
		hm.put(2,tm2);
		hm.put(3,tm3);

		boolean flag=true;
		while(flag){
			System.out.println("1===>查看所有");
			System.out.println("2===>新增学生");
			System.out.println("3===>修改学生");
			System.out.println("4===>优秀学生");	
			Scanner input1=new Scanner(System.in);
			switch(input1.nextInt()){
				case 1:
				print(hm);
				break;
				case 2:
				addStudent(hm);
				break;
				case 3:
				resetStudent(hm);
				break;
				case 4:
				excellentStudent(hm);
				break;
				default:
				break;
			}
			System.out.println();
		}


	}
	//迭代输出所有学生
	private static void print(HashMap<Integer,TreeSet<Student>> hm){
		Set<Map.Entry<Integer,TreeSet<Student>>> set=hm.entrySet();
		for(Iterator<Map.Entry<Integer,TreeSet<Student>>> it1=set.iterator();it1.hasNext();){
			Map.Entry<Integer,TreeSet<Student>> entry=it1.next();
			System.out.println(entry.getKey()+"班：");
			for(Iterator<Student> it2=entry.getValue().iterator();it2.hasNext();){
				System.out.println(it2.next());
			}
		}
	}
	//新增学生
	private static void addStudent(HashMap<Integer,TreeSet<Student>> hm){
		Scanner input=new Scanner(System.in);
		System.out.println("输入学生姓名");
		String name=input.next();
		System.out.println("输入学生年龄");
		int age=input.nextInt();
		System.out.println("输入学生班级");
		int classNum=input.nextInt();
		if(classNum==1||classNum==2||classNum==3){
			hm.get(classNum).add(new Student(name,age));
		}else{
			System.out.println("没有班级");
		}
		
	}
	//修改学生分数
	private static void resetStudent(HashMap<Integer,TreeSet<Student>> hm){
		Scanner input=new Scanner(System.in);
		System.out.println("输入学生姓名");
		String name=input.next();
		Set<Map.Entry<Integer,TreeSet<Student>>> set=hm.entrySet();
		boolean hasStudent=false;
		int theNum=0;
		Student theStudent=null;
		for(Iterator<Map.Entry<Integer,TreeSet<Student>>> it1=set.iterator();it1.hasNext();){
			Map.Entry<Integer,TreeSet<Student>> entry=it1.next();
			int classNum=entry.getKey();
			for(Iterator<Student> it2=entry.getValue().iterator();it2.hasNext();){
				Student t=it2.next();
				if(t.name.equals(name)){
					hasStudent=true;
					System.out.println("修改语文分数");
					int chinese=input.nextInt();
					System.out.println("修改数学分数");
					int math=input.nextInt();
					System.out.println("修改英语分数");
					int english=input.nextInt();
					t.setScore(new int []{chinese,math,english});
					theStudent=t;
					it2.remove();
					break;
				}
			}
			if(hasStudent){
				theNum=classNum;
				break;
			}
		}
		if(hasStudent){
			hm.get(theNum).add(theStudent);
		}else{
			System.out.println("找不到学生");
		}
		
	}
	//找出优秀学生
	private static void excellentStudent(HashMap<Integer,TreeSet<Student>> hm){
		Set<Map.Entry<Integer,TreeSet<Student>>> set=hm.entrySet();
		int countChinese=0;
		int countMath=0;
		int countEnglish=0;
		int count=0;
		for(Iterator<Map.Entry<Integer,TreeSet<Student>>> it1=set.iterator();it1.hasNext();){
			Map.Entry<Integer,TreeSet<Student>> entry=it1.next();
			for(Iterator<Student> it2=entry.getValue().iterator();it2.hasNext();){
				Student t=it2.next();
				countChinese+=t.score[0];
				countMath+=t.score[1];
				countEnglish+=t.score[2];
				count++;
			}
		}
		int averageChinese=countChinese/count;
		System.out.println("语文平均分："+averageChinese);
		int averageMath=countMath/count;
		System.out.println("数学平均分："+averageMath);
		int averageEnglish=countEnglish/count;
		System.out.println("英语平均分："+averageEnglish);
		System.out.print("语文成绩优秀者：");
		for(Iterator<Map.Entry<Integer,TreeSet<Student>>> it1=set.iterator();it1.hasNext();){
			Map.Entry<Integer,TreeSet<Student>> entry=it1.next();
			int key=entry.getKey();
			for(Iterator<Student> it2=entry.getValue().iterator();it2.hasNext();){
				Student t=it2.next();
				if(t.score[0]>averageChinese){
					System.out.print(key+"班--"+t.name+"  ");
				}
			}
		}
		System.out.println();
		System.out.print("数学成绩优秀者：");
		for(Iterator<Map.Entry<Integer,TreeSet<Student>>> it1=set.iterator();it1.hasNext();){
			Map.Entry<Integer,TreeSet<Student>> entry=it1.next();
			int key=entry.getKey();
			for(Iterator<Student> it2=entry.getValue().iterator();it2.hasNext();){
				Student t=it2.next();
				if(t.score[1]>averageMath){
					System.out.print(key+"班--"+t.name+"  ");
				}
			}
		}
		System.out.println();
		System.out.print("英语成绩优秀者：");
		for(Iterator<Map.Entry<Integer,TreeSet<Student>>> it1=set.iterator();it1.hasNext();){
			Map.Entry<Integer,TreeSet<Student>> entry=it1.next();
			int key=entry.getKey();
			for(Iterator<Student> it2=entry.getValue().iterator();it2.hasNext();){
				Student t=it2.next();
				if(t.score[2]>averageEnglish){
					System.out.print(key+"班--"+t.name+"  ");
				}
			}
		}
		System.out.println();

	}
		
}
class Person{
	String name;
	int age;
}
class  Student extends Person implements Comparable<Student>{
	int [] score=new int [3];
	public Student(String name,int age,int [] score){
		this.name=name;
		this.age=age;
		this.score=score;
	}
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void setScore(int [] score){
		this.score=score;
	}
	private int average(){
		return (score[0]+score[1]+score[2])/3;
	}
	public int compareTo(Student s){
		if(this.average()==s.average()){
			return this.name.compareTo(s.name);
		}
		return this.average()-s.average();
	}
	public String toString(){
		return "("+name+"-"+age+":"+score[0]+"-"+score[1]+"-"+score[2]+","+"平均分:"+average()+")";
	}
}