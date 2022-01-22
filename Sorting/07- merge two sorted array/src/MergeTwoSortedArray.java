import java.util.Arrays;
/*
 * Given two sorted arrays, we have to merge those arrays such that the resultant is
 * also a sorted array
 * 
 * i/p:
 * arr1 = {1,2,3,5,6}
 * arr2 = {2,4,7,8,9}'
 * 
 * o/p: [1, 2, 2, 3, 4, 5, 6, 7, 8, 9]
 * 
 * Time complexity: O(m+n)
 * Auxiliary space: O(m+n)
 */
public class MergeTwoSortedArray {

	public static int[] merge(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[] res = new int[n1+n2];
		
		// i-> for traversing arr1, j-> for traversing arr2
		int i=0, j=0, resIte=0;
		while(i<n1 && j<n2) {
			if (arr1[i] <= arr2[j])
				res[resIte++] = arr1[i++];
			else if (arr1[i] >= arr2[j])
				res[resIte++] = arr2[j++];			
		}
		
		// adding the left out elements into the resultant array
		int start = (i+j);
		if (i<n1) {
			for (; i<n1; i++)
				res[start++] = arr1[i];
		}else {
			System.out.println("2nd");
			for (; j<n2; j++)
				res[start++] = arr2[j];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3,5,6};
		int[] arr2 = {2,4,7,8,9};
		int[] res = merge(arr1, arr2);
		System.out.println(Arrays.toString(res));

	}

}
