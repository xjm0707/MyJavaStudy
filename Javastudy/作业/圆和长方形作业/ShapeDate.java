/**
*测试类
*用于计算圆形和长方形的周长和面积
*
*/
public class ShapeDate
{
	public static void main(String[] args) 
	{
		Shape a=new Circle(3);
		Shape b=new Rectangle(2,3);
		getInfo(a);
		getInfo(b);
	}
	public static void getInfo(Shape shape)
	{
        shape.getArea();
		shape.getPer();
	} 
}
/**
*父类（抽象类） 
*   Shape 形状类
*   抽象方法 getArea(计算面积)  getPer(计算周长)
*/
abstract class Shape
{
    int per;
    int area;

    abstract void getArea();
    abstract void getPer();
}
/**
*子类 Circle 圆形
*    radius 半径
*    Math.PI 
*/
class Circle extends Shape
{
    private int radius;
    public Circle(){}
    public Circle(int radius)
    {
        this.radius=radius;
    }                                          //写构造方法，创建对象的时候再初始化
    void getArea()
    {
        area=(int)Math.PI*radius*radius;//将double类型强转为int类型
        System.out.println("圆面积为："+area); 
    }
    void getPer()
    {
        per=2*(int)Math.PI*radius;
        System.out.println("圆周长为："+per);
    }
}
/**
*子类 Rectangle 长方形
*     length 长
*     width 宽
*/
class Rectangle extends Shape
{
	private int length;                                           //同上
	private int width;
    public Rectangle(){}
    public Rectangle(int length,int width)
    {
        this.length=length;
        this.width=width;
    }
	void getArea()
	{
        area=length*width;
        System.out.println("长方形面积为"+area);
	}
    void getPer()
    {
        per=2*(length+width);
        System.out.println("长方形周长为："+per);
    }
}