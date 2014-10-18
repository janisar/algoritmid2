package alg.bin;

import alg.massive.Massive;

public class PrimaryQueue {

	private Massive heap;
	private int size;

	public PrimaryQueue(int maxSize) {
		size = 0;
		heap = new Massive(maxSize + 1);
		heap.add(Integer.MIN_VALUE);
	}

	public void enqueue(int element) {
		heap.put(element, ++size);
		int current = size;
		while (heap.get(current) < heap.get(parentIndex(current))) {
			swapNums(current, parentIndex(current));
			current = parentIndex(current);
		}
	}

	public int dequeue() {
		int result = heap.get(1);
		heap.put(heap.get(size), 1);
		heap.put(0, size--);
		organiseHeap(1);
		return result;
	}

	private void organiseHeap(int pos) {
		if (isEmpty(pos)) {
			if (heap.get(pos) > heap.get(leftChild(pos))
					|| heap.get(pos) > heap.get(rightChild(pos))) {
				if (heap.get(leftChild(pos)) < heap.get(rightChild(pos))) {
					swapNums(pos, leftChild(pos));
					organiseHeap(leftChild(pos));
				} else {
					swapNums(pos, rightChild(pos));
					organiseHeap(rightChild(pos));
				}
			}
		}
	}

	private boolean isEmpty(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return false;
		}
		return true;
	}

	private int rightChild(int position) {
		return (position * 2) + 1;
	}

	private int leftChild(int position) {
		return position * 2;
	}

	private void swapNums(int currentIndex, int parentIndex) {
		int temp = heap.get(currentIndex);
		heap.put(heap.get(parentIndex), currentIndex);
		heap.put(temp, parentIndex);
	}

	private int parentIndex(int position) {
		return position / 2;
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + heap.get(i) + " LEFT CHILD : "
					+ heap.get(2 * i) + " RIGHT CHILD :"
					+ heap.get((2 * i) + 1));

			System.out.println();
		}
	}
}
