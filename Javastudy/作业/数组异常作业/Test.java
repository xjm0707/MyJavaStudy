//数组异常的测试类
public class Test{
	public static void main(String[] args)throws Exception{
		SuperArrayUtils a=new SuperArrayUtils();
		int[] arr=null;
		try{
            a.selectSort(arr);
            for (int i=0;i<arr.length;i++) {
            	System.out.print(arr[i]+" ");	
            }
		}
		catch (NullPointerException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		int[] arr2=null;
		try{
			a.bubbleSort(arr2);
			for (int i=0;i<arr.length;i++) {
            	System.out.print(arr[i]+" ");	
            }
		}
		catch (NullPointerException e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}

		int[] arr3={1,2,5};
		int x=3;
		try{
			int b=a.halfSerch(arr3,x);
			System.out.println(b);
		}
		catch (NoFindException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}

	}
}