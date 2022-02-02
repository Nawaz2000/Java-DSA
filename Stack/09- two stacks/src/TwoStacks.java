/*
 * The task is to create a data structure twoStacks that represents two stacks. 
 * Implementation of twoStacks should use only one array, i.e., both stacks should use 
 * the same array for storing elements. 
 * 
 * Following functions must be supported by twoStacks.
 * 
 * push1(int x) --> pushes x to first stack.
 * push2(int x) --> pushes x to second stack.
 * pop1() --> pops an element from the first stack and return the popped element.
 * pop2() --> pops an element from the second stack and return the popped element.

Note: Implementation of twoStack should be space efficient.

 */
public class TwoStacks {
	int topStart;
	int topEnd;
	int[] arr;
	final int size;
	
	public TwoStacks(int n) {
		arr = new int[n];
		topStart = -1;
		topEnd = n;
		size = n;
	}
	
	// method to push element x into stack1
	public void push1(int x) {
		if (topStart + 1 <= topEnd)
			arr[++topStart] = x;
		else
			System.out.println("Stack1 overflow!");
	}
	
	public void push2(int x) {
		if (topStart <= topEnd-1)
			arr[--topEnd] = x;
		else
			System.out.println("Stack2 overflow!");
	}
	
	public int pop1() {
		if (topStart != -1)
			return arr[topStart--];
		else{
			System.out.println("Stack1 underflow!");
			System.exit(0);
		}
		
		return -1;
	}
	
	public int pop2() {
		if (topEnd != size)
			return arr[topEnd++];
		else{
			System.out.println("Stack2 underflow!");
			System.exit(0);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from" +
                           " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" +
                         " stack2 is " + ts.pop2());
	}
}
