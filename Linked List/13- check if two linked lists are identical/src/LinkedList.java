/*
 * Check if two linked lists are identical or not
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
	
	public boolean isIdentical (Node head1, Node head2){
        //write your code here 
        Node curr1 = head1;
        Node curr2 = head2;
        int count1 = 0;
        int count2 = 0;
        
        while (curr1 != null)
        {
            count1++;
            curr1 = curr1.next;
        }
        
        while (curr2 != null){
            count2++;
            curr2 = curr2.next;
        }
        
        if (count1 != count2)
            return false;
            
        curr1 = head1;
        curr2 = head2;
        
        while (curr1 != null){
            if (curr1.data != curr2.data)
                return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
