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
		// initializing empty String for result
        String result = new String("");
         
        // initializing empty stack
        ArrayDeque<Character> stack = new ArrayDeque<>();
         
        for (int i = 0; i<str.length(); ++i)
        {
            char c = str.charAt(i);
             
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
              
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);
             
            //  If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')')
            {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();
                 
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(c)
                         <= precedence(stack.peek())){
                   
                    result += stack.pop();
             }
                stack.push(c);
            }
      
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
         }
        return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(a+b)*(c+d)";
		System.out.println("Given string: " + str);
		System.out.println("Postfix string: " + convert(str));

	}

}
