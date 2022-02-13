import java.util.Stack;
/*
 * Return min element from stack in O(1) time
 * 
 * Idea:
 * Use and aux stack which inserts the min element every time insertion occurs
 * if x >= minStack.peek()
 * 	insert the peek into minStack, x into s
 * else
 * 	insert x into minStack and s
 * 
 * Time complexity: O(1)
 * Auxiliary space: O(n)
 */
public class MinEleInStack {
	static int minEle;
    static Stack<Integer> s = new Stack<Integer>();
    static Stack<Integer> minStack = new Stack<Integer>();

    // returns min element from stack
    static int getMin()
    {
	    if (s.isEmpty())
	    	return -1;
	    return minEle;
    }
    
    // returns popped element from stack
    static int pop()
    {
	    if (s.isEmpty())
	    	return -1;
	    minStack.pop();
	    if (!minStack.isEmpty())
	    	minEle = minStack.peek();
	    return s.pop();
    }

    // push element x into the stack
    static void push(int x)
    {
	    if (s.isEmpty()) {
	    	s.push(x);
	    	minStack.push(x);
	    	minEle = minStack.peek();
	    }else {
	    	s.push(x);
	    	if (x >= minEle)
	    		minStack.push(minEle);
	    	else
	    		minStack.push(x);
	    	minEle = minStack.peek();
	    }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(18);
		push(19);
		push(29);
		push(15);
		push(16);
		for (int x : s)
			System.out.print(x + " ");
		System.out.println();
		for (int x : minStack)
			System.out.print(x + " ");
		System.out.println();
		System.out.println("Min: " + minEle);
		System.out.println("Pop: " + pop() + ", minEle: " + minEle);
		System.out.println("Pop: " + pop() + ", minEle: " + minEle);

	}

}
