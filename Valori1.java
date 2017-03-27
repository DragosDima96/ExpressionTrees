

/**
 * Clasa in care retine valorile Parametrul valoare o sa fie valoarea
 * efectiva,urmat de tip; ex:2int,3.45Double;
 */
public class Valori {

	String nume_operator;
	String tip;
	String valoare;

	/**
	 * Constructor cu 3 parametrii
	 */
	public Valori(String s1, String s2, String s3) {
		tip = s1;
		nume_operator = s2;
		valoare = s3;
	}

}
