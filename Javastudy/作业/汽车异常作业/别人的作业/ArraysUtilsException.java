public class ArraysUtilsException{
	public static void main(String[] args) {
		int[] arr1=null;
		int[] arr2={1,2,3,4,5,6,7,8,9,10};
		try{
			new SuperArraysUtils().selectSort(arr1);
		}catch (ArraysNullException e) {
			e.printStackTrace();
		}
		try{
			new SuperArraysUtils().bubbleSort(arr1);
		}catch (ArraysNullException e) {
			e.printStackTrace();
		}
		try{
			new SuperArraysUtils().insertionSort(arr1);
		}catch (ArraysNullException e) {
			e.printStackTrace();
		}
		try{
			new SuperArraysUtils().halfSearch(arr2,0);
		}catch (ArraysNullException e) {
			e.printStackTrace();
		}catch (ArraysNotFoundException e) {
			e.printStackTrace();
		}
	}
}
class SuperArraysUtils{
	public void selectSort(int[] arr){//选择排序
		if (arr==null) {
			throw new ArraysNullException("数组空了");
		}
		for (int i=0;i<arr.length-1;i++ ) {
			for (int j=i+1;j<arr.length;j++ ) {
				if (arr[i]>arr[j]) {
					int temp;
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public void bubbleSort(int[] arr){//冒泡排序
		if (arr==null) {
			throw new ArraysNullException("数组空了");
		}
		for (int i=0;i<arr.length-1;i++ ) {
			for (int j=0;j<arr.length-1-i;j++ ) {
				if (arr[j]>arr[j+1]) {
					int temp;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public void insertionSort(int[] arr){//插入排序
		if (arr==null) {
			throw new ArraysNullException("数组空了");
		}
		for (int i=1;i<arr.length ;i++ ) {
			int temp=arr[i];
			int j=i;
			while (j>0&&temp<arr[j-1]) {
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=temp;
		}
	}
	public static int halfSearch(int[] arr,int x){//二分查找
		if (arr==null) {
			throw new ArraysNullException("数组空了");
		}
		for (int i=0;i<arr.length ;i++ ) {
			if (x!=arr[i]) {
				throw new ArraysNotFoundException("这个数不在数组中");
			}
		}
		int min=0;
		int max=arr.length-1;
		int mid;
		while (min<=max) {
			mid=(min+max)/2;
			if (x>arr[mid]) {
				min=mid+1;
			}else if (x<arr[mid]) {
				max=mid-1;
			}else {
				return mid;
			}
		}
		return min;
	}
}
class ArraysNullException extends RuntimeException{
	public ArraysNullException(String message){
		super(message);
	}
}
class ArraysNotFoundException extends RuntimeException{
	public ArraysNotFoundException(String message){
		super(message);
	}
}