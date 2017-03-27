

/**
 * Interfata visitor
 */
public interface Visitor {

	Node visit(Variable nod);

	Node visit(Adunare nod);

	Node visit(Scadere nod);

	Node visit(Inmultire nod);

	Node visit(Impartire nod);

}
