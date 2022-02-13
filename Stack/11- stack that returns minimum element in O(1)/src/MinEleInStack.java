import java.util.Stack;
/*
 * Design a stack that supports getMin() in O(1) time and O(1) extra space
 * 
 * Idea:
 * 
 * Push(x) : Inserts x at the top of stack. 
 * If stack is empty, insert x into the stack and make minEle equal to x.
 * If stack is not empty, compare x with minEle. Two cases arise:
 * If x is greater than or equal to minEle, simply insert x.
 * If x is less than minEle, insert (2*x – minEle) into the stack and make minEle equal to x. For example, let previous minEle was 3. Now we want to insert 2. We update minEle as 2 and insert 2*2 – 3 = 1 into the stack.
 * 
 * Pop() : Removes an element from top of stack. 
 * Remove element from top. Let the removed element be y. Two cases arise:
 * If y is greater than or equal to minEle, the minimum element in the stack is still minEle.
 * If y is less than minEle, the minimum element now becomes (2*minEle – y), so update (minEle = 2*minEle – y). This is where we retrieve previous minimum from current minimum and its value in stack. For example, let the element to be removed be 1 and minEle be 2. We remove 1 and update minEle as 2*2 – 1 = 3.
 * 
 * Time complexity: O(1)
 * Auxiliary space: O(1)
 */
public class MinEleInStack {
	static int minEle;
    static Stack<Integer> s = new Stack<Integer>();

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
	    int currTop = s.pop();
	    if (currTop >= minEle)
	        return currTop;
	    else{
	        minEle = 2*minEle-currTop;
	        return (currTop+minEle)/2;
	    }
    }

    // push element x into the stack
    static void push(int x)
    {
	// Your code here
	    if (s.isEmpty()){
	        s.push(x);
	        minEle = x;
	    }else{
	        if (x >= minEle)
	            s.push(x);
	        else{
	            s.push(2*x-minEle);
	            minEle = x;
	        }
	    }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(18);
		push(19);
		push(29);
		push(15);
		push(16);
		System.out.println("Min: " + minEle);
		System.out.println("Pop: " + pop() + ", minEle: " + minEle);
		System.out.println("Pop: " + pop() + ", minEle: " + minEle);

	}

}
