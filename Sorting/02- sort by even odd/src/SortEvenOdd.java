import java.util.Arrays;
import java.util.Comparator;

class MyCmp implements Comparator <Integer>{

	public int compare(Integer x, Integer y) {
//		System.out.println("x = " + x + ", y = " + y + " || x%2-y%2 = " + (x%2-y%2));
//		if (x%2 == 0 && y%2 == 0)
//			return 0;
//		if (x%2 == 0 && y%2 > 0)
//			return -1;
//		if (x%2 > 0 && y%2 == 0)
//			return 1;
//		return 0;
		
		return x%2-y%2;
	}
	
}

public class SortEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {5,20,11,4,9};
		Arrays.sort(arr, new MyCmp());
		System.out.println(Arrays.toString(arr));
		
	}

}
