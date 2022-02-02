import java.util.ArrayDeque;
/*
 * Infix to prefix
 * 
 * Idea: commented below
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
public class InfixToPrefix {
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
		StringBuilder prefix = new StringBuilder("");
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for (int i=str.length()-1; i>=0; i--) {
			char c = str.charAt(i);
			
			// append alphabets to prefix
			if (c>=97 && c<=122)
				prefix.append(c);
			
			// push closing brackets to stack
			else if (c == ')')
				stack.push(c);
			
			// if opening bracket is encountered, pop and append to prefix till ending
			// bracket is encountered
			else if (c == '(') {
				while (stack.peek() != ')')
					prefix.append(stack.pop());
				stack.pop();
			}
			
			// here if stack is empty and c is an operator, push c into stack
			else if (stack.isEmpty())
				stack.push(c);
			// here c is an operator and stack is not empty
			else {
				int currPrec = precedence(c);
				int topPrec = precedence(stack.peek());
				
				// if currPrec > topPrec, then push c into stack
				if (currPrec > topPrec)
					stack.push(c);
				else {
					// pop until currPrec > topPrec and after that,  push c to stack
					while (!stack.isEmpty() && topPrec > currPrec) {
						prefix.append(stack.pop());
						
						if (!stack.isEmpty()) {
							currPrec = precedence(c);
							topPrec = precedence(stack.peek());
						}else
							break;
					}
					stack.push(c);
				}
			}
			
//			System.out.println(prefix);
		}
		
		while (!stack.isEmpty())
			prefix.append(stack.pop());
		
		return prefix.reverse().toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a+b/c-w*y";
		System.out.println("Input string: " + str);
		System.out.println("Prefix string: " + convert(str));

	}

}
