

/**
 * Clasa factory
 */
public class Factory {

	private static final Factory instance = new Factory();

	/**
	 * Constructor privat pentru singleton
	 */
	private Factory() {

	}

	/**
	 * Returneaza instanta deja existenta pentru singleton
	 */
	public static Factory getIstance() {
		return instance;

	}

	/**
	 * Returneaza nodul pentru factory
	 */
	public static Node createNode(String NodeType) {
		if (NodeType.equals("+"))
			return new Adunare(NodeType);
		if (NodeType.equals("-"))
			return new Scadere(NodeType);
		if (NodeType.equals("*"))
			return new Inmultire(NodeType);
		if (NodeType.equals("/"))
			return new Impartire(NodeType);

		return new Variable(NodeType);
	}
}
