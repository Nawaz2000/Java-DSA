import java.util.Arrays;
/*
 * Merge two sorted arrays without using extra space
 * 
 * i/p:
 * a[] = {10,40,80,90,100}
 * b[] = {4,6,50}
 * 
 * o/p:
 * a[] = [4, 6, 10, 40, 50]
 * b[] = [80, 90, 100]
 * 
 * Idea:
 * a[] will store all the smaller elements while b[] stores all the left out larger
 * elements.
 * For each iteration move from left to right of a[] and 
 * if b[0]<a[i], then 
 * swap(b[0],a[i]). Now b[] is unsorted. So rearrange b[]. 
 * Else
 * i++;
 * 
 * Time complexity: O(n*m)
 * Auxiliary space: O(1)
 * 
 */
public class MergeSorted {

	public static void swap(int[] a, int[] b, int i, int j) {
		int temp = a[i];
		a[i] = b[j];
		b[j] = temp;
	}
	
	public static void arrange(int[] b, int m) {
		for (int i=0; i<m-1; i++) {
			if (b[i] > b[i+1])
				swap(b, b, i, i+1);
		}
	}
	
	public static void mergeTwoSorted(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;
		
		int i=0, j=0;
		while (i<n && j<m) {
			if (b[j] < a[i]) {
				swap(a, b, i, j);
				arrange(b, m);
			}else {
				i++;
			}
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10,40,80,90,100};
        int b[] = {4,6,50};       
        mergeTwoSorted(a, b);

	}

}
