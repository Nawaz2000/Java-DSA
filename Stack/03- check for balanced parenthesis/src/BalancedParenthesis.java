import java.util.ArrayDeque;
/*
 * Given a string containing parenthesis, check if it is balanced
 * 
 * Input: exp = “[(])” 
 * Output: Not Balanced 
 * 
 * Idea: use a stack
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class BalancedParenthesis {
	public static boolean checker(Character c1, Character c2) {
		return ((c1=='(' && c2==')') ||
				(c1=='{' && c2=='}') ||
				(c1=='[' && c2==']'));
	}
	
	public static boolean parenthesisCheck(String str) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (Character c : str.toCharArray()) {
			if (stack.isEmpty())
				stack.push(c);
			else {
				Character top = stack.peek();
				if (checker(top, c))
					stack.pop();
				else
					stack.push(c);
			}
		}
		if (stack.size() == 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "{}[()]";
		System.out.println("Given string: \"" + str + "\"");
		System.out.println("Is balanced: " + parenthesisCheck(str));

	}

}
