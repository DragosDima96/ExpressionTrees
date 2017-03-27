

/**
 * Nod de tip impartire
 */
public class Impartire extends Node {
	String valoare;

	/**
	 * Constructor cu un parametru
	 */
	public Impartire(String s) {
		valoare = s;
	}

	/**
	 * Afiseaza stringul
	 */
	@Override
	String show() {
		// TODO Auto-generated method stub
		return valoare;
	}

	/**
	 * Pentru visitor
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	/**
	 * Seteaza stringul la o valoare
	 */
	void set(String s) {
		// TODO Auto-generated method stub
		valoare = s;
	}
}
