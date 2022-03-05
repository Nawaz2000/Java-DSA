import java.util.Stack;
/*
 * Given a stack find if the elements in the stack are pairwise consecutive or not. If
 * the stack contains odd number of elements then check for the same removing the top
 * element. The overall stack should not be changed.
 * 
 * Time complexity: O(n)
 * Auxiliary spacec: O(1)
 */
public class MyStack {
	static boolean pairWiseConsecutive(Stack<Integer> st)
    {
        // Your code here
        int n = st.size();
        Integer top = null;
        if (n%2 != 0)
            top = st.pop();
        
        Integer prev = null;
        for (int x : st){
            if (prev == null)
                prev = x;
            else{
                if (Math.abs(x-prev) > 1){
                    if (top != null)
                        st.push(top);
                    return false;
                }
                prev = null;
            }
        }
        
        if (top != null)
            st.push(top);
        
        return true;
       
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
