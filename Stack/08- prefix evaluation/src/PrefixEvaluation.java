import java.util.ArrayDeque;
/*
 * Evaluate a prefix expression
 * 
 * Input string: +9*26
 * Output: 21.0
 * 
 * Idea:
 * 1. traverse the array from the end.
 * 2. if c is a number, push it into stack
 * 3. if it is an operator, pop two elements from the stack and perform the operation on them
 * 4. push the above result into stack
 * 5. return the top
 */
public class PrefixEvaluation {
	public static double evaluate(String str) {
		ArrayDeque<Double> stack = new ArrayDeque<>();
		
		for (int i=str.length()-1; i>=0; i--) {
			char c = str.charAt(i);
//			System.out.println("curr: " + c);
			if (Character.isDigit(c))
				stack.push((double)Character.getNumericValue(c));
			
			else {
				double top1 = stack.pop();
				double top2 = stack.pop();
//				System.out.println("top1: " + top1 + ", top2: " + top2);
				
				if (c == '+')
					stack.push(top1 + top2);
				else if (c == '-')
					stack.push(top2 - top1);
				else if (c == '*')
					stack.push(top2*top1);
				else if (c == '/')
					stack.push(top2/top1);
				else if (c == '^')
					stack.push((double)Math.pow(top2, top1));
			}
		}
		return stack.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "+9*26";
		System.out.println("Input string: " + str);
		System.out.println("Output: " + evaluate(str));

	}

}
