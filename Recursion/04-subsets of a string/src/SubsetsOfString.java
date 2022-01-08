import java.util.ArrayList;

public class SubsetsOfString {
	
	static ArrayList<String> result = new ArrayList<>();

	public static void findSubs(String str, String res, char currChar, int pointer) {
		if (pointer == str.length()-1)
		{
			//System.out.println(res);
			result.add(res);
			return;
		}
		
		findSubs(str, res, str.charAt(pointer+1), pointer+1);
		findSubs(str, res+currChar, str.charAt(pointer+1), pointer+1);				
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABCD";
		char currChar = str.charAt(0);
		int count = 0;
		findSubs(str,"",currChar,count);
		System.out.println(result);

	}

}
