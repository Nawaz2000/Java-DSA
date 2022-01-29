/*
 * Loop detection in linked list (Floyd's cycle finding algorithm)
 * 
 * Idea:
 * Use two pointers a slow and a fast pointer. The slow pointer increments by one and
 * the fast pointer increments by two. The idea is that if there is a loop, both the
 * pointers will eventually meet.
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
	
	public static boolean containsLoopFloydsAlgo(Node head) {
		if (head.next == null)
			return false;
		
		Node slow = head; // increments by one
		Node fast = head.next; // increments by two
		
		// if there is a loop, the slow and fast will eventually point to the same thing
		while(fast != null) {
			if (slow == fast)
				return true;
			fast = fast.next.next;
			slow = slow.next;
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
		head.next.next.next.next.next.next.next = head.next;
		System.out.println("Contains loop? " + containsLoopFloydsAlgo(head));

	}

}
