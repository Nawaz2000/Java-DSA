/*
 * Given an array of names (consisting of lowercase characters) of candidates in 
 * an election. A candidate name in array represents a vote casted to the candidate. 
 * Print the name of candidate that received Max votes. If there is tie, print 
 * lexicographically smaller name.
 * 
 * Input:
 * n = 13
 * Votes[] = {john,johnny,jackie,johnny,john 
 * jackie,jamie,jamie,john,johnny,jamie,
 * johnny,john}
 * 
 * Output: john 4
 * 
 * Explanation: john has 4 votes casted for 
 * him, but so does johny. john is 
 * lexicographically smaller, so we print 
 * john and the votes he received.
 */

import java.util.Arrays;
import java.util.LinkedHashMap;

public class WinnerOfElection {

	public static String[] winner(String arr[], int n)
    {
        // add your code
        Arrays.sort(arr);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr)
            map.put(s, map.getOrDefault(s,0) + 1);
            
        int maxCount = -1;
        String winner = "";
        
        for (String x : map.keySet()){
            if (map.get(x) > maxCount){
                maxCount = map.get(x);
                winner = x;
            }
        }
        
        return new String[]{winner, Integer.toString(maxCount)};
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13;
		String Votes[] = {"john","johnny","jackie","johnny","john", 
				"jackie","jamie","jamie","john","johnny","jamie",
				"johnny","john"};
		
		String[] res = winner(Votes, n);
		System.out.println(res[0] + " " + res[1]);

	}

}
