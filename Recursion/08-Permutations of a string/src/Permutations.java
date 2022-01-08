
public class Permutations {
	
	public static String swap(String str, int i, int j) {
		char[] arr = str.toCharArray();
		char x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
		return new String(arr);
	}

	public static void findPermutations(String str, int start, int end) {
		if (start>=end)
		{
			System.out.println(str);
			return;
		}
		for (int i = start; i<end; i++) {
			str = swap(str,start,i);
			findPermutations(str, start+1, end);
            str = swap(str,start,i);//
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABC";
		findPermutations(str, 0, str.length());

	}

}
