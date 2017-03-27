

/**
 * Nodul de tip variabila
 */
public class Variable extends Node {

	String valoare;

	/**
	 * Constructor cu un parametru
	 */
	public Variable(String s) {
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
	 * Seteaza stringul
	 */
	@Override
	void set(String s) {
		// TODO Auto-generated method stub
		valoare = s;
	}
}
