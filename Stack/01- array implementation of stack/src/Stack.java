/*
 * Simple implementation of stack using array
 * 
 * Time complexity of all operations: O(1)
 */
public class Stack {
	private int[] arr;
	private int capacity;
	private int top = -1;
	
	public Stack(int capacity) {
		this.capacity = capacity;
		arr = new int[this.capacity];
	}
	
	public void push(int num) {
		int currSize = top+1;
		if (currSize == capacity) {
			System.out.println("Stack Overflow!");
			return;
		}
		arr[++top] = num;
	}
	
	public int peek() {
		return arr[top];
	}
	
	public int pop() {
		if (top == -1) {
			System.out.println("Stack Underflow!");
			return -1;
		}
		return arr[top--];
	}
	
	public int getSize() {
		return top+1;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void printStack() {
		if (top == -1) {
			System.out.println("Empty stack");
			return;
		}
		System.out.print("Curr stack: ");
		for (int i=0; i<=top; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
