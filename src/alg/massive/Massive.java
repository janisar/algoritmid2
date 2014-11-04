package alg.massive;

import alg.massive.exception.MassiveOutOfBoundsException;

public class Massive {
	int index = 0;
	int[] massive;

	public Massive() {
		create(1);
	}

	public Massive(int n) {
		create(n);
	}

	public void add(int x) {
		massive[index] = x;
		checkSizeChange(index);
		index++;

	}

	public void checkSizeChange(int i) {
		if (index >= massive.length - 1) {
			increaseMassiveSize(i);
		} else if (index <= massive.length / 4) {
			decreaseMassiveSize();
		}
	}

	public void create(int n) {
		massive = new int[n];
	}

	private void decreaseMassiveSize() {
		int[] newMassive = new int[massive.length / 2];
		for (int i = 0; i < index; i++) {
			newMassive[i] = massive[i];
		}
		massive = newMassive;
	}

	public int get(int i) throws MassiveOutOfBoundsException {
		if (i >= index || i < 0) {
			throw new MassiveOutOfBoundsException("No element found at " + i);
		}

		return massive[i];
	}

	private void increaseMassiveSize(int index) {
		int[] newMassive = new int[massive.length * 2];
		for (int i = 0; i <= this.index; i++) {
			newMassive[i] = massive[i];
		}
		massive = newMassive;
	}

	public int length() {
		return index;
	}

	public void put(int x, int i) {
		if (i > index) {
			throw new MassiveOutOfBoundsException("No element found at " + i);
		}
		checkSizeChange(index);
		massive[i] = x;
		index++;
	}

	public int remove() {
		int result = massive[--index];
		massive[index] = 0;

		checkSizeChange(index);

		return result;
	}
}
