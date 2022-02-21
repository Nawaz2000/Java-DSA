import java.util.Arrays;
import java.util.Comparator;
/*
 * Given a set of N jobs where each jobi has a deadline and profit associated with 
 * it. 
 * 
 * Each job takes 1 unit of time to complete and only one job can be scheduled 
 * at a time. We earn the profit associated with job if and only if the job is 
 * completed by its deadline. Find the number of jobs done and the maximum profit.
 * 
 * Input:
 * N = 4
 * Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
 * 
 * Output:
 * 2 60
 * Explanation:
 * Job1 and Job3 can be done with
 * maximum profit of 60 (20+40).
 * 
 * Idea:
 * 1. sort the arr according to its profit in decreasing order
 * 2. use a temp arr to store if deadline has been full filled
 * 3. for i=0 to n
 * 	if temp[current jobs deadline - 1] == 0
 * 		that means the position is unfilled so set it to 1 and res[0]++ and res[1]+=currJob.profit
 * 	else
 * 		set temp's previous empty space to 1 and res[0]++ and res[1]+=currJob.profit
 * 
 * Time complexity: O(nlogn)
 * Auxiliary space: O(max(deadline))
 */
class Job{
	int profit, deadline;
	Job(int deadline, int profit){
		this.profit = profit;
		this.deadline = deadline;
	}
}
public class Greedy {
	static int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int[] res = new int[2];
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job o1, Job o2){
                    Integer profit1 = Integer.valueOf(o1.profit);
                    Integer profit2 = Integer.valueOf(o2.profit);
                    return profit2.compareTo(profit1);
            }
            
        });
        
        int maxDeadline = Integer.MIN_VALUE;
        // below loop finds max of deadline
        for (Job j : arr) {
        	if (j.deadline > maxDeadline)
        		maxDeadline = j.deadline;
        }
        
        // stores if a position is filled
        int[] temp = new int[maxDeadline];
        
        for (int i=0; i<n; i++){
            Job curr = arr[i];
            int dL = curr.deadline;
            for (int j=dL-1; j>=0; j--) {
            	if (temp[j] == 0) {
            		temp[j] = 1;
                    res[0]++;
                    res[1] += curr.profit;
                    break;
            	}
            }
            
        }
        System.out.println(Arrays.toString(temp));
        
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		Job[] arr = new Job[n];
		arr[0] = new Job(2, 100);
		arr[1] = new Job(1, 19);
		arr[2] = new Job(2, 27);
		arr[3] = new Job(1, 25);
		arr[4] = new Job(1, 15);
		
		int[] res = JobScheduling(arr, n);
		System.out.println("Jobs done: " + res[0] + ", Profit: " + res[1]);

	}

}
