import java.util.ArrayList;

/*
 * Implementation of stack using ArrayList
 * 
 * Amortized time complexity of all operations: O(1)
 */
public class Stack {
	private ArrayList<Integer> arr;
	private int top = -1;
	
	public Stack() {
		arr = new ArrayList<Integer>();
	}
	
	public void push(int num) {
		++top;
		arr.add(num);
	}
	
	public int peek() {
		int lastIndex = arr.size()-1;
		return arr.get(lastIndex);
	}
	
	public int pop() {
		if (arr.size() == 0) {
			System.out.println("Stack underflow");
			return -1;
		}
		int lastIndex = arr.size()-1;
		int res = arr.get(lastIndex);
		arr.remove(lastIndex);
		top--;
		return res;
	}
	
	public int getSize() {
		return top+1;
	}
	
	public void printStack() {
		if (top == -1) {
			System.out.println("Empty stack");
			return;
		}
		System.out.print("Curr stack: ");
		for (int i=0; i<arr.size(); i++)
			System.out.print(arr.get(i) + " ");
		System.out.println();
	}
}
