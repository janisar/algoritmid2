package alg.massive;

import alg.massive.exception.MassiveOutOfBoundsException;

public class Massive {
	int index = 0;
	int[] massive;
	boolean isPriQueue;

	public Massive() {
	}

	public Massive(int n) {
		create(n);
	}

	public Massive(int n, boolean priority) {
		create(n);
		this.isPriQueue = priority;
	}

	public void create(int n) {
		massive = new int[n];
	}

	public int remove() {
		int result = massive[--index];
		massive[index] = 0;
		if (!isPriQueue) {
			checkSizeChange(index);
		}
		return result;
	}

	public void add(int x) {
		massive[index] = x;
		index++;
		if (!isPriQueue) {
			checkSizeChange(index);
		}
	}

	public int get(int i) throws MassiveOutOfBoundsException {
		// if (!priorityQueue && i > index) {
		// throw new MassiveOutOfBoundsException("No element found at " + i);
		// }

		return massive[i];
	}

	public void put(int x, int i) {
		// if (!priorityQueue && i > index) {
		// throw new MassiveOutOfBoundsException("No element found at " + i);
		// }
		massive[i] = x;
	}

	public int length() {
		return index;
	}

	public void checkSizeChange(int i) {
		if (i >= massive.length) {
			increaseMassiveSize(i);
		} else if (i <= massive.length / 4) {
			decreaseMassiveSize();
		}
	}

	private void increaseMassiveSize(int index) {
		int[] newMassive = new int[massive.length * 2];
		for (int i = 0; i < index; i++) {
			newMassive[i] = massive[i];
		}
		massive = newMassive;
	}

	private void decreaseMassiveSize() {
		int[] newMassive = new int[massive.length / 2];
		for (int i = 0; i <= index; i++) {
			newMassive[i] = massive[i];
		}
		massive = newMassive;
	}
}
