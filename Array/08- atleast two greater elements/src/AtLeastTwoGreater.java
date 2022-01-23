/*
 * Given an array of n distinct elements, the task is to find all elements in array 
 * which have at-least two greater elements than themselves.
 * 
 * Input : arr[] = {2, 8, 7, 1, 5};
 * Output : 2  1  5  
 * Explanation:
 * The output three elements have two or more greater elements
 * 
 * Explanation:
 * Input  : arr[] = {7, -2, 3, 4, 9, -1};
 * Output : -2  3  4 -1  
 * 
 * Idea1 O(n):
 * traverse the array, find max and secondMax. Traverse the array again and print all
 * numbers smaller than second max
 * 
 * Idea2 O(nlogn):
 * By sorting the array and then traversing with if (arr[i] > arr[i-1]) till i<(n-1)
 */
public class AtLeastTwoGreater {

	public static void atLeastTwoGreater(int[] arr) {
		int n = arr.length;
		int max = arr[0];
		int secMax = max;
		
		for (int i=1; i<n; i++) {
			if (arr[i] > max)
				max = arr[i];
			else if (arr[i] > secMax)
				secMax = arr[i];
		}
		
		for (int i : arr) {
			if (i<secMax)
				System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, -2, 3, 4, 9, -1};
		atLeastTwoGreater(arr);

	}

}
