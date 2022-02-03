/*
 * Linked List implementation of circular queue
 * 
 * Time complexity: O(1)
 */
class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class CircularQueue {
	static int size = 0;
	
	public static Node enqueue(Node rear, int data) {
		Node newNode = new Node(data);
		if (rear == null) {
			newNode.next = newNode;
			size++;
			return newNode;
		}
		
		newNode.next = rear.next;
		rear.next = newNode;
		size++;
		return newNode;
	}
	
	public static Node dequeue(Node rear) {
		if (rear == null)
			return rear;
		if (rear.next == null) {
			size--;
			return null;
		}
		rear.next = rear.next.next;
		size--;
		return rear;
	}
	
	public static int getFront(Node rear) {
		if (rear == null)
			return -1;
		return rear.next.data;
	}
	
	public static void printQueue(Node rear) {
		if (rear == null)
			return;
		if (rear.next == null) {
			System.out.println(rear.data);
			return;
		}
		Node front = rear.next;
		Node curr = front.next;
		System.out.print(front.data + " ");
		while (curr != front) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static int getRear(Node rear) {
		if (rear == null)
			return -1;
		return rear.data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node rear = enqueue(null, 10);
		printQueue(rear);
		System.out.println("Front: " + getFront(rear) + ", Rear: " + getRear(rear) + ", size: " + size);
		rear = enqueue(rear, 20);
		printQueue(rear);
		System.out.println("Front: " + getFront(rear) + ", Rear: " + getRear(rear) + ", size: " + size);
		rear = enqueue(rear, 30);
		printQueue(rear);
		System.out.println("Front: " + getFront(rear) + ", Rear: " + getRear(rear) + ", size: " + size);
		rear = dequeue(rear);
		printQueue(rear);
		System.out.println("Front: " + getFront(rear) + ", Rear: " + getRear(rear) + ", size: " + size);
		
		

	}

}
