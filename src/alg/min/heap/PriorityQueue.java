package alg.min.heap;

import alg.massive.Massive;
import alg.massive.exception.MassiveOutOfBoundsException;

public class PriorityQueue {

	private Massive heap;
	private int size;

	public PriorityQueue() {
		size = 0;
		heap = new Massive();
		heap.add(Integer.MIN_VALUE);
	}

	public int dequeue() {
		int result = heap.get(1);
		heap.put(heap.get(size), 1);
		heap.put(0, size--);
		organiseHeap(1);
		return result;
	}

	public void enqueue(int element) {
		heap.put(element, ++size);
		int current = size;
		while (heap.get(current) < heap.get(parentIndex(current))) {
			swapNums(current, parentIndex(current));
			current = parentIndex(current);
		}
	}

	public boolean isEmpty() {
		return size < 1;
	}

	private boolean isLeaf(int pos) {
		if (size == 1 && pos == 1) {
			return true;
		}
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private int leftChild(int position) {
		return position * 2;
	}

	private void organiseHeap(int pos) {
		if (!isLeaf(pos)) {
			int rightChild = Integer.MAX_VALUE;
			try {
				rightChild = heap.get(rightChild(pos));
			} catch (MassiveOutOfBoundsException ex) {

			}
			if (heap.get(pos) > heap.get(leftChild(pos))
					|| heap.get(pos) > rightChild) {
				if (heap.get(leftChild(pos)) < rightChild) {
					swapNums(pos, leftChild(pos));
					organiseHeap(leftChild(pos));
				} else {
					swapNums(pos, rightChild(pos));
					organiseHeap(rightChild(pos));
				}
			}

		}
	}

	private int parentIndex(int position) {
		return position / 2;
	}

	private int rightChild(int position) {
		int result = (position * 2) + 1;
		if (result > size) {
			return -1;
		} else {
			return result;
		}
	}

	private void swapNums(int currentIndex, int parentIndex) {
		int temp = heap.get(currentIndex);
		heap.put(heap.get(parentIndex), currentIndex);
		heap.put(temp, parentIndex);
	}
}
