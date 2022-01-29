/*
 * Recursive reverse a linked list
 * 
 * Idea:
 * Every time there are two variables curr (initially head) and prev (initially 0).
 * We introduce variable next = curr.next
 * and then curr.next = prev
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
	static Node reversedHead = null;
	
	public static void printLinkedList(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	public static Node reverseRecursive(Node curr, Node prev) {
		if (curr == null)
			return prev;
		
		Node nextNode = curr.next;
		curr.next = prev;
		return reverseRecursive(nextNode, curr);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		System.out.println("Given linked list:");
		printLinkedList(head);
		
		System.out.println("\nAfter reversing:");
		Node newHead = reverseRecursive(head, null);
		printLinkedList(newHead);

	}

}
