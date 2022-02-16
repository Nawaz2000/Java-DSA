import java.util.Arrays;
/*
 * Given an array A[] of N positive integers. The task is to find the maximum of 
 * j - i subjected to the constraint of A[i] < A[j] and i < j.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class MaxIndex {
	static int maxIndexDiff(int arr[], int N) { 
        int[] leftMin = new int[N]; leftMin[0] = arr[0];
        int[] rightMax = new int[N]; rightMax[N-1] = arr[N-1];
        
        for (int i=1; i<N; i++){
            if (arr[i] < leftMin[i-1])
                leftMin[i] = arr[i];
            else
                leftMin[i] = leftMin[i-1];
        }
        
        for (int i=N-2; i>=0; i--){
            if (arr[i] > rightMax[i+1])
                rightMax[i] = arr[i];
            else
                rightMax[i] = rightMax[i+1];
        }
//        System.out.println(Arrays.toString(leftMin));
//        System.out.println(Arrays.toString(rightMax));
        
        int i = 0;
        int j = 0;
        int maxDiff = -1;
        while (j < N && i < N) {
            if (leftMin[i] <= rightMax[j]) {
                if (maxDiff < j-i)
                    maxDiff = j-i;
                j = j + 1;
            }
            else
                i = i + 1;
        }
 
        return maxDiff;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(maxIndexDiff(arr, arr.length));

	}

}
