package alg.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import alg.min.heap.PriorityQueue;
import alg.queue.Queue;
import alg.stack.Stack;

public class Test {

	private Stack stack;
	private PriorityQueue priorityQueue;
	private Queue queue;

	public Test() {
		stack = new Stack(new int[20]);
		priorityQueue = new PriorityQueue();
		queue = new Queue();

		printStackToFile();
		printPriorityQueueToFile();
		printQueueToFile();
	}

	private void printPriorityQueueToFile() {
		File file = new File(
				"/home/janis/Desktop/algoritmid/priority_queue.out");
		FileOutputStream fileStream = null;
		try {
			fileStream = new FileOutputStream(file);
			priorityQueue.enqueue(1);
			while (!priorityQueue.isEmpty()) {
				int current = priorityQueue.dequeue();
				fileStream.write(Integer.toString(current).getBytes());
				fileStream.write(new byte[] { 10 });
				if (current <= 20) {
					priorityQueue.enqueue((current * 2) + 1);
					priorityQueue.enqueue((current * 2));
				}
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
			while (!queue.isEmpty()) {
				int current = queue.dequeue();
				fileStream.write(Integer.toString(current).getBytes());
				fileStream.write(new byte[] { 10 });
				if (current <= 20) {
					int n1 = (current * 2) + 1;
					int n2 = (current * 2);
					queue.enqueue(n1);
					queue.enqueue(n2);
				}
			}
		} catch (IOException e) {
			System.err
			.println("Something went wrong while writing Queue to file");
		} finally {
			IOUtils.closeQuietly(fileStream);
		}
	}

	private void printStackToFile() {
		File file = new File("/home/janis/Desktop/algoritmid/stack.out");
		FileOutputStream fileStream = null;
		try {
			fileStream = new FileOutputStream(file);
			stack.push(1);
			while (!stack.isEmpty()) {
				int current = stack.pop();
				fileStream.write(Integer.toString(current).getBytes());
				fileStream.write(new byte[] { 10 });
				if (current <= 20) {
					stack.push((current * 2) + 1);
					stack.push((current * 2));
				}
			}
		} catch (IOException e) {
			System.err
			.println("Something went wrong while writing Stack to file");
		} finally {
			IOUtils.closeQuietly(fileStream);
		}
	}
}
