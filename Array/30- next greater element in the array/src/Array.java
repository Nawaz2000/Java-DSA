import java.util.Arrays;
import java.util.Stack;
/*
 * Given an array arr[ ] of size N having distinct elements, the task is to find 
 * the next greater element for each element of the array in order of their 
 * appearance in the array.
 * 
 * Input: 
 * N = 5, arr[] [6 8 0 1 3]
 * Output:
 * 8 -1 1 3 -1
 */
public class Array {
	public static long[] nextLargerElement(long[] arr, int n) {
		// stores the next greater elements
		long[] next = new long[n];
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < n; i++) {
			long currEle = arr[i];
			
			// if stack is empty, push index of current element into stack
			if (s.isEmpty())
				s.push(i);
			else {
				long top = arr[s.peek()];
				// if current element is smaller than stack top, push current index 
				// into stack
				if (currEle <= top)
					s.push(i);
				else {
					// keep emptying the stack while current element is greater than
					// top and set, s.pop()'s next greater element as current element
					while (!s.isEmpty()) {
						top = arr[s.peek()];
						if (currEle > top)
							next[s.pop()] = currEle;
						else
							break;
					}
					// after the above operations, push current index into the stack
					s.push(i);
				}
			}
		}
		
		// all the remaining elements in stack does not have a next greater element
		// so pop them and set their corresponding values in next[] as -1
		while (!s.isEmpty())
			next[s.pop()] = -1;

		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = {6, 8, 0, 1, 3};
		int n = arr.length;
		System.out.println(Arrays.toString(nextLargerElement(arr, n)));

	}

}
