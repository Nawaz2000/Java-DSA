import java.util.Arrays;

class Queue{
	private int size, capacity;
	private int[] arr;
	
	private int front, rear;
	
	public Queue(int capacity) {
		this.capacity = capacity;
		size = 0;
		front=-1;
		rear=-1;
		arr = new int[capacity];
	}
	
	public void enqueue(int data) {
		if (front == -1) {
			front++;
			rear++;
			arr[rear] = data;
			size++;
			return;
		}
		
//		if (Math.abs(front-rear) == 1)
//			return;
		
		if (size == capacity)
			return;
		
		if (rear == capacity-1) {
			rear = 0;
			arr[rear] = data;
		}else
			arr[++rear] = data;
		
		size++;
		
	}
	
	public void dequeue() {
		if (rear == -1 || front == -1)
			return;
		if (front == rear) {
			front = -1;
			rear = -1;
			size--;
			return;
		}
		
		if (front == capacity-1)
			front = 0;
		else
			front++;
		size--;
	}
	
	public void printQueue() {
		System.out.print("front: " + front + ", rear: " + rear + ", size: " + size + ", arr: "+Arrays.toString(arr) + "\n");
	}
}
public class CircularQueue {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue(4);
		q.printQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.printQueue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.printQueue();
		q.dequeue();
		q.printQueue();
		q.enqueue(50);
		q.printQueue();

	}

}
