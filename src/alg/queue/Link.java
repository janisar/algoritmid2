package alg.queue;

public class Link {

	private int value;
	protected Link previous = null;
	protected Link next = null;

	public Link(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
