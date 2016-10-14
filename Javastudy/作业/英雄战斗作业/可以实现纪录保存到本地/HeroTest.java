import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.Properties;
/**
*测试类
*测试英雄间的五局三胜制战斗
*
*/
public class HeroTest{
	public static void main(String[] args){
		
		Mage a=new Mage("漩涡鸣人",100,"风遁.螺旋手里剑");
		Hunter b=new Hunter("宇智波佐助",100,"炎遁.加具土命");
		
		System.out.println("＊＊＊＊"+a.getName()+"与"+b.getName()+"的世纪大对决！＊＊＊＊");
		fighting(a,b);		
	}
	public static void fighting(Mage a,Hunter b){
		Random ran=new Random();
		Scanner input=new Scanner(System.in);
		
		int count1=0;//定义一个计数器，每当法师的血量为0时，记1次猎人获胜
		int count2=0;//定义另一个计数器，每当猎人的血量为0时，记1次法师获胜
		
		for (int i=1;i<6;i++){
			
			if (count1==3||count2==3) {//当计数器记下任意一方获胜3次，停止循环，输出最终结果
				break;
			}
			else{
				System.out.println("请按任意键观看第"+i+"场战斗");
				String anyButton=input.next();		

				System.out.println("-----------------------------Round"+i+"-----------------------------------");
				System.out.println("战斗开始！");
			}

			while(a.getBlood()>0&&b.getBlood()>0){

		        int r=ran.nextInt(100)+1;//随机一个1到100的数
		        
		        if (r>0&&r<26){//随机数为1～25，则法师发动攻击
		        	a.fight(b);

		        	if (a.getBlood()==0){
		        		b.fight(a);			
		        		a.setBlood(100);
		        		b.setBlood(100);
		        		count1++;
		        		saveResult(count1,count2,i);
		        		break;
		        	}
		        	else if (b.getBlood()==0){
		        		a.fight(b);
		        		a.setBlood(100);
		        		b.setBlood(100);
		        		count2++;
		        		saveResult(count1,count2,i);
		        		break;
		        	}
		        	else{
		        		continue;
		        	}
		        }
		        else if (r>25&&r<51){//随机数为26～50，则法师发动防御（回复血量）
		        	a.defense();
		        	continue;
		        }
		        else if (r>50&&r<76){//随机数为51～75，则猎人发动攻击
		        	b.fight(a);

		        	if (a.getBlood()==0){
		        		b.fight(a);
		        		a.setBlood(100);
		        		b.setBlood(100);
		        		count1++;
		        		saveResult(count1,count2,i);
		        		break;
		        	}
		        	else if (b.getBlood()==0){
		        		a.fight(b);
		        		a.setBlood(100);
		        		b.setBlood(100);
		        		count2++;
		        		saveResult(count1,count2,i);
		        		break;
		        	}
		        	else{
		        		continue;
		        	}
		        }
		        else{//随机数为76～101，则猎人发动防御（回复血量）
		        	b.defense();
		        	continue;
		        }
		    }
		}		
		System.out.println();
		System.out.println("******************* "+a.getName()+"   "+count2+":"+count1+"   "+b.getName()+" *******************");
		
		if (count1==3){
			System.out.println("******************* 恭喜"+b.getName()+"获得最终胜利！*******************");
		}
		else{
			System.out.println("******************* 恭喜"+a.getName()+"获得最终胜利！*******************");
		}
	}
	/*
	将战斗纪录保存到本地
	*/
	public static void saveResult(int count1,int count2,int i){
        try{
        	Properties p=new Properties();
        	FileOutputStream fos=new FileOutputStream("HeroFight.txt",true);
        	p.load(new FileInputStream("HeroFight.txt"));
        	p.getProperty("Round","0");
        	p.setProperty("Round",i+"");
        	p.getProperty("HunterWin","0");
        	p.setProperty("HunterWin",count1+"");
        	p.getProperty("MageWin","0");
        	p.setProperty("MageWin",count2+"");
        	p.setProperty("Winer","...");
        	if (Integer.parseInt(p.getProperty("HunterWin"))==3) {
        		p.setProperty("Winer","Hunter");
        	}
        	if (Integer.parseInt(p.getProperty("MageWin"))==3) {
        		p.setProperty("Winer","Mage");
        	}
        	p.store(new FileOutputStream("HeroFight.txt",true),new String("英雄五局三胜战斗纪录".getBytes(),"ISO8859-1"));
 
        }catch (Exception e) {
        	e.printStackTrace();
        }    
	}
}
/**
*父类（抽象类） Hero 英雄类
*定义了英雄的名字 name 血量 blood 
*抽象方法 fight(攻击) defense(防御)
*
*/
abstract class Hero{
	private String name;
	private int blood;
	
	public Hero(){} 
	public Hero(String name,int blood){
		this.name=name;
		this.blood=blood;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getBlood(){
		return blood;
	}
	public void setBlood(int blood){
		this.blood=blood;
	}
	abstract void fight(Hero hero);
	abstract void defense();
}
/**
*子类 Mage 法师类
*recovery 定义了法师的防御力为23
*skill 定义了法师技能的名字
*swordFight方法 返回武器 sword 的伤害值
*fight方法 计算并输出被攻击方的血量
*defense方法 计算并输出防御方的血量
*Random ran1 定义了一个随机数 随机产生给被攻击方的额外伤害值
*/
class Mage extends Hero implements Iweapon1{
	private int recovery=23;
	private String skill;
	Random ran1=new Random();

	public Mage(){}
	public Mage(String name,int blood,String skill){                   
		super(name,blood);
		this.skill=skill;
	 }
	public int swordFight(){
        return sword;
	}
	public void fight(Hero hero){

		int r1=ran1.nextInt(20);
        
        if (hero.getBlood()>0){
            System.out.println("["+this.getName()+"] 发动"+skill+"!");
            System.out.print("["+hero.getName()+"] 受到"+swordFight()+"点技能伤害,以及"+r1+"点额外伤害！");
            hero.setBlood(hero.getBlood()-swordFight()-r1);
            if (hero.getBlood()>0) {
                System.out.println("血量减至"+hero.getBlood()); 	  	
            }
            else{
            	hero.setBlood(0);
            	System.out.println("血量减至"+hero.getBlood()+",下体血流不止，跪地求饶。。");
            	System.out.println("["+this.getName()+"] 剩余血量为"+this.getBlood()+"...");
            }
        }
        else{
        	System.out.println("***......... "+hero.getName()+"战败！.........***");
        }
	}
	public void defense(){
        if (getBlood()>=80){
            if (getBlood()==100){
            	System.out.println("["+this.getName()+"] 发动回复技能！然而并没有什么卵用，血量已达体力上限。。");
            }
            else{
        	    this.setBlood(100);
                System.out.println("["+this.getName()+"] 发动回复技能！血量加至"+this.getBlood());
            }
        }
        else{
            this.setBlood(getBlood()+recovery);
            System.out.println("["+this.getName()+"] 发动回复技能！血量加至"+this.getBlood());
        }
	}
}
/**
*子类 Hunter 猎人类
*recovery 定义了猎人的防御力为14
*skill 定义了猎人技能的名字
*axeFight方法 返回武器 axe 的伤害值
*fight方法 计算并输出被攻击方的血量
*defense方法 计算并输出防御方的血量
*Random ran2 定义了一个随机数 随机产生给被攻击方的额外伤害值 
*/
class Hunter extends Hero implements Iweapon2{
	private int recovery=14;
	private String skill;
	Random ran2=new Random();
	
	public Hunter(){}
	public Hunter(String name,int blood,String skill){
        super(name,blood);
        this.skill=skill;
	}
	public int axeFight(){
        return axe;
	}
	public void fight(Hero hero){

		int r2=ran2.nextInt(20);
        
        if (hero.getBlood()>0){
            System.out.println("["+this.getName()+"] 发动"+skill+"!");
            System.out.print("["+hero.getName()+"] 受到"+axeFight()+"点技能伤害，以及"+r2+"点额外伤害！");
        	hero.setBlood(hero.getBlood()-axeFight()-r2);
            if (hero.getBlood()>0) {
                System.out.println("血量减至"+hero.getBlood()); 	  	
            }
            else{
            	hero.setBlood(0);
            	System.out.println("血量减至"+hero.getBlood()+"，一口老痰噎死过去。。");
            	System.out.println("["+this.getName()+"] 剩余血量为"+this.getBlood()+"...");
            } 	
        }
        else{
        	System.out.println("***......... "+hero.getName()+"战败！.........***");
        }
	}
	public void defense(){
        if (this.getBlood()>=90){
            if (this.getBlood()==100){
            	System.out.println("["+this.getName()+"] 发动回复技能！然而并没有什么卵用，血量已达体力上限。。");
            }
            else{
        	    this.setBlood(100);
                System.out.println("["+this.getName()+"] 发动回复技能！血量加至"+this.getBlood());
            }
        }
        else{
            this.setBlood(getBlood()+recovery);
            System.out.println("["+this.getName()+"] 发动回复技能！血量加至"+this.getBlood());	
        }
	}
}
/**
*接口 Iweapon1 法师武器 sword 定义其攻击力为40
*     Iweapon2 猎人武器 axe 定义其攻击力为45
*/
interface Iweapon1{   
	int sword=41;
}
interface Iweapon2{
    int axe=37;
}




