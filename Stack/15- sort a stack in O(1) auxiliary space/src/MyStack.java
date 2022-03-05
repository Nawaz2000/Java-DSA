import java.util.Stack;
/*
 * Sort a stack such that the max is the top in O(1) auxiliary space
 * 
 * Time complexity: O(n^2)
 * Auxiliary space: O(1)
 * 
 * Idea:
 * sortStack(stack S)
 *     if stack is not empty:
 *         temp = pop(S);  
 *         sortStack(S); 
 *         sortedInsert(S, temp);
 *         
 * sortedInsert(Stack S, element)
 *     if stack is empty OR element > top element
 *         push(S, elem)
 *     else
 *         temp = pop(S)
 *         sortedInsert(S, element)
 *         push(S, temp)
 */
public class MyStack {
	void sortedInsert(Stack<Integer> s, int curr){
        if (s.isEmpty() || curr > s.peek()){
            s.push(curr);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, curr);
        s.push(temp);
    }
    
	public Stack<Integer> sortStack(Stack<Integer> s)
	{
		//add code here.
		if (!s.isEmpty()){
		    int curr = s.pop();
		    sortStack(s);
		    sortedInsert(s, curr);
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
