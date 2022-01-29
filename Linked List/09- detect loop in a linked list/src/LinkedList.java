import java.util.HashSet;
/*
 * Detect loop in a linked list (Hash based solution)
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
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
	
	public static boolean containsLoop(Node head) {
		HashSet<Node> set = new HashSet<Node>();
		Node curr = head;
		while (curr != null) {
			if (set.contains(curr))
				return true;
			set.add(curr);
			curr = curr.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(40);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(70);
		head.next.next.next.next.next.next.next = head;
		System.out.println("Contains loop? " + containsLoop(head));

	}

}
