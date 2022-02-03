/*
 * Linked List implementation of queue
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
public class Queue {
	static Node front = null, rear = null;
	static int size = 0;
	
	public static void enqueue(int data) {
		Node newNode = new Node(data);
		if (front == null) {
			front = newNode;
			rear = front;
		}else {
			rear.next = newNode;
			rear = newNode;
			size++;
		}
	}
	
	public static void dequeue() {
		if (front == null) {
			System.out.println("Empty queue!");
			return;
		}
		front = front.next;
		size--;
		
		if (front == null)
			rear = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
