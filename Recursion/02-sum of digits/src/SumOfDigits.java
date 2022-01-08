
public class SumOfDigits {

	public static int sum(int num) {
		if (num == 0)
			return 0;
		
		int rem = num%10;
		return rem + sum(num/10);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 256;
		System.out.println(sum(num));

	}

}
