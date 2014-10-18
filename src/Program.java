import alg.queue.Queue;
import alg.test.Test;

public class Program {

	public static void main(String args[]) {
		Queue q = new Queue();
		q.enqueue(2);
		// q.enqueue(5);
		// q.enqueue(9);
		System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		// System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
		Test testProgram = new Test(10);
	}
}
