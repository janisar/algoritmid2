package alg.queue;

public class Queue {

	public Link last;

	public Queue() {
		last = null;
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
	}

	public int dequeue() {
		int result;
		if (last.previous == null) {
			result = last.getValue();
			last = null;
		} else {
			result = last.previous.getValue();
			last.previous = last.previous.previous;
		}
		return result;
	}

	public boolean isEmpty() {
		return last == null;
	}
}
