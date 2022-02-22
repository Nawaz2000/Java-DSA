import java.util.Arrays;

/*
 * There is one meeting room in a firm. There are N meetings in the form of 
 * (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish 
 * time of meeting i.
 * 
 * What is the maximum number of meetings that can be accommodated in the meeting 
 * room when only one meeting can be held in the meeting room at a particular time?
 * 
 * Note: Start time of one chosen meeting can't be equal to the end time of the other 
 * chosen meeting.
 * 
 * Input:
 * N = 6
 * start[] = {1,3,0,5,8,5}
 * end[] =  {2,4,6,7,9,9}
 * 
 * Output: 
 * 4
 * 
 * Explanation:
 * Maximum four meetings can be held with
 * given start and end timings.
 * The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(n)
 */
class Pair implements Comparable<Pair>{
    int start;
    int end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compareTo(Pair o){
        return this.end - o.end;
    }
    
}

public class Greedy {
	static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Pair[] arr = new Pair[n];
        for (int i=0; i<n; i++)
            arr[i] = new Pair(start[i], end[i]);
            
        Arrays.sort(arr);
        Pair prev = arr[0];
        int count = 1;
        
        for (int i=1; i<n; i++){
            Pair curr = arr[i];
            if (curr.start > prev.end){
                count++;
                prev = curr;
            }
        }
        return count;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,6,7,9,9};
		
		int n = 6;
		
		System.out.println("Max possible meetings: " + maxMeetings(start, end, n));

	}

}
