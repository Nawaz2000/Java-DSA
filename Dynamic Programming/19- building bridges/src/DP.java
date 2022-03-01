import java.util.Arrays;
import java.util.Comparator;
/*
 * Consider a 2-D map with a horizontal river passing through its center. There are n cities 
 * on the southern bank with x-coordinates a(1) … a(n) and n cities on the northern bank with 
 * x-coordinates b(1) … b(n). You want to connect as many north-south pairs of cities as 
 * possible with bridges such that no two bridges cross. When connecting cities, you can only 
 * connect city a(i) on the northern bank to city b(i) on the southern bank. Maximum number 
 * of bridges that can be built to connect north-south pairs with the aforementioned 
 * constraints.
 * 
 * Input : 6 4 2 1
 *         2 3 6 5
 * Output : Maximum number of bridges = 2
 * Explanation: Let the north-south x-coordinates
 * be written in increasing order.
 * 
 * 1  2  3  4  5  6
 *   \  \
 *    \  \        For the north-south pairs
 *     \  \       (2, 6) and (1, 5)
 *      \  \      the bridges can be built.
 *       \  \     We can consider other pairs also,
 *        \  \    but then only one bridge can be built 
 *         \  \   because more than one bridge built will
 *          \  \  then cross each other.
 *           \  \
 * 1  2  3  4  5  6 
 * 
 * Idea:
 * 1. sort the given pair on basis of their north sides, if north are same, the sort by south
 * 2. find lcs of the south sides
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(n)
 */
class CityPairs // Create user-defined class
{
    int north, south;
    CityPairs(int north, int south) // Constructor
    {
        this.north = north;
        this.south = south;
    }
	@Override
	public String toString() {
		return "CityPairs [north=" + north + ", south=" + south + "]";
	}
    
}

// for Arrays.sort comparing
class MyCmp implements Comparator<CityPairs>{
	public int compare(CityPairs o1, CityPairs o2) {
		if (o1.north == o2.north)
			return o1.south-o2.south;
		else
			return o1.north-o2.north;
	}
}

public class DP {
	// for finding the ceiling if curr.south < memo[last].south O(logn)
	static int binarySearch(CityPairs[] memo, int start, int end, CityPairs search) {
		while (start < end) {
			int mid = start + (end-start)/2;
			if (search.south > memo[mid].south)
				start = mid+1;
			else
				end = mid;
		}
		return end;
	}
	
	static String maxBridges(CityPairs[] pairs, int n) {
		Arrays.sort(pairs, new MyCmp());
		CityPairs[] memo = new CityPairs[n];
		memo[0] = pairs[0];
		int last = 1;
		
		// finds lcs
		for (int i=1; i<n; i++) {
			if (pairs[i].south > memo[last-1].south)
				memo[last++] = pairs[i];
			else {
				int ceil = binarySearch(memo, 0, last-1, pairs[i]);
				memo[ceil] = pairs[i];
			}
		}
		String res = ""+last;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
        CityPairs[] pairs = new CityPairs[n];
        pairs[0] = new CityPairs(6, 2);
        pairs[1] = new CityPairs(4, 3);
        pairs[2] = new CityPairs(2, 6);
        pairs[3] = new CityPairs(1, 5);
//        pairs[4] = new CityPairs(1, 3);
        System.out.println("Maximum number of bridges = "
                           + maxBridges(pairs, n));

	}

}
