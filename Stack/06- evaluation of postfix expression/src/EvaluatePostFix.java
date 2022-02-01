import java.util.ArrayDeque;
/*
 * Given string S representing a postfix expression, the task is to evaluate the 
 * expression and find the final value. Operators will only include the basic arithmetic 
 * operators like *, /, + and -.
 * 
 * Input: S = "231*+9-"
 * Output: -4
 * 
 * Idea: 
 * loop through the string. If current character is a number, push it into stack
 * else pop last two elements from the string and apply the current operator
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class EvaluatePostFix {
	public static int evaluate(String str) {
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if (Character.isDigit(c))
				stack.push(Character.getNumericValue(c));
			else {
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				int res = 0;
				
				if (c == '*')
					res = temp1*temp2;
				else if (c == '+')
					res = temp1+temp2;
				else if (c == '/')
					res = temp2/temp1;
				else if (c == '-')
					res = temp2 - temp1;
				else if (c == '^')
					res = (int)Math.pow(temp2, temp1);
				stack.push(res);
			}
		}
		
		return stack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "231*+9-";
		System.out.println(evaluate(str));

	}

}
