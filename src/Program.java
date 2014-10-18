import alg.massive.Massive;
import alg.stack.Stack;

public class Program {

	public static void main(String args[]) {
		Stack stack = new Stack(new int[10]);
		stack.push(1);
		stack.push(10);
		Massive m = new Massive();
		m.create(10);
		m.add(2);
		m.add(1);
		m.add(10);
		int i = m.get(2);
		System.out.println(i);
		System.out.println(m.length());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
