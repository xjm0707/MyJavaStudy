/**
*学生信息系统的测试
*/
import java.util.*;
public class ClassRoomTest{
	public static void main(String[] args) {
		HashMap<ClassRoom,TreeSet<Student>> hm=new HashMap<ClassRoom,TreeSet<Student>>();
		
		TreeSet<Student> ts1=new TreeSet<Student>();
		ts1.add(new Student("张三",21,new int[]{68,70,91}));
		ts1.add(new Student("李四",24,new int[]{45,77,66}));
		ts1.add(new Student("王五",23,new int[]{87,58,89}));

		TreeSet<Student> ts2=new TreeSet<Student>();
		ts2.add(new Student("赵六",21,new int[]{63,74,91}));
		ts2.add(new Student("钱七",21,new int[]{60,77,80}));
		ts2.add(new Student("孙八",20,new int[]{86,60,69}));

		hm.put(new ClassRoom(1),ts1);
		hm.put(new ClassRoom(2),ts2);

		boolean flag=true;
		while(flag){
			System.out.println("＊＊＊学生信息系统＊＊＊");
			System.out.println(" -------------------");
			System.out.println("| 输入1 查看学生名单 |");
			System.out.println("| 输入2 添加新的学生 |");
			System.out.println("| 输入3 修改学生成绩 |");
			System.out.println("| 输入4 查看优秀学生 |");
			System.out.println("| 输入5 查看各科最优 |");
			System.out.println("| 输入0 退出信息系统 |");
			System.out.println(" -------------------");
			Scanner input=new Scanner(System.in);
			String a=input.next();
			switch(a){
				case "1":
				checkAll(hm);
				break;
				case "2":
				addNew(hm);
				break;
				case "3":
				resetScore(hm);
				break;
				case "4":
				goodStudent(hm);
				break;
				case "5":
				bestStudy(hm);
				break;
				case "0":
				flag=false;
				break;
				default:
				System.out.println("输入有误！请重新输入！");
				break;
			}
			System.out.println("——————————————————————————————————————————————————————————————————————");
		}	
	}
	/**
	*查看所有学生的信息的方法
	*  (使用迭代器的思想，迭代出所有集合的元素)
	*/
	public static void checkAll(HashMap<ClassRoom,TreeSet<Student>> hm){
		System.out.println();
		System.out.println("学生名单如下:");
		System.out.println();
		
		Set<ClassRoom> s=hm.keySet();
		Iterator<ClassRoom> it=s.iterator();
		while(it.hasNext()){
			ClassRoom key=it.next();
			System.out.println(key);
			
			TreeSet<Student> t=hm.get(key);
			Iterator<Student> it1=t.iterator();
			while(it1.hasNext()){
				Student w=it1.next();
				System.out.println(w);
			}
		}
	}
    /**
	*添加新的学生的方法
	*/
	public static void addNew(HashMap<ClassRoom,TreeSet<Student>> hm){			
		Scanner input=new Scanner(System.in);
		System.out.println("请输入学生姓名:");
		String name=input.next();
		System.out.println("请输入学生年龄:");
		int age=input.nextInt();
		System.out.println("请输入要加入的班级:");
		int number=input.nextInt();

		if (number>0&&number<3) {
			ClassRoom key=new ClassRoom(number);
		    TreeSet<Student> t=hm.get(key);//通过用户输入的班级号来获得班级号所对应的学生集合(通过键获取值)
		    Student s=new Student(name,age,new int[]{0,0,0});//新建一个用户自定义的学生
		    t.add(s);//将学生添加到集合当中

		    System.out.println();
		    System.out.println("加入后学生名单如下:");
		    System.out.println();
		    /*
		    迭代出所有集合元素
		    */
		    Set<ClassRoom> s1=hm.keySet();
		    Iterator<ClassRoom> it=s1.iterator();
		    while(it.hasNext()){
		    	ClassRoom key1=it.next();
		    	System.out.println(key1);

		    	TreeSet<Student> t1=hm.get(key1);
		    	Iterator<Student> it1=t1.iterator();
		    	while(it1.hasNext()){
		    		Student w=it1.next();
		    		System.out.println(w);
		    	}
		    }
		}
		else{
			System.out.println("没有该班级！");
		}
	}
    /**
	*修改学生各科成绩的方法
	*/
	public static void resetScore(HashMap<ClassRoom,TreeSet<Student>> hm){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入学生所在的班级:");
		int number=input.nextInt();
		if (number>0&&number<3) {
			System.out.println("请输入学生姓名:");
			String name=input.next();
			System.out.println("请输入学生年龄:");
			int age=input.nextInt();
			System.out.println("请修改语文成绩:");
			int score1=input.nextInt();
			System.out.println("请修改数学成绩:");
			int score2=input.nextInt();
			System.out.println("请修改英语成绩:");
			int score3=input.nextInt();

			ClassRoom key=new ClassRoom(number);
			TreeSet<Student> t=hm.get(key);
		    Student s=new Student(name,age,new int[]{score1,score2,score3});//新建一个用户自定义的学生(包含三科成绩)

            boolean flag=false;//设定一个布尔值来判断 集合中是否有用户需要修改的学生

            Iterator<Student> it1=t.iterator();//迭代用户输入的班级号所对应的学生集合中的所有元素
            while(it1.hasNext()){
            	Student w=it1.next();
            	if (w.name.equals(s.name)&&w.age==s.age) {
        		    flag=true;//如果用户输入的学生姓名和年龄和集合中某一个学生元素的姓名和年龄一致，说明有该学生
        		    it1.remove();//将集合中的该学生移除
        		}
        	}
        	if (flag) {
			    t.add(s);//将用户新建的学生添加到集合中
			    System.out.println();
			    System.out.println("修改完成！");
			    checkAll(hm);//调用查看所有学生的信息的方法
		    }
		    else{
                System.out.println("找不到该学生！");//如果没有该学生 输出找不到该学生
            }
        }
        else{
        	System.out.println("没有该班级！");
        }
    }
    /**
	*查看三科平均分最高者信息的方法
	*  通过last()方法，输出集合中最后一个元素的内容(因为TreeSet已经根据平均分进行了排序，所以最后一位就是最高分者)
	*/
	public static void goodStudent(HashMap<ClassRoom,TreeSet<Student>> hm){
		Set<ClassRoom> s=hm.keySet();
		Iterator<ClassRoom> it=s.iterator();
		while(it.hasNext()){
			ClassRoom key=it.next();			
			TreeSet<Student> t=hm.get(key);
			
			Iterator<Student> it1=t.iterator();
			while(it1.hasNext()){
				Student w=it1.next();
			}
			System.out.println(key+"平均分最优者:");
			System.out.println(t.last());
		}
	}
    /**
	*查看各科成绩最优者信息的方法
	*/
	public static void bestStudy(HashMap<ClassRoom,TreeSet<Student>> hm){
		Set<ClassRoom> s=hm.keySet();
		Iterator<ClassRoom> it=s.iterator();
		while(it.hasNext()){
			ClassRoom key=it.next();			
			TreeSet<Student> t=hm.get(key);			
			/*
			分别新建出 存放各科成绩 和 存放学生姓名 的数组
			*/
			int[] chinese=new int[t.size()];
			String[] chineseBest=new String[t.size()];
			int[] math=new int[t.size()];
			String[] mathBest=new String[t.size()];
			int[] english=new int[t.size()];
			String[] englishBest=new String[t.size()];
			
			int i=0;//定义一个i 用于将迭代出来的元素循环存入数组当中			
			HashMap<Integer,String> ha=new HashMap<Integer,String>();//新建一个HashMap集合，用来将各科成绩与学生姓名进行一一对应
			
			Iterator<Student> it1=t.iterator();
			while(it1.hasNext()){
				Student w=it1.next();
				/*
			    将迭代出来的元素(各科成绩 和 学生姓名)循环存入数组当中
			    */
			    chinese[i]=w.score[0];
			    chineseBest[i]=w.name;	
			    math[i]=w.score[1];
			    mathBest[i]=w.name;
			    english[i]=w.score[2];
			    englishBest[i]=w.name;
                /*
			    将 各科成绩 作为 键 存入HashMap集合中，将 学生姓名 作为 值 存入HashMap集合中
			    */
			    ha.put(chinese[i],chineseBest[i]);
			    ha.put(math[i],mathBest[i]);
			    ha.put(english[i],englishBest[i]);              
			    i++;             			
			}
			//将各科成绩所在的数组 通过sort()方法进行升序排序  排序之后数组的最末位就是最高成绩
			Arrays.sort(chinese);
			Arrays.sort(math);
			Arrays.sort(english);
            //通过 各科最高成绩 获取对应的 最优学生姓名(通过键获取值)
			String name1=ha.get(chinese[chinese.length-1]);
			String name2=ha.get(math[math.length-1]);
			String name3=ha.get(english[english.length-1]);
			
			System.out.println(key);
			System.out.println("语文最优者:");
			System.out.print("姓名:"+name1);
			System.out.println(" 成绩:"+chinese[chinese.length-1]+"分");
			
			System.out.println("数学最优者:");
			System.out.print("姓名:"+name2);
			System.out.println(" 成绩:"+math[math.length-1]+"分");
			
			System.out.println("英语最优者:");
			System.out.print("姓名:"+name3);
			System.out.println(" 成绩:"+english[english.length-1]+"分");
		}
	}
}
/**
*班级类
*/
class ClassRoom{
	int number;
	public ClassRoom(int number){
		this.number=number;
	}
	public String toString(){
		return "班级"+number;
	}
	public boolean equals(Object o){
		ClassRoom cr=(ClassRoom)o;
		if (cr.number==this.number) {
			return true;
		}
		return false;
	}
	public int hashCode(){
		return number;
	}
}
/**
*父类 人
*/
class Person implements Comparable{
	String name;
	int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public int compareTo(Object o){
		return 0;
	}
}
/**
*子类 学生
*/
class Student extends Person{
	int[] score=new int[3];
	public Student(String name,int age,int[] score){
		super(name,age);
		this.score=score;
	}
	public int average(){
		return (score[0]+score[1]+score[2])/3;
	}
	public int compareTo(Object o){
		Student s=(Student)o;
		int ave1=s.average();
		int ave2=this.average();

		if (this.name.equals(s.name)&&this.age==s.age) {
			return 0;
		}
		else{
			if (ave1>ave2) {
				return -1;
			}
			if (ave1==ave2) {
				return s.name.compareTo(this.name);
			}
			return 1;
		}
	}
	public String toString(){
		int ave=(score[0]+score[1]+score[2])/3;
		return "姓名:"+name+" 年龄:"+age+" 语文成绩:"+score[0]+" 数学成绩:"+score[1]+" 英语成绩:"+score[2]+" 平均成绩:"+ave;
	}

}