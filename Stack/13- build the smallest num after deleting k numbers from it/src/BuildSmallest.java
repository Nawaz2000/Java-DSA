import java.util.Arrays;

public class BuildSmallest {
	static String buildLowestNumber(String str, int k) {
        // code here
        if (k==0)
            return str;
        if (k == str.length())
            return "";
        
        int n = str.length();
        
        char[] arr = str.toCharArray();
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<n-1; i++){
        	if (k==0)
        		break;
            if (arr[i] > arr[i+1]) {
            	arr[i] = '@';
            	k--;
            }
        }
        int i=n-1;
        while (k != 0 && i>=0) {
        	arr[i--] = '@';
        	k--;
        }
        i=0;	
        str = "";
        for (i=0; i<n; i++) {
        	if (arr[i] != '@')
        		str = str + arr[i];
        }
        
        n = str.length();
        arr = str.toCharArray();
        i=0;
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for (i=0; i<n; i++) {
        	if (arr[i] != '@')
        		sb.append(arr[i]);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "44743";
		int k = 4;
		System.out.println(buildLowestNumber(s, k));

	}

}
