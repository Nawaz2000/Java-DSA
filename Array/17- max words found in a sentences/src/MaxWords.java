/*
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.
 * Return the maximum number of words that appear in a single sentence.
 * 
 * Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
 * Output: 6
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */

public class MaxWords {

	public static int mostWordsFound(String[] sentences) {
        int maxCount = 0;
        for (String currString : sentences){
            String[] arrWords = currString.split(" ");
            int currCount = arrWords.length;
            if (currCount > maxCount)
                maxCount = currCount;
        }
        return maxCount;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
