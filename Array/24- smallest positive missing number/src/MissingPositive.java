import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/*
 * You are given an array arr[] of N integers including 0. The task is to find the 
 * smallest positive number missing from the array.
 * 
 * Input:
 * N = 5
 * arr[] = {0,-10,1,3,-20}
 * Output: 2
 * Explanation: Smallest positive missing 
 * number is 2.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class MissingPositive {
	static int missingNumber(int arr[], int size)
    {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i : arr){
            if (i>max)
                max = i;
            set.add(i);
        }
        
        for (int i=1; i<=max; i++){
            if (!set.contains(i))
                return i;
        }
        
        return max+1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		System.out.println("Smallest positive missing: " + missingNumber(arr, arr.length));
		String s = "0.0.0.0.";
		if (s.charAt(0) == '.')
			s = s.substring(1);
		if (s.charAt(s.length()-1) == '.')
			s = s.substring(0, s.length()-1);
		System.out.println(s);
		String[] t = s.split(Pattern.quote("."));
		System.out.println(t.length);
	}

}
