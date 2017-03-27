

/**
 * Tipul de nod inmultire
 */
public class Inmultire extends Node {
	String valoare;

	/**
	 * Constructor cu parametru
	 */
	public Inmultire(String s) {
		valoare = s;
	}

	/**
	 * Afiseaza stringul
	 */
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

	/**
	 * Suprascrie stringul
	 */
	@Override
	void set(String s) {
		// TODO Auto-generated method stub
		valoare = s;
	}
}
