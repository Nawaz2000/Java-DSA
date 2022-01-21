import java.util.Arrays;
import java.util.Comparator;

class Point{
	int x, y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
}

class MyCmp implements Comparator<Point>{
	public int compare(Point p1, Point p2) {
		if (p1.x > p2.y)
			return 1;
		else if (p1.x < p2.y)
			return -1;
		else
			return 0;
	}

}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] arr = {new Point(5,6), new Point(6,9), new Point(1,4)};
		Arrays.sort(arr, new MyCmp());
		System.out.println(Arrays.toString(arr));
		
	}

}
