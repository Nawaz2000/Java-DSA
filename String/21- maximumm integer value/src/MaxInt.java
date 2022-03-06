import java.math.BigInteger;
/*
 * Given a string S of digits(0-9).Find the maximum value that can be obtained from 
 * the string by putting either '*' or '+' operators in between the digits while 
 * traversing from left to right of the string and picking up a single digit at a 
 * time.
 * 
 * Input: 
 * S="01230"
 * Output: 
 * 9
 * 
 * Time complexity: O(n)
 */
public class MaxInt {
	public static BigInteger maxValue(String s)
	{
		BigInteger sum = BigInteger.valueOf(Long.parseLong(s.charAt(0) + ""));
	    if (s.length() == 1)
	    	return BigInteger.valueOf(Long.parseLong(s));
	    else {
	    	for (int i=1; i<s.length(); i++) {
	    		BigInteger curr = BigInteger.valueOf(Long.parseLong(s.charAt(i)+""));
	    		BigInteger prev = sum;
	    		int res = curr.multiply(prev).compareTo(curr.add(prev));
	    		if (res == 1)
	    			sum = curr.multiply(prev);
	    		else
	    			sum = curr.add(prev);
	    	}
	    	return sum;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
