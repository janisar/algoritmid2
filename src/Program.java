import alg.massive.Massive;
import alg.min.heap.PrimaryQueue;
import alg.queue.Queue;
import alg.stack.Stack;

public class Program {

	public static void main(String args[]) {
		Stack stack = new Stack(new int[10]);
		Massive m = new Massive(20);
		PrimaryQueue primaryQueue = new PrimaryQueue(10);
		// primaryQueue.enqueue(23);
		// primaryQueue.enqueue(12);
		// primaryQueue.enqueue(2);
		// primaryQueue.enqueue(9);
		// primaryQueue.enqueue(10);
		// primaryQueue.enqueue(33);
		// primaryQueue.enqueue(34);
		// primaryQueue.dequeue();
		// primaryQueue.enqueue(111);
		// primaryQueue.enqueue(20);
		// primaryQueue.print();
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(15);
		queue.enqueue(33);

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(31);
		queue.enqueue(37);
	}
}
