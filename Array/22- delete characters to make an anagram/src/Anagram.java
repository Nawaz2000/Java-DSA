/*
 * Given two strings S1 and S2 in lowercase, the task is to make them anagram. The 
 * only allowed operation is to remove a character from any string. Find the minimum 
 * number of characters to be deleted to make both the strings anagram. Two strings 
 * are called anagram of each other if one of them can be converted into another by 
 * rearranging its letters.
 * 
 * Input:
 * S1 = bcadeh
 * S2 = hea
 * Output: 3
 * Explanation: We need to remove b, c
 * and d from S1.
 * 
 * Time complexity: O(max(n,m))
 * Auxiliary space: O(1)
 */
public class Anagram {
	public static int remAnagrams(String s,String s1)
    {
        //add code here.
        int[] countS = new int[256];
        int[] countS1 = new int[256];
        
        for (char c : s.toCharArray())
            countS[c]++;
        
        for (char c : s1.toCharArray())
            countS1[c]++;
            
        int n = s.length();
        int m = s1.length();      
        
        int res = 0;
        
        if (n > m){
            for (int i=0; i<256; i++)
                res += Math.abs(countS[i]-countS1[i]);
        }else{
            for (int i=0; i<256; i++)
                res += Math.abs(countS1[i]-countS[i]);
        }
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "basgadhbfgvhads";
		String s2 = "sjdhgvbjdsbhvbvd";
		System.out.println(remAnagrams(s, s2));
				
	}

}
