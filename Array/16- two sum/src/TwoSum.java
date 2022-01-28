import java.util.Arrays;
import java.util.HashMap;
/*
 * returns the indexes of two numbers in array whose sum equals target
 * 
 * Time complexity: O(n)
 */
public class TwoSum {

	public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        Arrays.fill(res,-1);
        
        for (int i=0; i<arr.length; i++){
            Integer y = target-arr[i];
            Integer x = arr[i];
            System.out.println("x="+x+", y="+y);
            if (map.containsKey(y)){
                res[0] = map.get(y);
                res[1] = i;
                break;
            }else
                map.put(x, Integer.valueOf(i));
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,7,11,15};
		int target = 9;
		int[] res = twoSum(arr, target);
		System.out.println(Arrays.toString(res));

	}

}
