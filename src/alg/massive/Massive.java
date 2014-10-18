package alg.massive;

import alg.massive.exception.MassiveOutOfBoundsException;

public class Massive {
	int index = 0;
	int[] massive;

	public Massive() {
	}

	public Massive(int n) {
		create(n);
	}

	public void create(int n) {
		massive = new int[n];
	}

	public int remove() {
		int result = massive[--index];
		massive[index] = 0;
		return result;
	}

	public void add(int x) {
		massive[index] = x;
		index++;
	}

	public int get(int i) throws MassiveOutOfBoundsException {
		/*
		 * if (i > index) { throw new
		 * MassiveOutOfBoundsException("No element found at " + i); }
		 */
		return massive[i];
	}

	public void put(int x, int i) {
		/*
		 * if (i > index) { throw new
		 * MassiveOutOfBoundsException("No element found at " + i); }
		 */
		massive[i] = x;
	}

	public int length() {
		return index;
	}
}
