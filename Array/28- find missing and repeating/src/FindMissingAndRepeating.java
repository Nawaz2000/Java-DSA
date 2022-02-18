/*
 * Given an unsorted array Arr of size N of positive integers. One number 'A' from 
 * set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these 
 * two numbers.
 * 
 * Input:
 * N = 3
 * Arr[] = {1, 3, 3}
 * Output: 3 2
 * Explanation: Repeating number is 3 and 
 * smallest positive missing number is 2.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class FindMissingAndRepeating {
	static int[] findTwoElement(int arr[], int n) {
        // code here
		int [] ar=new int [n];
        int [] ans = new int [2];
        for(int i =0 ; i< n ; i++){
            ar[arr[i]-1]++;
        }
        for(int i=0 ; i<n ; i++){
            if(ar[i]==2){
                ans[0]=i+1;
                break;
            }
        }
        for(int i = 0 ; i<n ; i++){
            if(ar[i]==0){
                ans[1]=i+1;
                break;
            }
        }
        return ans;
  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {13, 33, 43, 16, 25, 19, 23, 31, 29, 35, 10, 2, 32, 11, 47, 15, 
				34, 46, 30, 26, 41, 18, 5, 17, 37, 39, 6, 4, 20, 27, 9, 3, 8, 40, 
				24, 44, 14, 36, 7, 38, 12, 1, 42, 12, 28, 22, 45};
		int[] res = findTwoElement(arr, arr.length);
		System.out.println("Missing: " + res[1] + ", repeating: " + res[0]);

	}

}
