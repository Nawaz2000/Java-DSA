/*
 * Given two sorted linked lists consisting of N and M nodes respectively. The task is to 
 * merge both of the list (in-place) and return head of the merged list.
 * 
 * Time complexity: O(n+m)
 * Auxiliary space: O(n+m)
 */
class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class LinkedList {
	Node sortedMerge(Node head1, Node head2) {
		Node head = new Node(0);
		Node tail = head;

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				tail.next = head1;
				head1 = head1.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		tail.next = (head1 != null) ? head1 : head2;
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
