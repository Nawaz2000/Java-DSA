import java.util.Arrays;
import java.util.Collections;

public class LargestRect {
	

//	public static int largestRectangleArea(int[] arr) {
//		int min = arr[0];
//		int start = 0;
//		int rectArea = arr[0];
//
//		for (int i = 0; i<arr.length; i++) {
//			min = arr[i]; start = i;
//			for (int j = i; j<arr.length; j++) {
//				if (arr[j] < min)
//					min = arr[j];
//				int currArea = (j-start+1)*min;
//				
//				if (currArea>rectArea)
//					rectArea = currArea;
//			}
//		}
//		
//		
//		
//		return rectArea;
//
//	}
	
	
	
	
	
	
	
	public static int find(int arr[]) {
		int min = arr[0];
		int start = 0;
		int end = 0;
		int rectArea = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int currEle = arr[i];
			int currMin = min;
			if (currEle < min) {
				currMin = currEle;
				min = currMin;
			}

			// System.out.println("currMin: " + currMin);

			int currArea = (i - start + 1) * currMin;

			if (currArea > rectArea) {
				rectArea = currArea;
				end = i;
				min = currMin;
			}
			
			

			if (currEle > rectArea) {
				rectArea = currEle;
				start = i;
				end = i;
				min = currEle;
			}
		}

		System.out.println("start: " + start + " end: " + end + " min: " + min);
		
		
		
		return rectArea;
	}

	public static int largestRectangleArea(int[] arr) {
		int res = find(arr);
		arr = reverse(arr, arr.length);
		int resRev = find(arr);
		if (res > resRev)
			return res;
		else
			return resRev;

	}
	
	public static int[] reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
  
        // printing the reversed array
//        System.out.println("Reversed array is: \n");
//        for (k = 0; k < n; k++) {
//            System.out.println(a[k]);
//        }
        return a;
    }
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1,2,3,4,5 };
		System.out.println(largestRectangleArea(arr));

	}

}
