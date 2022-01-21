import java.util.Arrays;

class Point implements Comparable<Point>{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(Point p) {
		return (this.x>p.x)?1:-1;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}


public class ComparableExample{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] arr = {new Point(3,12), new Point(10,9), new Point(4,8), new Point(4,9)};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
