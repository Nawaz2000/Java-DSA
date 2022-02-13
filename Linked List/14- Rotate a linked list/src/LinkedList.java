/*
 * Given a singly linked list of size N. The task is to left-shift the linked list by k 
 * nodes, where k is a given positive integer smaller than or equal to length of the 
 * linked list.
 * 
 * Input:
 * N = 5
 * value[] = {2, 4, 7, 8, 9}
 * k = 3
 * Output: 8 9 2 4 7
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

public class LinkedList {
	public static Node rotate(Node head, int k) {
        // result = second halve + first halve
        Node left = head; // represents the first halve of the list
        Node right = head; // represents the pivot or second halve of the linked list
        
        int i = 1;
        while (i<k){
            right = right.next;
            i++;
        }
        Node temp = right.next;
        
        if (temp == null)
            return head;
        right.next = null;
        right = temp;
        
        head = right;
        while (right.next != null)
            right = right.next;
            
        right.next = left;
        
        return head;
    }
	
	public static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(2);
		root.next = new Node(4);
		root.next.next = new Node(7);
		root.next.next.next = new Node(8);
		root.next.next.next.next = new Node(9);
		
		int k = 3;
		System.out.println("Before: ");
		printLinkedList(root);
		root = rotate(root, k);
		System.out.println("After: ");
		printLinkedList(root);

	}

}
