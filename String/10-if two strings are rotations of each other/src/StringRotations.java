// Returns true if the two strings are rotations of each other

import java.util.Arrays;

public class StringRotations {

	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		else {
			int[] countS1 = new int[256];
			int[] countS2 = new int[256];
			
			for (int i=0; i<s1.length(); i++)
				countS1[s1.charAt(i)]++;
			
			for (int i=0; i<s2.length(); i++)
				countS2[s2.charAt(i)]++;
			
			return Arrays.equals(countS1, countS2);
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Nawaz";
		String s2 = "azNnw";
		
		System.out.println(isRotation(s1, s2));

	}

}
