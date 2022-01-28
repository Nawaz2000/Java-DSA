import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Find and replace pattern
 * 
 * Given a list of strings words and a string pattern, return a list of words[i] that 
 * match pattern. You may return the answer in any order.
 * 
 * A word matches the pattern if there exists a permutation of letters p so that 
 * after replacing every letter x in the pattern with p(x), we get the desired word.
 * 
 * Recall that a permutation of letters is a bijection from letters to letters: every 
 * letter maps to another letter, and no two letters map to the same letter.
 * 
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * 
 * Time complexity: O(n*m)
 * Auxiliary space: O(n*m)
 */

public class FindAndReplacePattern {

	public static int[] code(String x){
		HashMap<Character, Integer> m = new HashMap<>();
        int n = x.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(x.charAt(i), m.size());
            res[i] = m.get(x.charAt(i));
        }
        return res;
    }
    
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] patCode = code(pattern);
        List<String> list = new ArrayList<String>();
        
        for (String currString: words){
            if (currString.length() == pattern.length()){
            	int[] currCode = code(currString);
                if (Arrays.equals(patCode, currCode))
                    list.add(currString);
            }
        }
        
        return list;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		List<String> res = findAndReplacePattern(words, pattern);
		System.out.println(Arrays.toString(res.toArray()));

	}

}
