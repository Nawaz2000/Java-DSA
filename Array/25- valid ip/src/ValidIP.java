/*
 * Write a program to Validate an IPv4 Address. According to Wikipedia, IPv4 
 * addresses are canonically represented in dot-decimal notation, which consists of 
 * four decimal numbers, each ranging from 0 to 255, separated by dots, 
 * e.g., 172.16.254.1 . The generalized form of an IPv4 address is 
 * (0-255).(0-255).(0-255).(0-255). Here we are considering numbers only from 
 * 0 to 255 and any additional leading zeroes will be considered invalid.
 * 
 * Time complexity: O(n)
 * Auxiliary space: O(1)
 */
public class ValidIP {
	static boolean isValid(String s) {
        // to check for conditions like ".45.96.74.245", "192.0.0.7."
        if (s.charAt(0) == '.' || s.charAt(s.length()-1) == '.')
		    return false;
        String[] splitS = s.split("\\.");
        
        // Ipv4 must be of size 4
        if (splitS.length != 4)
            return false;
        
        for (String curr : splitS){
            try{
                int currNum = Integer.parseInt(curr);
                // checks for 000, 009, 04 etc.
                if (currNum < 10 && curr.length() != 1)
                    return false;
                if (currNum < 0 || currNum > 255)
                    return false;
            }catch(Exception e){
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "896.4.7";
		System.out.println("Is valid IP: " + isValid(ip));

	}

}
