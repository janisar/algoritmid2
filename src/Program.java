import alg.massive.Massive;

public class Program {

	public static void main(String args[]) {
		Massive m = new Massive();
		m.create(10);
		m.add(2);
		m.add(1);
		m.add(10);
		int i = m.get(2);
		System.out.println(i);
		System.out.println(m.length());
	}
}
