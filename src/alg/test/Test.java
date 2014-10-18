package alg.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import alg.min.heap.PriorityQueue;
import alg.queue.Queue;
import alg.stack.Stack;

public class Test {

	private static final int K = 20;

	private Stack stack;
	private PriorityQueue priorityQueue;
	private Queue queue;
	private int size;

	public Test(int size) {
		this.size = size;
		stack = new Stack(new int[size + 30]);
		priorityQueue = new PriorityQueue(size + 30);
		queue = new Queue();

		initStack();
		initPriorityQueue();
		initQueue();

		try {
			printStackToFile();
			printPriorityQueueToFile();
			printQueueToFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initStack() {
		for (int i = 0; i < size; i++) {
			if (i < K) {
				stack.push((2 * i) + 1);
				stack.push(2 * i);
			} else {
				stack.push(i);
			}
		}
	}

	private void printStackToFile() throws FileNotFoundException {
		File file = new File("/home/janis/Desktop/algoritmid/stack.out");
		FileOutputStream fileStream = new FileOutputStream(file);

		while (!stack.isEmpty()) {
			try {
				fileStream.write(Integer.toString(stack.pop()).getBytes());
				fileStream.write(new byte[] { 10 });
			} catch (IOException e) {
				System.err
				.println("Something went wrong while writing Stack to file");
			}
		}
	}

	private void initPriorityQueue() {
		for (int i = 0; i < size; i++) {
			if (i < K) {
				priorityQueue.enqueue(2 * i + 1);
				priorityQueue.enqueue(2 * i);
			} else {
				priorityQueue.enqueue(i);
			}
		}
	}

	private void printPriorityQueueToFile() throws FileNotFoundException {
		File file = new File(
				"/home/janis/Desktop/algoritmid/priority_queue.out");
		FileOutputStream fileStream = new FileOutputStream(file);

		while (!priorityQueue.isEmpty()) {
			try {
				fileStream.write(Integer.toString(priorityQueue.dequeue())
						.getBytes());
				fileStream.write(new byte[] { 10 });
			} catch (IOException e) {
				System.err
				.println("Something went wrong while writing Priority-Queue to file");
			}
		}
	}

	private void initQueue() {
		for (int i = 0; i <= size; i++) {
			if (i < K) {
				queue.enqueue(2 * i + 1);
				queue.enqueue(2 * i);
			} else {
				stack.push(i);
			}
		}
	}

	private void printQueueToFile() throws FileNotFoundException {
		File file = new File("/home/janis/Desktop/algoritmid/queue.out");
		FileOutputStream fileStream = new FileOutputStream(file);

		while (!queue.isEmpty()) {
			try {
				fileStream.write(Integer.toString(queue.dequeue()).getBytes());
				fileStream.write(new byte[] { 10 });
			} catch (IOException e) {
				System.err
				.println("Something went wrong while writing Queue to file");
			}
		}
	}
}
