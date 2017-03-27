

/**
 * Clasa abstracta,este mostenita de diferite tipuri de noduri
 */
abstract public class Node {

	Node st;
	Node dr;

	abstract void set(String s);

	abstract String show();

	void accept(Visitor visitor) {
	}

}
