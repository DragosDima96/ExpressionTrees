
/**
 * Tipul de nod scadere
 */
public class Scadere extends Node {
	String valoare;

	/**
	 * Constructor cu parametru
	 */
	public Scadere(String s) {
		valoare = s;
	}

	/**
	 * returneaza stringul
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

	@Override
	/**
	 * seteaza stringul la o valoare
	 */
	void set(String s) {
		// TODO Auto-generated method stub
		valoare = s;
	}
}
