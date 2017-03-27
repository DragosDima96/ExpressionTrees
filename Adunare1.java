

/**
 * Nodul de tip adunare
 */
public class Adunare extends Node {

	String valoare;

	/**
	 * Constrcutor cu un parametru
	 */
	public Adunare(String s) {
		valoare = s;
	}

	/**
	 * Metoda ce afiseaza stringul
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

	/**
	 * Seteaza stringul
	 */
	@Override
	void set(String s) {
		// TODO Auto-generated method stub
		valoare = s;
	}

}
