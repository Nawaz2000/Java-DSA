/*
 * Find intersection of two linked lists
 * 
 * i/p
 * List 1: 
 * 10 20 30 40 
 * List 2: 
 * 5 11 19 25 70 80 
 * 
 * o/p: 30
 * 
 * Idea: 
 * Get count of the nodes in the first list, let count be c1.
 * Get a count of the nodes in the second list, let count be c2.
 * Get the difference of counts d = abs(c1 – c2).
 * Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
 * Then we can traverse both the lists in parallel till we come across a common node.
 * 
 * Time complexity: O(n+m)
 * Auxiliary space: O(1)
 */
class Node {
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

	public static int findIntersection(Node h1, Node h2) {
		Node curr1 = h1;
		Node curr2 = h2;
		int n = 0, m = 0;

		// count length of curr1
		while (curr1 != null) {
			n++;
			curr1 = curr1.next;
		}

		// count length of curr2
		while (curr2 != null) {
			m++;
			curr2 = curr2.next;
		}

		int diff = Math.abs(n - m);

		curr1 = h1;
		curr2 = h2;

		if (n > m) {
			int count = 0;
			while (count != diff) {
				count++;
				curr1 = curr1.next;
			}

			while (curr1.data != curr2.data) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			return curr1.data;
		} else {
			int count = 0;
			while (count != diff) {
				count++;
				curr2 = curr2.next;
			}

			while (curr1.data != curr2.data) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}

			return curr1.data;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		Node head2 = new Node(5);
		head2.next = new Node(11);
		head2.next.next = new Node(19);
		head2.next.next.next = new Node(25);
		head2.next.next.next.next = new Node(30);
		head2.next.next.next.next.next = new Node(40);

		System.out.println("List 1: ");
		printLinkedList(head);
		System.out.println("\nList 2: ");
		printLinkedList(head2);

		System.out.println("\nIntersection at node: " + findIntersection(head, head2));

	}

}
