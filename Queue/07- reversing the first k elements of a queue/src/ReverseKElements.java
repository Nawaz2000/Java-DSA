import java.util.ArrayDeque;
import java.util.Queue;
/*
 * Reverse first k elements of a queue
 * 
 * i/p: 10 20 30 40 50, k=3
 * o/p: 30 20 10 40 50
 * 
 * Idea:
 * use an auxiliary stack
 * 
 * Time complexity: O(n)
 */
public class ReverseKElements {
	public static Queue<Integer> reverve(Queue<Integer> q, int k){
		ArrayDeque<Integer> s = new ArrayDeque<Integer>();
		Queue<Integer> res = new ArrayDeque<Integer>();
		
		for (int i=1; i<=k; i++)
			s.push(q.poll());
		
		while (!s.isEmpty())
			res.offer(s.pop());
		
		while (!q.isEmpty())
			res.offer(q.poll());
		
		return res;
        //add code here.
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		
		int k = 3;
		
		Queue<Integer> res = reverve(q, k);
		
		for (Integer x : res)
			System.out.print(x + " ");

	}

}
