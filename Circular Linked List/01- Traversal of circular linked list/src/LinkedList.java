class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class LinkedList {
	
	public static void printCircularLinkedList(Node head) {
		if (head == null)
			return;
		Node curr = head;
		while (curr.next != head) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10); 
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = head;
		printCircularLinkedList(head);

	}

}
