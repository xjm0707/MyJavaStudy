/**
*构造函数
*
*
*/
public class Bookstest{
	public static void main(String[] args) {
		Books b=new Books();
		Books b1=new Books("语文",201);
		Books b2=new Books("数学",190);

		b1.detail();
		b2.detail();		
	}
}
class Books{
	private String title;
	private int pageNum;
	public Books(){
	}
	public Books(String title){
        this.title=title;
	}
	public Books(String title,int pageNum){
		this(title);
		this.setpageNum(pageNum);		
	}
	public void detail(){
		System.out.println("名称："+title+" "+"页数："+pageNum);
	}
	public void setpageNum(int pageNum){	
		if(pageNum>200){
			this.pageNum=pageNum;
		}
		else{
			this.pageNum=200;
		}	
	}
	public int getpageNum(){
		return this.pageNum;
	}
}