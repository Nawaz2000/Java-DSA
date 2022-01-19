
public class Longest {

	public static int longestNonRepeatingSubstring(String str) {
		String test = "";
		 
        // Result
        int maxLength = -1;
 
        if (str.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);
 
            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current)
                                      + 1);
            }
            test = test + String.valueOf(c);
            maxLength = Math.max(test.length(), maxLength);
        }
 
        return maxLength;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "dvdf";
		int ans = longestNonRepeatingSubstring(str);
		System.out.println("\n" + ans);

	}

}
