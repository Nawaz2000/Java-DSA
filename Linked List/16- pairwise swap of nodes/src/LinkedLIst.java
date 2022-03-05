/*
 * Given the head of a linked list, reverse the linked list pairwise
 * 
 * i/p: 1 2 3 4 5 6 7
 * o/p: 2 1 4 3 6 5 7
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class LinkedLIst {
	public static Node pairwise_swap(Node node) {
		Node curr = node;
		while (curr != null && curr.next != null) {
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
			curr = curr.next.next;
		}
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
