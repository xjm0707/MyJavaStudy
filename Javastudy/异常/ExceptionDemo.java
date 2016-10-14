public class ExceptionDemo{
	public static void main(String[] args) throws Exception{
		// try{
		// 	float result=MathUtils.div(10,0);
		// 	System.out.println(result);
		// }
		// catch(ArithmeticException e){
		// 	System.out.println("你的除数为0了");
		// 	System.out.println(e.getMessage());
		// 	System.out.println(e.toString());
		// 	e.printStackTrace();
		// }
		// catch(ArrayIndexOutOfBoundsException e){
		// 	System.out.println("数组下标越界了");
		// 	System.out.println(e.getMessage());
		// 	System.out.println(e.toString());
		// 	e.printStackTrace();
		// }
		// System.out.println("over");
		// try{
		// 	float result=MathUtils.div(10,-7);
		// 	System.out.println(result);
		// }
		// catch(Exception e){
		// 	//System.out.println(e.getMessage());
		// 	e.printStackTrace();
		// }
		float result=div(10,-1);
		System.out.println(result);
	}
	public static float div(int a,int b)throws Exception{
		float result=0;
		result=MathUtils.div(a,b);
		return result;
	}
}
class MathUtils{
	// public static float div(int a,int b)throws ArithmeticException,NullPointerException,ArrayIndexOutOfBoundsException{
	// 	int c=arr[a];
	// 	int d=arr[b];
	// 	return a/b;
	// }
	public static float div(int a,int b)throws Exception{
		int[] arr=new int[]{1,2,4,8,9};
		if (b<0) {
			throw new FushuException("除数为负数了");
		}
		if (a>arr.length||b>arr.length) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界了");
		}
		int c=arr[a];
	    int d=arr[b];
	    if (b==0) {
	    	throw new ArithmeticException("你的除数为0了");
	    }
	    return a/b;
	}
}
//自定义异常
//直接继承Exception 使用时要声明异常
class FushuException extends Exception{
	public FushuException(String message){
		super(message);
	}
}
//直接继承RuntimeException 使用时不用申明异常
class FushuException1 extends RuntimeException{
	public FushuException1(String message){
		super(message);
	}
}