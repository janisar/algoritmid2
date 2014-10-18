package alg.queue;

public class Queue {

	public Link last;
	private int size;

	public Queue() {
		last = null;
		size = 0;
	}

	public void enqueue(int num) {
		if (last == null) {
			last = new Link(num);
			last.previous = last;
		} else {
			Link current = new Link(num);
			current.previous = last.previous;
			current.next = last;
			current.next.previous = current;
			last = current;
		}
		size++;
	}

	public int dequeue() {
		int result;
		if (last.next == null) {
			result = last.getValue();
			last = null;
		} else {
			result = last.previous.getValue();
			last.previous = last.previous.previous;
		}
		size--;
		return result;
	}

	public boolean isEmpty() {
		return size <= 0;
	}
}
