import java.util.Arrays;

public class LexicographicRank {

	public static int rank(String str) {
		str = str.toUpperCase();
		int res = 0;
		
		int[] count = new int[256];
		int[] cumulativeCount = new int[256];
		
		for (int i=0;i<str.length(); i++)
			count[str.charAt(i)]++;
		
		int sum=0;
		// stores the number of elements smaller than current in cumulativeCount array
		for (int i=0; i<256; i++) {
			if(count[i] != 0) {
				cumulativeCount[i] = sum;
				sum++;
			}
		}
		
//		System.out.println(Arrays.toString(count));
//		System.out.println(Arrays.toString(cumulativeCount));
		
		for (int i=0; i<str.length(); i++) {
			res = res + cumulativeCount[str.charAt(i)]*fact(str.length()-1-i);
		}
		
		return res;
	}
	
	public static int fact(int num) {
		int res = num;
		System.out.println("Num initial" + num);
		while(true) {
			System.out.println(num);
			res = res*(--num);
			if (num<=1)
				break;
					
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "CBA";
		System.out.println("Rank of " + str + " is: " + rank(str));

	}

}
