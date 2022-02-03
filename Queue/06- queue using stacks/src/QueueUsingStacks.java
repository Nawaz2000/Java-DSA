import java.util.ArrayDeque;
import java.util.Stack;
/*
 * Implement queue using stacks
 * 
 * i/p: 10 20 30
 * o/p: 1 020 30
 * 
 * Idea:
 * 1. use two stacks
 * 2. before pushing data into s1, empty s1 into s2
 * 3. push data into s1
 * 4. empty s2 into s1
 */
public class QueueUsingStacks {
	static ArrayDeque<Integer> s1 = new ArrayDeque<Integer>(); // resultant queue
	static ArrayDeque<Integer> s2 = new ArrayDeque<Integer>();
//	static Stack<Integer> s1 = new Stack<Integer>();
//	static Stack<Integer> s2 = new Stack<Integer>();
	
	public static void enqueue(Integer data) {
		while (!s1.isEmpty())
			s2.push(s1.pop());
		
		s1.push(data);
		
		while (!s2.isEmpty())
			s1.push(s2.pop());
	}
	
	public static int dequeue() {
		return s1.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		enqueue(10);
		enqueue(20);
		enqueue(30);
		System.out.print(dequeue() + " ");
		System.out.print(dequeue() + " ");
		System.out.print(dequeue() + " ");

	}

}
