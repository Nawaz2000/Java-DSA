import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/*
 * Given an array consisting of names of candidates. Each occurrence of a name denotes
 * the number of vote given to that candidate. Find the name of the candidate with max
 * votes. If two or more candidates have the the same number of votes, return the name
 * which ranks first lexicographically 
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class MyString {
	public static String TieBreak(String names[], int n)
	{
	    HashMap<String, Integer> map = new HashMap<>();
	    for (String curr : names)
	        map.put(curr, map.getOrDefault(curr,0) + 1);
	    
	    int maxCount = -1;
	    for (String x : map.keySet()){
	        int currCount = map.get(x);
	        if (currCount > maxCount)
	            maxCount = currCount;
	    }
	    
	    ArrayList<String> list = new ArrayList<>();
	    
	    for (String x : map.keySet()){
	        int currCount = map.get(x);
	        if (currCount == maxCount)
	            list.add(x);
	    }
	    
	    Collections.sort(list);
	    return list.get(0);
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
