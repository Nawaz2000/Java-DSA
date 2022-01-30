/*
 * Delete the kth node of a circular linked list
 * 
 * Idea:
 * For k == 1, use the deleteHead method
 * for others, loop to that point and delete them
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
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
	
	public static Node deleteHead(Node head) {
		// if the head itself is null or if there is only one node, return null
		if (head == null || head.next == head)
			return null;
		
		Node temp = head.next;
		int t = head.data;
		head.data = temp.data;
		temp.data = t;
		
		head.next = temp.next;
		return head;
	}
	
	public static Node delethKth(Node head, int k) {
		if (head == null)
			return head;
		
		if (k == 1)
			return deleteHead(head);
		
		Node curr = head;
		
		for (int i=0; i<k-2; i++)
			curr = curr.next;
		
		curr.next = curr.next.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = head;
		System.out.println("Before deletion: ");
		printCircularLinkedList(head);
		
		head = delethKth(head, 1);
		System.out.println("\nAfter deletion: ");
		printCircularLinkedList(head);

	}

}
