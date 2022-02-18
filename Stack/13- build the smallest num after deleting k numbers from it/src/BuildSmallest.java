import java.util.Stack;
/*
 * Given a string ‘str’ of digits and an integer 'n', build the lowest possible number 
 * by removing ‘n’ digits from the string and not changing the order of input digits.
 * 
 * Input: str = "4325043", n = 3
 * Output: "2043"
 * 
 * Input: str = "765028321", n = 5
 * Output: "0221"
 * 
 * Input: str = "121198", n = 2
 * Output: "1118"
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class BuildSmallest {
	static String buildLowestNumber(String str, int k) {
		// code here
		StringBuilder result = new StringBuilder();
        
        // We have to delete all digits
        if (k >= str.length()) {
            return "0";
        }
        // Nothing to delete
        if (k == 0) {
            return str;
        }
        Stack<Character> s = new Stack<Character>();
 
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
           
            // Removing all digits in stack that are greater than this digit(since they 
            // have higher weightage)
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                s.pop();
                k--;
            }
            // ignore pushing 0
            if (!s.isEmpty() || c != '0')
                s.push(c);
        }
       
        // If our k isnt 0 yet then we keep popping out the
        // stack until k becomes 0
        while (!s.isEmpty() && k > 0) {
            k--;
            s.pop();
        }
        if (s.isEmpty())
            return "0";
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        String str2 = result.reverse().toString();
 
        return str2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "10056";
		int k = 3;
		System.out.println(buildLowestNumber(s, k));

	}

}
