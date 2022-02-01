
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.printStack();
		System.out.println("Capacity: " + s.getCapacity() + ", Size: " + s.getSize());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.printStack();
		System.out.println("Capacity: " + s.getCapacity() + ", Size: " + s.getSize());

	}

}
