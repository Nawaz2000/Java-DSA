import java.util.HashSet;

public class FindPair {

	public static int sumExists(int arr[], int N, int sum) {

        // Your code here
        HashSet<Integer> set = new HashSet<>();
        for(int i :arr){
            if(set.contains(sum-i)){
                return 1;
            }else{
                set.add(i);
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 14;
		
		System.out.println(sumExists(arr, N, sum));

	}

}
