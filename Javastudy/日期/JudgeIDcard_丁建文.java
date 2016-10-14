
import java.util.Scanner;
public class JudgeIDcard{
	public static void main(String[] args) {
	   Scanner input=new Scanner(System.in);
	   while(true){
		System.out.println("输入身份证");
		String str=input.next();
		char [] arr1=str.toCharArray();
		if(judgeChar(arr1)){                                             //judgeChar方法，如果身份证号中带字母会报错
			if(arr1.length!=15&&arr1.length!=18){
			    System.out.println("请输入正确的身份证号");              //身份证号不是15或18位会报错
		    }else if(arr1.length==15){                                   //15位身份证不用判断年份是否输入正确
			    if(judgemonth(arr1)){                                    //judgemonth方法，判断月份和日期，不是1-12月会报错，相应月份中天数不正确也会报错 
			    	print(arr1,str);                                     //输出性别和生日
			    }else{
			    	System.out.println("请输入正确的身份证号（生日）");
			    }
		    }else if(arr1.length==18){                                   //judge18year方法，18位身份证年份不在1900和2016之间会报错
			    if(judge18year(arr1)){                                   //judgemonth方法
			    	if(judgemonth(arr1)){
			    		print(arr1,str);                                 //输出性别和生日
			    	}else{
			    		System.out.println("请输入正确的身份证号（生日）");
			    	}
			    }else{
			    	System.out.println("请输入正确的身份证号（生日）");
			    }
		    }
		}else{
			System.out.println("请输入正确的身份证号");
		}  
		} 
	}
	/*
	*判断输入的身份证号是否含有字母或其他非数字字符
	*/
	public static boolean judgeChar(char [] array){
		boolean flag1=true;
		for(int i=0;i<array.length;i++){
			if(array[i]<48||array[i]>57){
				flag1=false;
				break;
			}
		}
		return flag1;
	}
	/*
	*判断18位身份证年份位是否正确
	*/
	public static boolean judge18year(char [] array){
		int year=(array[6]-48)*1000+(array[7]-48)*100+(array[8]-48)*10+(array[9]-48);
		int month=(array[10]-48)*10+(array[11]-48);
        if(year>2016||year<1900){
        	return false;
        }else{
        	return true;
        }
	}
	/*
	*判断月份位和日期位是否正确
	*/
	public static boolean judgemonth(char [] array){
		int year=0;
		int month=0;
		int day=0;
		boolean isRN=false;
		if(array.length==18){
			month=(array[10]-48)*10+(array[11]-48);
			day=(array[12]-48)*10+(array[13]-48);
			year=(array[6]-48)*1000+(array[7]-48)*100+(array[8]-48)*10+(array[9]-48);
			if((year%400==0)||(year%4==0&&year%100!=0)){
				isRN=true;
			}else{
				isRN=false;
			}
		}else if(array.length==15){
			month=(array[8]-48)*10+(array[9]-48);
			day=(array[10]-48)*10+(array[11]-48);
			year=(array[6]-48)*10+(array[7]-48);
			if((year%4==0)&&(year!=0)){
				isRN=true;
			}else{
				isRN=false;
			}
		}
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
		    case 10:
			case 12:
			if(day>31){
				return false;
			}else{
				return true;
			}
			case 2:
			if(isRN){
				if(day>29){
					return false;
				}else{
					return true;
				}
			}else{
				if(day>28){
					return false;
				}else{
					return true;
				}
			}
			case 4:
			case 6:
			case 9:
			case 11:
			if(day>30){
				return false;
			}else{
				return true;
			}
			default:
			return false;
		}
	}
	/*
	*输出性别和生日
	*/
	public static void print(char []array,String str){
		String birthday=null;
		if(array.length==18){
			birthday=str.substring(6,14);
			if((array[array.length-2]-48)%2==0){
				System.out.println("女性");
				System.out.println("生日："+birthday);
			}else{
				System.out.println("男性");
				System.out.println("生日："+birthday);
			}
		}else if(array.length==15){
			birthday=str.substring(6,12);
			if((array[array.length-1]-48)%2==0){
				System.out.println("女性");
				System.out.println("生日："+"19"+birthday);
			}else{
				System.out.println("男性");
				System.out.println("生日："+"19"+birthday);
			}
		}
	}


}