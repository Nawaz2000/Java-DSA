/*
 * Simple implementation of queue
 * 
 * Time complexity: O(n) for dequeue, O(1) for all
 */
class Queue{
	private int size;
	private int capacity;
	private int[] arr;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		size = 0;
	}
	
	public void enqueue(int data) {
		if (isFull()) {
			System.out.println("Queue Overflow! Cannot perform enqueue.");
			return;
		}
		arr[size++] = data;
	}
	
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow! Cannot perform dequeue.");
			return;
		}
		for (int i=0; i<size-1; i++)
			arr[i] = arr[i+1];
		size--;
		
	}
	
	public int getFront() {
		if (isEmpty()) {
			System.out.println("Empty Queue! Front not available.");
			return -1;
		}
		return 0;
	}
	
	public int getRear() {
		if (isEmpty()) {
			System.out.println("Empty Queue! Rear not available.");
			return -1;
		}
		return size-1;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size==capacity;
	}
	
	
}
public class QueueImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue(4);
		System.out.println(queue.getFront());
		queue.enqueue(20);
		queue.enqueue(10);
		queue.enqueue(50);
		queue.enqueue(90);
		queue.enqueue(50);
		System.out.println("Rear: " + queue.getRear());
		queue.dequeue();
		System.out.println("Rear: " + queue.getRear());

	}

}
