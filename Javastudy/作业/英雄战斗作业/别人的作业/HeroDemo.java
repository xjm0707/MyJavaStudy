import java.util.Scanner;
import java.util.Random;
public class HeroDemo{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Random random=new Random();
		System.out.println("欢迎来到德莱联盟");
		System.out.println("请选择你的英雄：1.法师；2.猎人。");
		Mage mage=new Mage();
		Hunter hunter=new Hunter();
		boolean flag=true;
		String name=null;
		while(flag){
			switch(input.nextInt()){
				case 1:
				setName(input,mage);
				//把你选择的英雄的name属性保存在name字符串中
				name=mage.getName();
				flag=false;
				break;
				case 2:
				setName(input,hunter);
				name=hunter.getName();
				flag=false;
				break;
				default:
				System.out.println("重新输入");
			}
		}
		while(true){
			System.out.println("输入1进入战斗");
			int start=input.nextInt();
			if(start==1){
				//用字符串winName来接收获胜Hero的name属性
				Hero loseHero=combatArray(mage,hunter,random,input,name);
				//判断获胜Hero是不是你的Hero
				if(loseHero.getName().equals(name)){
					System.out.println("你输了，不要灰心，失败是成功之母！");
					System.out.println();
					boolean lose=true;
					while(lose){
						System.out.println("输入1重新挑战，输入2进入德莱商城");
						switch(input.nextInt()){
							case 1:
							lose=false;
							break;
							case 2:
							store(loseHero,input);
							System.out.println();
							System.out.println("继续向前吧，真正的战士永不服输");
							lose=false;
							break;
							default:
							break;
						}
						System.out.println();
					}

				}else{
					System.out.println("你获得了最终的胜利，你的敌人变得更加强大了！");
					System.out.println();
					stronger(loseHero,random);
					System.out.println("输入任意迎接更强的挑战：");
    		        String stop=input.next();
				}
			}else{
				System.out.println("重新输入");
			}
		}
		
	}
	/**
	*setName方法：把输入的字符串赋值给英雄的name属性
	*并打印你的英雄的介绍
	*/
    public static void setName(Scanner input,Hero hero){
    	String name=null;
    	while(true){
    		System.out.println("输入名字");
    		name=input.next();
    		if(name.equals("我是火车王")||name.equals("胜利奥特曼")||name.equals("戒赌吧老哥")||name.equals("电玩勇者狸")||name.equals("圣母玛利亚")||name.equals("三五军体拳")){
    			System.out.println("该名字已被占用");
    		}else{
    			break;
    		}
    	}
    	hero.setName(name);
    	if(hero instanceof Mage){
    		System.out.println("你的英雄");
    		System.out.println("名字："+name);
    		System.out.println("职业：法师");
    		System.out.println();
    	}
    	if(hero instanceof Hunter){
    		System.out.println("你的英雄");
    		System.out.println("名字："+name);
    		System.out.println("职业：猎人");
    		System.out.println();
    	}
    	
    }
    /**
    *combat方法：生成一个1-100的随机数，如果1-25，hero1攻击，如果26-50，hero1防御，
    *            如果51-75，hero2攻击，如果76-100，hero2防御。直至某一方血量小于等于0。
    *返回值int：如果hero1获胜，返回1，如果hero2获胜，返回2。
    */
    public static int combat(Hero hero1,Hero hero2,Random random,String name){
    	hero1.setBlood(100);
    	hero2.setBlood(100);
    	while(true){
    		int randomnum=random.nextInt(99)+1;
    		if(randomnum<=25){
    			hero1.fight(hero2);
    		}else if(randomnum>25&&randomnum<=50){
    			hero1.defense();
    		}else if(randomnum>50&&randomnum<=75){
    			hero2.fight(hero1);
    		}else if(randomnum>75&&randomnum<=100){
    			hero2.defense();
    		}
    		if(hero1.getBlood()<=0){
    			System.out.println(hero1.getName()+"("+hero1.getJob()+")"+"阵亡!!"+hero2.getName()+"("+hero2.getJob()+")"+"剩余血量为"+hero2.getBlood()+"...");
    			System.out.println();
    			if(hero1.getName().equals(name)){
    				System.out.println("你的英雄败北。");
    			}else{
    				System.out.println("你取得了一场胜利。");
    			}
    			System.out.println();
    			return 2;
    		}
    		if(hero2.getBlood()<=0){
    			System.out.println(hero2.getName()+"("+hero2.getJob()+")"+"阵亡!!"+hero1.getName()+"("+hero1.getJob()+")"+"剩余血量为"+hero1.getBlood()+"...");
    			if(hero1.getName().equals(name)){
    				System.out.println("你取得了一场胜利。");
    			}else{
    				System.out.println("你的英雄败北。");
    			}
    			System.out.println();
    			return 1;
    		}
    	}

    }
    /**
    *combatArray方法：将combat返回值（1或2）存入5个存储空间的整形数组中
    *当出现某一方获得3场胜利时，结束战斗。
    *返回值String：获胜Hero的name属性
    */
    public static Hero combatArray(Hero hero1,Hero hero2,Random random,Scanner input,String name){
    	int [] array=new int [5];
    	int countHero1=0;
    	int countHero2=0;
    	for(int i=0;i<5;i++){
    		System.out.println("--------------------------------------------------");
    		System.out.println("Round"+(i+1));
    		array[i]=combat(hero1,hero2,random,name);
    		if(array[i]==1){
    			countHero1++;
    		}
    		if(array[i]==2){
    			countHero2++;
    		}
    		if(countHero1==3){
    			System.out.println(hero1.getName()+"("+hero1.getJob()+")"+"获得了3场胜利！");
    			System.out.println();
    			return hero2;
    		}
    		if(countHero2==3){
    			System.out.println(hero2.getName()+"("+hero2.getJob()+")"+"获得了3场胜利！");
    			System.out.println();
    			return hero1;
    		}
    		System.out.println("输入任意进入下一回合");
    		String stop=input.next();
    	}
        return null;
    }
    /**
    *store方法：提供不同的选项提升玩家的英雄属性
    */
    public static void store(Hero hero,Scanner input){
    	boolean storeFlag=true;
    	while(storeFlag){
    		System.out.println();
    		System.out.println("德莱商城：");
    		System.out.println("输入1购买愤怒合剂（提升攻击力）");
    		System.out.println("输入2购买钢铁合计（提升防御力）");
    		System.out.println("输入3购买誓约胜利之剑Excalibur");
    		System.out.println("输入其他退出德莱商城");
    		int damage=hero.getDamage();
    	    int recovery=hero.getRecovery();
    		switch(input.nextInt()){
    			case 1:
    			damage+=5;
    			hero.setDamage(damage);
    			System.out.println("消费50元成功，您的英雄变的更强壮了");
    			System.out.println(hero.getName()+"("+hero.getJob()+")"+"攻击力+5,攻击力："+hero.getDamage());
    			break;
    			case 2:
    			recovery+=5;
    			hero.setRecovery(recovery);
    			System.out.println("消费50元成功，您的英雄变的更坚韧了");
    			System.out.println(hero.getName()+"("+hero.getJob()+")"+"恢复力+5,恢复力："+hero.getRecovery());
    			break;
    			case 3:
    			damage+=100;
    			hero.setDamage(damage);
    			System.out.println("消费500元成功，您的英雄从骑士精神中悟到天地与自我的统一，获得了象征着最为强大最为尊贵的Excalibur");
    			System.out.println(hero.getName()+"("+hero.getJob()+")"+"攻击力+5,攻击力："+hero.getDamage());
    			break;
    			default:
    			storeFlag=false;
    		}
    	}
    }
    /**
    *stronger方法：使被打败的英雄属性得到提升
    */
    public static void stronger(Hero hero,Random random){
    	String name=randomName(random);
    	int damage=hero.getDamage();
    	int recovery=hero.getRecovery();
    	hero.setName(name);
    	damage+=5;
    	hero.setDamage(damage);
    	recovery+=5;
    	hero.setRecovery(recovery);
    }
    public static String randomName(Random random){
    	String [] nameArray={"胜利奥特曼","戒赌吧老哥","电玩女神狸","三五军体拳","圣母玛利亚"};
    	int i=random.nextInt(5);
    	return nameArray[i];
    }
}
/**
*抽象类Hero
*定义了四个属性：name姓名和blood血量和damage攻击力和recovery恢复力
*定义了三个抽象方法：fight和defense和getJob
*/
abstract class Hero{
	private String name="我是火车王";
	private int blood=100;
	private int damage=10;
	private int recovery=5;
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
	public int getDamage(){
		return damage;
	}
	public void setDamage(int damage){
		this.damage=damage;
	}
	public int getRecovery(){
		return recovery;
	}
	public void setRecovery(int recovery){
		this.recovery=recovery;
	}
	public abstract String getJob();
	/**
	*fight方法：输出攻击方的名字和被攻击方的血量
	*抽象方法attack：被攻击方的血量计算留在子类中去实现
	*/
	public abstract void fight(Hero hero);
	/**
	*defense方法：输出防御方的名字和血量
	*抽象方法recover：防御方的血量计算留在子类中去实现
	*/
	public abstract void defense();
}
interface Iweapon1{
	public abstract int sword();
}
interface Iweapon2{
	public abstract int axe();
}
/**
*类名：Mage
*定义了一个特有属性job，并绑定固有值“法师”
*方法fight：计算被攻击方的血量，并打印输出
*方法defense：计算防御方的血量，并打印输出
*方法sword：返回伤害值
*/
class Mage extends Hero implements Iweapon1{
	private String job="法师";
	public Mage(){}
	public Mage(String name,int blood){
		super(name,blood);
	}
	public String getJob(){
		return job;
	}
	public void fight(Hero hero){
		System.out.print(this.getName()+"("+this.getJob()+")"+"攻击:");
		hero.setBlood(hero.getBlood()-this.sword());
		System.out.print(hero.getName()+"("+hero.getJob()+")"+"-"+this.sword()+",");
		System.out.print(hero.getName()+"("+hero.getJob()+")"+"血量"+hero.getBlood()+"!");
		System.out.println();
	}
	public void defense(){
		System.out.print(this.getName()+"("+this.getJob()+")"+"防御:");
		this.setBlood(this.getBlood()+this.getRecovery());
		System.out.print(this.getName()+"("+this.getJob()+")"+"+"+this.getRecovery()+",");
		System.out.print(this.getName()+"("+this.getJob()+")"+"血量"+this.getBlood()+"!");
		System.out.println();
	} 
	
	public int sword(){
		return this.getDamage();
	}
}
/**
*类名：Hunter
*定义了一个特有属性job，并绑定固有值“猎人”
*方法fight：计算被攻击方的血量，并打印输出
*方法defense：计算防御方的血量，并打印输出
*方法axe：返回伤害值
*/
class Hunter extends Hero implements Iweapon2{
	private String job="猎人";
	public Hunter(){}
	public Hunter(String name,int blood){
		super(name,blood);
	}
	public String getJob(){
		return job;
	}
	public void fight(Hero hero){
		System.out.print(this.getName()+"("+this.getJob()+")"+"攻击:");
		hero.setBlood(hero.getBlood()-this.axe());
		System.out.print(hero.getName()+"("+hero.getJob()+")"+"-"+this.axe()+",");
		System.out.print(hero.getName()+"("+hero.getJob()+")"+"血量"+hero.getBlood()+"!");
		System.out.println();
	}
	public void defense(){
		System.out.print(this.getName()+"("+this.getJob()+")"+"防御:");
		this.setBlood(this.getBlood()+this.getRecovery());
		System.out.print(this.getName()+"("+this.getJob()+")"+"+"+this.getRecovery()+",");
		System.out.print(this.getName()+"("+this.getJob()+")"+"血量"+this.getBlood()+"!");
		System.out.println();
	}
	public int axe(){
		return this.getDamage();
	}
}