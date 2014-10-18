import alg.bin.PrimaryQueue;
import alg.massive.Massive;
import alg.stack.Stack;

public class Program {

	public static void main(String args[]) {
		Stack stack = new Stack(new int[10]);
		Massive m = new Massive(20);
		PrimaryQueue primaryQueue = new PrimaryQueue(10);
		primaryQueue.enqueue(23);
		primaryQueue.enqueue(12);
		primaryQueue.enqueue(2);
		primaryQueue.enqueue(9);
		primaryQueue.enqueue(10);
		primaryQueue.enqueue(33);
		primaryQueue.enqueue(34);
		primaryQueue.dequeue();
		primaryQueue.enqueue(111);
		primaryQueue.enqueue(20);
		primaryQueue.print();
	}
}
