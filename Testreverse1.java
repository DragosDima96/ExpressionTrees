

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.text.DecimalFormat;

public class Testreverse {

	/**
	 * Metoda ce intoarce un string fara prima si ultima paranteza,primind ca
	 * parametru un vector de stringuri
	 */
	public String paranteze(String[] s) {
		String nou = "";
		int i = 0;
		while (i < s.length)
			i++;

		i = i - 1;
		for (int j = 1; j < i; j++)
			if (j == i - 1)
				nou = nou + s[j];
			else
				nou = nou + s[j] + " ";

		return nou;
	}

	/**
	 * Metoda ce verifica ultima aparitia a semnul '+' sau '-' intr-un vector de
	 * stringuri
	 */
	public int check_plus(String[] s) {

		int k = -1;
		int paranteza = 0;
		int i = 0;
		while (i < s.length) {
			if (s[i].equals("("))
				paranteza++;
			if (s[i].equals(")"))
				paranteza--;
			if (paranteza == 0)
				if (s[i].equals("+") || s[i].equals("-"))
					k = i;

			i++;
		}

		return k;
	}

	/**
	 * Metoda ce verifica ultima aparitie a semnului de '*' sau '/' intr-un
	 * vector de stringuri
	 */
	public int check_inmultire(String[] s) {

		int k = -1;
		int paranteza = 0;
		int i = 0;
		while (i < s.length) {
			if (s[i].equals("("))
				paranteza++;
			if (s[i].equals(")"))
				paranteza--;
			if (paranteza == 0)
				if (s[i].equals("*") || s[i].equals("/"))
					k = i;

			i++;
		}

		return k;
	}

	/**
	 * Metoda ce intoarce un string ,cu stringurile dintr-un vector de stringuri
	 * ce se afla pe o pozitie mai mica decat i
	 */

	public String returnare(String[] s, int i) {

		String nou = "";

		for (int j = 0; j < i; j++)
			if (j == i - 1)
				nou = nou + s[j];
			else
				nou = nou + s[j] + " ";
		return nou;
	}

	/**
	 * Metoda ce intoarce un string,cu stringurie dintr-un vector de stringuri
	 * ce se afla pe o pizitie mai mare ca i
	 */
	public String returnare2(String[] s, int i) {
		String nou = "";
		int j = i + 1;
		while (j < s.length) {
			if (j == s.length - 1)
				nou = nou + s[j];
			else
				nou = nou + s[j] + " ";
			j++;
		}
		return nou;
	}

	/**
	 * Functie recursiva,creeaza arborele Verifica daca exista plus sau minus(ce
	 * nu se afla intre paranteza) Daca da il intoarce pe ultimul,creeaz un nod
	 * de tipul semnului gasit si nodul din stanga primeste expresia de pana la
	 * semnul gasit Nodul din drepata de la semnul gasit pana la final Daca nu
	 * exista plus sau minus cauta imnultire sau impartire Daca nu exista,atunci
	 * ramana 2 posibilita,fie sunt paranteze si revalueaza expresia fara prima
	 * si ultima paranteza Fie exista doar o variabila si creeaza un nod cu ea
	 */
	public Node create(String operatia, Node top, Factory NodeFactory) {
		Node nou;
		String first;
		String second;
		boolean plus = false;
		boolean inmultit = false;
		int i = 0;
		String[] word = new String[1000];
		word = operatia.split(" ");
		if (word.length == 1) {
			nou = NodeFactory.createNode(word[0]);
			top = nou;
		} else {
			i = check_plus(word);
			if (i != -1) {
				plus = true;
				nou = NodeFactory.createNode(word[i]);
				top = nou;
				first = returnare(word, i);
				second = returnare2(word, i);
				top.st = create(first, top.st, NodeFactory);
				top.dr = create(second, top.dr, NodeFactory);
			}

			if (plus == false) {
				i = check_inmultire(word);
				if (i != -1) {
					inmultit = true;
					nou = NodeFactory.createNode(word[i]);
					top = nou;
					first = returnare(word, i);
					second = returnare2(word, i);
					top.st = create(first, top.st, NodeFactory);
					top.dr = create(second, top.dr, NodeFactory);
				}

			}

			if (plus == false)
				if (inmultit == false) {
					first = paranteze(word);
					top = create(first, top, NodeFactory);
				}
		}

		return top;
	}

	public static void main(String[] args) throws IOException {

		BufferedWriter wr;
		wr = new BufferedWriter(new FileWriter("arbore.out"));
		String operatie;
		Factory NodeFactory = Factory.getIstance();
		EvaluationVisitor evaluate = new EvaluationVisitor();
		BufferedReader br = null;
		Node top = null;
		Testreverse nou = new Testreverse();
		br = new BufferedReader(new FileReader("arbore.in"));
		String[] word = new String[1000];
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) {
			word = sCurrentLine.split(" ");
			word[word.length - 1] = word[word.length - 1].substring(0, word[word.length - 1].length() - 1);
			if (word[0] != "eval") {
				if (word[0].equals("string")) {
					int nr = sCurrentLine.indexOf('"');
					String asa = sCurrentLine.substring(nr + 1, sCurrentLine.length() - 2);
					evaluate.add("String", word[1], asa);

				}
				if (word[0].equals("double"))
					evaluate.add("Double", word[1], word[3]);
				if (word[0].equals("int"))
					evaluate.add("int", word[1], word[3]);

			}
			if (word[0].equals("eval")) {
				DecimalFormat df = new DecimalFormat("0.0#");
				operatie = nou.returnare2(word, 0);
				top = nou.create(operatie, top, NodeFactory);
				top.accept(evaluate);
				if (evaluate.output.charAt(evaluate.output.length() - 1) == 't') {
					evaluate.output = evaluate.output.substring(0, evaluate.output.length() - 3);
					wr.write(evaluate.output);
					wr.newLine();
				}

				if (evaluate.output.charAt(evaluate.output.length() - 1) == 'e') {
					evaluate.output = evaluate.output.substring(0, evaluate.output.length() - 6);
					if (evaluate.output.equals("NaN")) {
						wr.write("NaN");
						wr.newLine();
					} else {
						String test = df.format(Double.parseDouble(evaluate.output));
						test = test.replaceAll(",", ".");
						wr.write(test);
						wr.newLine();
					}
				}
				if (evaluate.output.charAt(evaluate.output.length() - 1) == 'g') {
					evaluate.output = evaluate.output.substring(0, evaluate.output.length() - 6);
					wr.write(evaluate.output);
					wr.newLine();
				}
				top = null;

			}

		}
		wr.close();

		// System.out.println(top.show());
		// System.out.println("da")

		// System.out.println(evaluate.values.length);

		// System.out.println(evaluate.values[0]);

		// evaluate.values[1].add("b","int","2");
		// evaluate.values[2].add("c","int","2");
		// String fmm = "123323232323000900Double";
		// System.out.println(evaluate.retrieve(fmm,null,null));

		// top = NodeFactory.createNode("a");
		// top = NodeFactory.createNode("a");
		// top.st = NodeFactory.createNode("b");
		// top.dr = NodeFactory.createNode("d");

	}
}
