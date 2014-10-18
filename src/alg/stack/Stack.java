package alg.stack;

import alg.stack.exception.StackOutOfBoundsException;

public class Stack {

	int[] m;
	int currentIndex;

	public Stack(int[] m) {
		this.m = m;
		currentIndex = 0;
	}

	public void push(int num) {
		m[currentIndex] = num;
		currentIndex++;
	}

	public int pop() {
		if (!isEmpty()) {
			int result = m[currentIndex - 1];
			m[currentIndex] = 0;
			currentIndex--;
			return result;
		} else {
			throw new StackOutOfBoundsException("Stact is empty");
		}
	}

	public boolean isEmpty() {
		return currentIndex == 0;
	}

	public int size() {
		return this.m.length;
	}
}
