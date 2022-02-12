import java.util.Arrays;
/*
 * Min heap insertion
 * 
 * Idea:
 * Insert at arr[size] and keep swapping with the parent as long as arr[i] < 
 * arr[parent(i)]
 * 
 * Time complexity: O(logn)
 */
class MinHeap{
	int[] arr;
	int size, capacity;
	
	MinHeap(int c){
		arr = new int[c];
		size = 0;
		capacity = c;
	}
	
	int leftChild(int i) {
		return 2*i+1;
	}
	
	int rightChild(int i) {
		return 2*i+2;
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	
	void insert(int x) {
		if (size == capacity)
			return;
		arr[size++] = x;
		
		int i = size-1;
		while (i!=0 && arr[i]<arr[parent(i)]) {
			int temp = arr[i];
			arr[i] = arr[parent(i)];
			arr[parent(i)] = temp;
			
			i = parent(i);
		}
	}

	@Override
	public String toString() {
		return "MinHeap [arr=" + Arrays.toString(arr) + ", size=" + size + ", capacity=" + capacity + "]";
	}
	
	
}
public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap h = new MinHeap(7);
		h.insert(10);
		h.insert(5);
		h.insert(20);
		h.insert(50);
		h.insert(40);
		h.insert(60);
		h.insert(1);
		System.out.println(h);

	}

}
