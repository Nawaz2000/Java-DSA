/*
 * Linked List
 * 
 * Iterative search
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 * 
 * Recursive search
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

public class LinkedListSearch {
	
	// insert method for a linked list
	public static void insert(Node head, int data) {
		Node iterator = head;
		while (iterator.next != null)
			iterator = iterator.next;
		iterator.next = new Node(data);
		
	}
	
	// iterative search
	public static int iterativeSearch(Node head, int data) {
		int pos = 1;
		Node curr = head;
		while (curr != null) {
			if (curr.data == data)
				return pos;
			pos++;
			curr = curr.next;
		}
		
		return -1;
	}
	
	// recursive search
	public static int recursiveSearch(Node head, int data) {
		if (head == null)
			return -1;
		if (head.data == data)
			return 1;
		return recursiveSearch(head.next, data) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		insert(head, 5);
		insert(head, 20);
		insert(head, 15);
		
//		System.out.println(iterativeSearch(head, 15));
		System.out.println(recursiveSearch(head, 20));

	}

}
