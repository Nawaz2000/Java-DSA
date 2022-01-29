/*
 * Remove duplicates from a sorted linked list
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
	
	public static void printLinkedList(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	
	public static void removeDuplicates(Node head) {
		
		if (head.next == null || head == null)
			return;
		
		Node prev = head;
		Node curr = head.next;
		while (curr != null) {
//			System.out.println("curr=" + curr.data + ", prev=" + prev.data);
			if (curr.data == prev.data) {
				while (curr.data == prev.data) {
//					System.out.println("------------->curr=" + curr.data + ", prev=" + prev.data);
					curr = curr.next;
					if (curr == null)
						break;
				}
				prev.next = curr;
			}else {				
				prev = curr;
				curr = curr.next;
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(20);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(30);
		head.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next = new Node(40);
		System.out.println("Given linked list:");
		printLinkedList(head);
		System.out.println();
		removeDuplicates(head);
		System.out.println("\nAfter removing duplicates:");
		printLinkedList(head);

	}

}
