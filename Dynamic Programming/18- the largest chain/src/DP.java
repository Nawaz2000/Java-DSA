import java.util.Arrays;
import java.util.Comparator;
/*
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the 
 * second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be 
 * formed in this fashion. You have to find the longest chain which can be formed from the given 
 * set of pairs. 
 * 
 * Input:
 * N = 5
 * P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
 * Output: 3
 * Explanation: The given pairs are { {5, 24}, {39, 60},
 * {15, 28}, {27, 40}, {50, 90} },the longest chain that
 * can be formed is of length 3, and the chain is
 * {{5, 24}, {27, 40}, {50, 90}}
 * 
 * Idea:
 * 1) Sort given pairs in increasing order of first (or smaller) element. Why do not need 
 * sorting? Consider the example {{6, 8}, {3, 4}} to understand the need of sorting. If we 
 * proceed to second step without sorting, we get output as 1. But the correct output is 2. 
 * 
 * 2) Now run a modified LIS process where we compare the second element of already finalized 
 * LIS with the first element of new LIS being constructed. 
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(n)
 */
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class compareByFirst implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        return a.x - b.x;
    }
}

public class DP {
	static int maxChainLength(Pair arr[], int n)
    {
       int[] lis = new int[n];
       lis[0] = 1;
       
       Arrays.sort(arr, new compareByFirst());
       
       // finds LIS
       for (int i=1; i<n; i++){
           int max = Integer.MIN_VALUE;
           for (int j=0; j<i; j++){
               if (arr[j].y < arr[i].x)
            	   if (lis[j] > max)
            		   max = lis[j];
           }
           if (max != Integer.MIN_VALUE)
        	   lis[i] = max+1;
           else
        	   lis[i] = 1;
       }
       
       // returns the max value
       int maxChain = Integer.MIN_VALUE;
       for (int i : lis) {
    	   if (i > maxChain)
    		   maxChain = i;
       }
       
//       System.out.println(Arrays.toString(arr));
//       System.out.println(Arrays.toString(lis));
       
       return maxChain;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair arr[] = new Pair[]
		        {
		          new Pair(5,24),
		          new Pair(15, 25),                     
		          new Pair (27, 40),
		          new Pair(50, 60)};
		
		System.out.println(maxChainLength(arr, arr.length));

	}

}
