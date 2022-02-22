/*
 * Given a encoded binary string and a Huffman MinHeap tree, your task is to 
 * complete the function decodeHuffmanData(), which decodes the binary encoded 
 * string and return the original string. 
 * 
 * Input :
 * binaryString = 0000000000001100101010101011111111010101010
 * Min Heap Tree =  
 *                 $(20)
 *               /      \
 *             /          \
 *          $(8)            \
 *        /     \             \
 *     $(3)      \            $(12)
 *     /  \       \           /    \
 * B(1)    D(2)    E(5)    C(6)    A(6)
 * 
 * Output: AAAAAABCCCCCCDDEEEEE
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
class MinHeapNode
{
    char data;
    int freq;
    MinHeapNode left, right, top;
    MinHeapNode(char c, int freq)
    {
        left = right = null;
        this.data = c;
        this.freq = freq;
    }
}

public class Greedy {
	static String decodeHuffmanData(MinHeapNode root, String binaryString)
    {
        MinHeapNode curr = root;
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<binaryString.length(); i++){
            if (binaryString.charAt(i) == '1')
                curr = curr.right;
            else if (binaryString.charAt(i) == '0')
                curr = curr.left;
                
            if (curr.right == null && curr.left == null){
                sb.append(curr.data);
                curr = root;
            }
        }
        
        return sb.toString().trim();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
