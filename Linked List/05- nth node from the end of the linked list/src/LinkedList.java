/*
 * Find nth element from the end of a linked list
 * 
 * i/p: 
 * Given linked list: {10, 20, 30}
 * n = 
 * 
 * o/p:
 * No "1" element from the end: 30
 * 
 * Idea:
 * Use two pointers. first one points to head + nth node and second points to head.
 * Use a while loop to increment both pointers until first becomes null. Print the second
 * node
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 * 
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
	public static void printLinkedList(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	private static void nthFromEnd(Node head, int n) {
		// TODO Auto-generated method stub
		Node first = head;
		Node second = head;
		
		if (head == null)
			return;
		
		try {
			for (int i=0; i<n; i++)
				first = first.next;
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("No such index found");
			return;
		}
		
		
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		
		System.out.println(second.data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		System.out.println("Given linked list:");
		printLinkedList(head);

		int n = 1;
		System.out.println("\n" +"No \"" + n + "\" element from the end");
		nthFromEnd(head, n);

	}

}
