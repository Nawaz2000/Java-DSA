import java.util.ArrayList;

/*
 * There are n people standing in a circle waiting to be executed. The counting out 
 * begins at some point in the circle and proceeds around the circle in a fixed 
 * direction. In each step, a certain number of people are skipped and the next 
 * person is executed. The elimination proceeds around the circle (which is becoming 
 * smaller and smaller as the executed people are removed), until only the last person 
 * remains, who is given freedom. Given the total number of persons n and a number k 
 * which indicates that k-1 persons are skipped and kth person is killed in a circle. 
 * The task is to choose the place in the initial circle so that you are the last one 
 * remaining and so survive.
 * 
 * For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at 
position 2 is killed, then the person at position 4 is killed, then the person at 
position 1 is killed. Finally, the person at position 5 is killed. So the person at 
position 3 survives.
If n = 7 and k = 3, then the safe position is 4. The persons at positions 
3, 6, 2, 7, 5, 1 are killed in order, and the person at position 4 survives.
 */

public class JosephusProblem {

	public static void solveJosephus(ArrayList<Integer> list, int k) {
		if (list.size() == 1)
		{
			System.out.println(list.get(0));
			return;
		}
		
		int removalIndx = k;
		// if there is an out of indx error, it finds the removal index circulating the list
		while (removalIndx >= list.size())
			removalIndx = removalIndx-list.size();
		
		// if the list remains 2 elements, it swaps the index with the other element
		if (list.size() == 2) {
			if (removalIndx == 1)
				removalIndx = 0;
			else if (removalIndx == 0)
				removalIndx = 1;
		}
		
		
		list.remove(removalIndx);
		solveJosephus(list, k+1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int k = 2;
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i<=n; i++)
			list.add(i);
		
		solveJosephus(list, k-1);

	}

}
