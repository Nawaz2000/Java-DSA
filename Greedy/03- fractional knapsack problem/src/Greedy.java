import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/*
 * Given weights and values of N items, we need to put these items in a knapsack of 
 * capacity W to get the maximum total value in the knapsack. Note: Unlike 0/1 
 * knapsack, you are allowed to break the item. 
 * 
 * Input:
 * N = 3, W = 50
 * values[] = {60,100,120}
 * weight[] = {10,20,30}
 * 
 * Output:
 * 240.00
 * Explanation:Total maximum value of item
 * we can have is 240.00 from the given
 * capacity of sack. 
 * 
 * Idea:
 * 1. this works on greedy algorithm so sort the basis of value/weight ratio
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(1)
 */
class Pair implements Comparable<Pair>{
	int weight;
	int value;
	Pair(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
	
	public int compareTo(Pair o) {
//		double cmp = (double)o.value/(double)o.weight - (double)this.value/(double)this.weight;
//		return (int)cmp;
		Double x = Double.valueOf((double)o.value/(double)o.weight);
		Double y = Double.valueOf((double)this.value/(double)this.weight);
		return x.compareTo(y);
		
	}

	@Override
	public String toString() {
		return "Pair [weight=" + weight + ", value=" + value + "]";
	}
	
}
public class Greedy {
	private static double fractionalKnapsack(ArrayList<Pair> sacks, int capacity) {
		Collections.sort(sacks);
		
		// the below sort function works if the Pair class did not implement Comparable interface
//		Collections.sort(sacks, new Comparator<Pair>() {
//			@Override
//			public int compare(Pair o1, Pair o2) {
//				Double x = Double.valueOf((double)o2.value/(double)o2.weight);
//				Double y = Double.valueOf((double)o1.value/(double)o1.weight);
//				return x.compareTo(y);
//			}
//		});
		System.out.println(Arrays.toString(sacks.toArray()));
		double resVal = 0;
		
		for (int i=0; capacity>0 && i<sacks.size(); i++) {
			Pair curr = sacks.get(i);
			double unitVal = (double)curr.value/(double)curr.weight;
			if (capacity > curr.weight) {
				resVal += curr.value;
				capacity = capacity-curr.weight;
			}else {
				resVal += capacity*unitVal;
				capacity = 0;
			}
		}
		
		return resVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pair> sacks = new ArrayList<Pair>();
		sacks.add(new Pair(50, 600));
		sacks.add(new Pair(20, 500));
		sacks.add(new Pair(30, 400));
		
		int capacity = 70;		
		double resVal = fractionalKnapsack(sacks, capacity);
		
		System.out.println("Max value: " + resVal);

	}

}
