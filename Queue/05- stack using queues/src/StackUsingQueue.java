import java.util.ArrayDeque;
import java.util.Queue;
/*
 * Implement stack using queue
 * 
 * i/p: 10 20 30
 * o/p: 30 20 10
 * 
 * Idea:
 * 1. use two queues
 * 2. everytime an insertion occurs, enqueue into q1
 * 3. dequeue the whole q2 into q1
 * 4. dequeue the whole q1 into q2
 * 5. q2 now becomes the stack
 * 
 * Time complexity:
 * push: O(n)
 * pop: O(1)
 * 
 */
public class StackUsingQueue {
	static Queue<Integer> q1 = new ArrayDeque<Integer>();
	static Queue<Integer> q2 = new ArrayDeque<Integer>();
	
	public static void push(Integer data) {
		q1.offer(data);
		while (!q2.isEmpty())
			q1.offer(q2.poll());
		
		while (!q1.isEmpty())
			q2.offer(q1.poll());
		
	}
	
	public static int pop() {
		return q2.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(10);
		push(20);
		push(30);
		System.out.print(pop() + " ");
		System.out.print(pop() + " ");
		System.out.println(pop() + " ");

	}

}
