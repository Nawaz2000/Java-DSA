public class HashedIn {
	public static int solution(int[] A, int M) {
		int max = 0;
		for (int i=0; i<A.length; i++) {
			int currMax = 0;
			for (int j=0; j<A.length; j++) {
//				if (j != i) {
					int dist = A[i]-A[j];
					if (dist%M == 0)
						currMax++;
//				}
			}
			if (currMax > max)
				max = currMax;
		}
		
//		if(max != 0)
//			return max+1;
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-3,-2,1,0,8,7,1};
//		int[] arr = {7,1,11,8,4,10};
//		int[] arr = {};
		int M = 3;
		System.out.println(solution(arr, M));
		

	}

}
