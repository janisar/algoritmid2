package alg.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import alg.min.heap.PriorityQueue;
import alg.queue.Queue;
import alg.stack.Stack;

public class Test {

	private static final int K = 20;

	private Stack stack;
	private PriorityQueue priorityQueue;
	private Queue queue;

	public Test(int size) {
		stack = new Stack(new int[size + 21]);
		priorityQueue = new PriorityQueue(size + 21);
		queue = new Queue();

		printStackToFile();
		printPriorityQueueToFile();
		printQueueToFile();

	}

	private void printStackToFile() {
		File file = new File("/home/janis/Desktop/algoritmid/stack.out");
		FileOutputStream fileStream = null;
		try {
			fileStream = new FileOutputStream(file);
			stack.push(1);
			int current = stack.pop();
			while (current <= K) {
				fileStream.write(Integer.toString(current).getBytes());
				fileStream.write(new byte[] { 10 });
				stack.push((current * 2) + 1);
				stack.push((current * 2));
				current = stack.pop();
			}
		} catch (IOException e) {
			System.err
					.println("Something went wrong while writing Stack to file");
		} finally {
			IOUtils.closeQuietly(fileStream);
		}
	}

	private void printPriorityQueueToFile() {
		File file = new File(
				"/home/janis/Desktop/algoritmid/priority_queue.out");
		FileOutputStream fileStream = null;
		try {
			fileStream = new FileOutputStream(file);
			priorityQueue.enqueue(1);
			int current = priorityQueue.dequeue();
			while (current <= K) {
				fileStream.write(Integer.toString(current).getBytes());
				fileStream.write(new byte[] { 10 });
				priorityQueue.enqueue((current * 2) + 1);
				priorityQueue.enqueue((current * 2));
				current = priorityQueue.dequeue();
			}
		} catch (IOException e) {
			System.err
					.println("Something went wrong while writing Priority-Queue to file");
		} finally {
			IOUtils.closeQuietly(fileStream);
		}
	}

	private void printQueueToFile() {
		File file = new File("/home/janis/Desktop/algoritmid/queue.out");
		FileOutputStream fileStream = null;
		try {
			fileStream = new FileOutputStream(file);
			queue.enqueue(1);
			int current = queue.dequeue();
			while (current <= K) {
				fileStream.write(Integer.toString(current).getBytes());
				fileStream.write(new byte[] { 10 });
				int n1 = (current * 2) + 1;
				int n2 = (current * 2);
				queue.enqueue(n1);
				queue.enqueue(n2);
				current = queue.dequeue();
			}
		} catch (IOException e) {
			System.err
			.println("Something went wrong while writing Queue to file");
		} finally {
			IOUtils.closeQuietly(fileStream);
		}
	}
}
