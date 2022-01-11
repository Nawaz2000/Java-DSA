import java.util.HashSet;

/*
 * You are given an array of distinct integers and a sum. Check if there's a pair 
 * with the given sum in the array.
 * 
 * Input:
 * N = 10
 * arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} 
 * sum = 14
 * Output: 
 * 1 (returns 1 or 0)

 * Explanation: 
 * arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} 
 * and sum = 14.  There is a pair {4, 10} 
 * with sum 14.
 */

public class FindPairWithGivenSum {

	public static int sumExists(int arr[], int N, int sum) {
        // Your code here, Geeks
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
            
        int count = 0;    
        for (int i : arr){
        	HashSet<Integer> set2 = (HashSet<Integer>) set.clone();
        	set2.remove(i);
            if (set2.contains(sum - i))
            {
            //	System.out.println("f1: " + i + " f2: " + (sum-i));
                count = 1;
                break;
            }
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 14;
		
		System.out.println(sumExists(arr, N, sum));

	}

}
