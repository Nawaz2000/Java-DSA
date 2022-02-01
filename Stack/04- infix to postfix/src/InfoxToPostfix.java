import java.util.ArrayDeque;
/*
 * Convert a given infix expression into postfix
 * 
 * Idea:
 * 1. Scan the infix expression from left to right. 
 * 2. If the scanned character is an operand, output it. 
 * 3. Else, 
 *       1 If the precedence of the scanned operator is greater than the precedence of the 
 *       operator in the stack(or the stack is empty or the stack contains a ‘(‘ ), push it. 
 *       2 Else, Pop all the operators from the stack which are greater than or equal to in 
 *       precedence than that of the scanned operator. After doing that Push the scanned 
 *       operator to the stack. (If you encounter parenthesis while popping then stop there 
 *       and push the scanned operator in the stack.) 
 * 4. If the scanned character is an ‘(‘, push it to the stack. 
 * 5. If the scanned character is an ‘)’, pop the stack and output it until a ‘(‘ is encountered, and discard both the parenthesis. 
 * 6. Repeat steps 2-6 until infix expression is scanned. 
 * 7. Print the output 
 * 8. Pop and output from the stack until it is not empty.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class InfoxToPostfix {
	
	// returns precedence of an operator
	public static int precedence(char c) {
		switch (c) {
			case '+':
			case '-':
				return 1;
			case '*':
			case '/':
				return 2;
			case '^':
				return 3;
			default:
				return -1;
		}
	}
	
	public static String convert(String str) {
		String res = "";
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		
		char[] arr = str.toCharArray();
		for (int i=0; i<arr.length; i++) {
			char c = arr[i];
			// if c is an alphabet, insert it into resultant string
			if (c >= 97 && c <= 122) 
				res = res + c;
			else {
				// if stack is empty, push c into stack
				if (stack.isEmpty())
					stack.push(c);
				// if closing bracket is encountered, pop till opening bracket is found
				else if (c == ')') {
					while (!stack.isEmpty() && stack.peek() != '(')
						res = res + stack.pop();
					stack.pop(); // pops the opening bracket
				}else {
					int currPrec = precedence(c);
					int topPrec = precedence(stack.peek());
					
					// if precedence of curr character is greater than top, push into stack
					if (currPrec > topPrec)
						stack.push(c);
					else {
						// else pop till precedence of top is less than that of curr
						while (currPrec <= topPrec && c != '(') {							
							res = res + stack.pop();
							if (!stack.isEmpty()) {
								currPrec = precedence(c);
								topPrec = precedence(stack.peek());
							}else
								break;
						}
						// when top is less than curr, push curr
						stack.push(c);
					}
				}
			}
		}
		
		while (!stack.isEmpty())
			res = res + stack.pop();
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(a+b)*(c+d)";
		System.out.println("Given string: " + str);
		System.out.println("Postfix string: " + convert(str));

	}

}
