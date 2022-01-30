/*
 * Insert at the middle of a linked list
 * 
 * Time complexity: O(n)
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
	
	public static Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        int size = 0;
        Node curr = head;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        
        int mid = 0;
        if (size%2 != 0)
            mid = size/2;
        else
            mid = (size-1)/2;
            
        curr = head;
        
        for (int i=0; i<mid; i++)
            curr = curr.next;
            
            
        Node newNode = new Node(data);
        newNode.next = curr.next;
        curr.next = newNode;
        
        return head;
    }
	
	public static void printLinkedList(Node head) {
		Node currNode = head;
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		System.out.println("Before");
		printLinkedList(head);
		
		int newData = 50;
		Node res = insertInMid(head, newData);
		System.out.println("\nAfter inserting " + newData + ": ");
		printLinkedList(res);

	}

}
