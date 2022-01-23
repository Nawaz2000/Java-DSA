/*
 * Given a 26 letter character set, which is equivalent to character set of English 
 * alphabet i.e. (abcd….xyz) and act as a relation. We are also given several 
 * sentences and we have to translate them with the help of given new character set.
 * 
 * New character set : qwertyuiopasdfghjklzxcvbnm
 * Input : "utta"
 * Output : geek
 * 
 * Input : "egrt"
 * Output : code
 * 
 * Idea:
 * use auxiliary char array count[256] and for each character(c) in the input string,
 * count[c] = (char)pos++
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class ChangeString {

	public static void decoder(String str, String ip) {
		char[] count = new char[256];
		int pos = 97;
		
		for (char c : str.toCharArray()) {
			count[c] = (char)pos;
			pos++;
		}
		
		StringBuilder sb = new StringBuilder("");
		for (char c : ip.toCharArray()) {
			sb.append(count[c]);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "qwertyuiopasdfghjklzxcvbnm";
		String ip = "egrt";		
		decoder(str, ip);

	}

}
