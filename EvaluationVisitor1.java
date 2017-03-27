

import java.text.DecimalFormat;

import javax.annotation.processing.RoundEnvironment;

public class EvaluationVisitor implements Visitor {

	Valori[] values = new Valori[1000];
	String output;

	/**
	 * Adauga valori,la vectori de tip Valori
	 */
	void add(String a, String b, String c) {
		int i = 0;
		while (values[i] != null && values[i].nume_operator != a)
			i++;

		values[i] = new Valori(a, b, c);
	}

	/**
	 * Operatia intre int si int
	 */
	String oper1(int x, int y, String s) {
		String nou = "";
		int w = 0;

		if (s.equals("+")) {
			w = x + y;
			nou = nou + w;
			nou = nou + "int";

			return nou;
		}
		if (s.equals("*")) {
			w = x * y;
			nou = nou + w;
			nou = nou + "int";
			return nou;
		}
		if (s.equals("-")) {
			w = x - y;
			nou = nou + w;
			nou = nou + "int";
			return nou;
		}
		if (s.equals("/")) {
			if (y != 0)
				w = x / y;
			else {
				nou = "NaNint";
				return nou;
			}
			nou = nou + w;
			nou = nou + "int";
			return nou;
		}

		return null;

	}
/**
 * Operatia intre double si double
 */
	String oper2(Double x, Double y, String s) {
		String nou = "";
		Double w;

		if (s.equals("+")) {
			w = x + y;
			nou = nou + w;
			nou = nou + "Double";

			return nou;
		}
		if (s.equals("*")) {
			w = x * y;
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}
		if (s.equals("-")) {
			w = x - y;
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}
		if (s.equals("/")) {
			if (y == 0) {

				nou = "NaNDouble";
				return nou;
			}

			w = x / y;
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}

		return null;

	}

	/**
	 * Operatia intre int si double
	 */
	String oper3(int x, double y, String s) {
		String nou = "";
		Double w = 0.0;

		if (s.equals("+")) {
			w = x + y;
			nou = nou + w;
			nou = nou + "Double";

			return nou;
		}
		if (s.equals("*")) {
			w = x * y;
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}
		if (s.equals("-")) {
			w = x - y;
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}
		if (s.equals("/")) {
			if (y != 0)
				w = x / y;
			else {
				nou = "NaNDouble";
				return nou;
			}
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}

		return null;
	}
/**
 * Operatie intre double si int
 */
	String oper4(double y, int x, String s) {
		String nou = "";
		Double w = 0.0;

		if (s.equals("+")) {
			w = x + y;
			nou = nou + w;
			nou = nou + "Double";

			return nou;
		}
		if (s.equals("*")) {
			w = x * y;
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}
		if (s.equals("-")) {
			w = y - x;
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}
		if (s.equals("/")) {
			if (x != 0)
				w = y / x;
			else {
				nou = "NaNDouble";
				return nou;
			}
			nou = nou + w;
			nou = nou + "Double";
			return nou;
		}

		return null;
	}

	/**
	 * Operatie intre string si int
	 */
	String oper5(String y, int x, String s) {
		String nou = "";

		if (s.equals("+")) {
			y = y + x;
			nou = y + "String";
			return nou;
		}
		if (s.equals("*")) {
			for (int i = 0; i < x; i++)
				nou = nou + y;
			nou = nou + "String";
			return nou;
		}

		if (s.equals("/")) {
			if (x > 0)
				nou = y.substring(0, y.length() / x);
			else
				nou = y;

			nou = nou + "String";
			return nou;
		}

		if (s.equals("-")) {
			if (x < y.length())
				if (x > 0)
					nou = y.substring(0, y.length() - x);
			if (x < 0) {
				x = Math.abs(x);
				nou = y;
				for (int i = 0; i < x; i++)
					nou = nou + "#";
				nou = nou + "String";
				return nou;
			}
			if (x == 0)
				nou = y;
			nou = nou + "String";
			return nou;
		}

		return null;
	}

	/**
	 * Operatie intre int si string
	 */
	String oper6(int x, String y, String s) {
		String nou = "";
		if (s.equals("*")) {
			for (int i = 0; i < x; i++)
				nou = nou + y;
			nou = nou + "String";
			return nou;
		}

		if (s.equals("+")) {
			nou = nou + x;
			nou = nou + y;
			nou = nou + "String";
			return nou;
		}

		if (s.equals("/")) {
			int lg = 0;
			if (y.length() != 0)
				lg = x / y.length();
			else {
				nou = "NaNint";
				return nou;
			}
			nou = nou + lg;
			nou = nou + "int";
			return nou;
		}
		if (s.equals("-")) {
			int lg = x - y.length();
			nou = nou + lg;
			nou = nou + "int";
			return nou;
		}

		return null;
	}
/**
 * Operatie intre double si string
 */
	String oper7(Double x, String y, String s, int ok) {
		String nou = "";
		int nr = 0;
		if (s.equals("+")) {
			DecimalFormat df = new DecimalFormat("0.0#");
			if(ok == 1)
			x = Math.round(x*100.0)/100.0;
			String value = df.format(x);
			value = value.replaceAll(",", ".");
			if (ok == 0)
				nou = nou + x;
			else
				nou = nou + value;
			nou = nou + y;
			nou = nou + "String";
			return nou;
		}

		if (s.equals("*")) {
			nr = y.length();
			Double val = x * nr;
			nou = nou + val;
			nou = nou + "Double";
			return nou;

		}
		if (s.equals("-")) {
			nr = y.length();
			Double val = x - nr;
			nou = nou + val;
			nou = nou + "Double";
			return nou;

		}

		if (s.equals("/")) {
			nr = y.length();
			if (nr == 0) {
				nou = "NaNDouble";
				return nou;
			}
			Double val = x / nr;
			nou = nou + val;
			nou = nou + "Double";
			return nou;

		}

		return null;
	}
/**
 * Operatie intre string si double
 */
	String oper8(String x, Double y, String s, int ok) {
		String nou = "";
		if (s.equals("+")) {
			DecimalFormat df = new DecimalFormat("0.0#");
			if(ok == 1)
			y = Math.round(y*100.0)/100.0;
			String value = df.format(y);
			value = value.replaceAll(",", ".");
			// Double values = Double.parseDouble(value);
			// System.out.println(values);
			// System.out.println(y);
			// System.out.println(y);
			// System.out.println(value);
			nou = nou + x;
			if (ok == 0)
				nou = nou + y;
			else
				nou = nou + value;
			nou = nou + "String";
			return nou;
		}
		if (s.equals("*")) {
			int nr = 0;
			nr = x.length();
			Double val = y * nr;
			nou = nou + val;
			nou = nou + "Double";
			return nou;

		}
		if (s.equals("-")) {
			int nr = 0;
			nr = x.length();
			Double val = nr - y;
			nou = nou + val;
			nou = nou + "Double";
			return nou;
		}
		if (s.equals("/")) {
			int nr = 0;
			nr = x.length();
			if (y == 0.0) {
				nou = "NaNDouble";
				return nou;
			}
			Double val = nr / y;
			nou = nou + val;
			nou = nou + "Double";
			return nou;
		}

		return null;
	}
/**
 * Operatie intre string si string,daca semnul este diferit de plus
 * se foloseste de operatie intre int si int
 */
	String oper9(String a, String b, String s) {
		String nou = "";
		int x = a.length();
		int y = b.length();
		if (s.equals("+")) {
			nou = nou + a;
			nou = nou + b;
			nou = nou + "String";
			return nou;
		} else
			nou = oper1(x, y, s);
		return nou;

	}

	/**
	 * Cauta in vector de tip Valori,numele variabilei,trimis ca parametru ca string
	 */
	Valori get(String a) {
		int i = 0;
		while (values[i] != null) {
			if (values[i].nume_operator.equals(a))
				return values[i];
			i++;
		}

		return null;
	}

/**
 * Functie recursiva ce evalueaza arborele primeste parametru nodul radacina
 * Daca nodul stanga si drept sunt diferite de variable
 * Atunci nodul respectiv primeste aceasta functie apelat recursiv
 * Daca ajungem la un moment dat la un nod ce are ca fii 2 variabile
 * Atunci in functie de tipul variabilelor aplic una dintre functiile de mai sus
 * Rescriu valoare peste nodul parinte al acestor noduri
 * La final valoare din nodul parinte este raspunsul arborelui
 */
	Node solve(Node top) {

		Valori st = null;
		Valori dr = null;
		String str = null;
		String str1 = null;
		if (top.st.show().equals("+") || top.st.show().equals("-") || top.st.show().equals("*")
				|| top.st.show().equals("/"))
			top.st = solve(top.st);

		if (top.dr.show().equals("+") || top.dr.show().equals("-") || top.dr.show().equals("*")
				|| top.dr.show().equals("/"))
			top.dr = solve(top.dr);

		st = get(top.st.show());
		dr = get(top.dr.show());
		if (st != null) {
			if (st.tip.equals("int")) {
				str = st.valoare;
				str = str + "int";
			}

			if (st.tip.equals("Double")) {
				str = st.valoare;
				str = str + "Double";

			}
			if (st.tip.equals("String")) {
				str = st.valoare;
				str = str + "String";
			}
		}
		if (dr != null) {
			if (dr.tip.equals("int")) {
				str1 = dr.valoare;
				str1 = str1 + "int";
			}
			if (dr.tip.equals("Double")) {
				str1 = dr.valoare;
				str1 = str1 + "Double";
			}
			if (dr.tip.equals("String")) {
				str1 = dr.valoare;
				str1 = str1 + "String";
			}
		}

		if (st == null)
			str = top.st.show();
		if (dr == null)
			str1 = top.dr.show();

		top.set(retrieve(str, str1, top.show()));
		output = top.show();

		return top;
	}
/**
 * Functie in care verific tipul variabilelor,extrag adaugarea mea(int,Double,String) la finalul valorilor pentru a stii tipul
 * Aplic functiile in functie de tip
 */
	String retrieve(String unu, String doi, String oper) {
		String nou = "";
		String valoare1;
		String valoare2;
		int trb = 1;
		int ok = 1;
		int cast_int;
		Double cast_Double;
		int cast_int2;
		Double cast_Double2;
		valoare1 = unu.substring(unu.length() - 3, unu.length());
		valoare2 = doi.substring(doi.length() - 3, doi.length());
		if (valoare1.equals("int")) {
			valoare1 = unu.substring(0, unu.length() - 3);
			if (valoare1.equals("NaN"))
				ok = 0;
			if (valoare2.equals("ble")) {
				valoare2 = doi.substring(0, doi.length() - 6);
				if (valoare2.equals("NaN") || ok == 0) {
					nou = "NaNDouble";
					return nou;
				}
				cast_Double = Double.parseDouble(doi.substring(0, doi.length() - 6));
				cast_int = Integer.parseInt(valoare1);
				nou = oper3(cast_int, cast_Double, oper);
				return nou;
			}
			if (valoare2.equals("int")) {
				valoare2 = doi.substring(0, doi.length() - 3);
				if (valoare2.equals("NaN") || ok == 0) {
					nou = "NaNint";
					return nou;

				}

				cast_int2 = Integer.parseInt(doi.substring(0, doi.length() - 3));
				cast_int = Integer.parseInt(valoare1);
				nou = oper1(cast_int, cast_int2, oper);
				return nou;
			}
			if (valoare2.equals("ing")) {
				if (ok == 0 && oper.equals("-")) {
					nou = "NaNint";
					return nou;
				}
				if (ok == 0 && oper.equals("/")) {
					nou = "NaNint";
					return nou;
				}
				if (ok == 0 && oper.equals("*")) {
					nou = "";
					return nou;

				}
				if (ok == 0 && oper.equals("+")) {
					nou = nou + "NaN";
					nou = nou + doi.substring(0, doi.length() - 6);
					nou = nou + "String";
					return nou;
				}

				valoare2 = doi.substring(0, doi.length() - 6);
				cast_int = Integer.parseInt(valoare1);
				nou = oper6(cast_int, valoare2, oper);
				return nou;

			}

		}

		if (valoare1.equals("ble")) {
			valoare1 = unu.substring(0, unu.length() - 6);
			if (valoare1.equals("NaN"))
				ok = 0;

			if (valoare2.equals("ble")) {
				valoare2 = doi.substring(0, doi.length() - 6);
				if (valoare2.equals("NaN") || ok == 0) {
					nou = "NaNDouble";
					return nou;
				}
				cast_Double2 = Double.parseDouble(doi.substring(0, doi.length() - 6));
				cast_Double = Double.parseDouble(valoare1);
				nou = oper2(cast_Double, cast_Double2, oper);
				return nou;
			}
			if (valoare2.equals("int")) {
				valoare2 = doi.substring(0, doi.length() - 3);
				if (valoare2.equals("NaN") || ok == 0) {
					nou = "NaNDouble";
					return nou;

				}
				cast_int = Integer.parseInt(doi.substring(0, doi.length() - 3));
				cast_Double = Double.parseDouble(valoare1);
				nou = oper4(cast_Double, cast_int, oper);
				return nou;
			}

			if (valoare2.equals("ing")) {
				if (ok == 0 && oper.equals("-")) {
					nou = "NaNDouble";
					return nou;
				}
				if (ok == 0 && oper.equals("/")) {
					nou = "NaNDouble";
					return nou;
				}
				if (ok == 0 && oper.equals("*")) {
					nou = "NaNDouble";
					return nou;
				}
				valoare2 = doi.substring(0, doi.length() - 6);
				cast_Double = Double.parseDouble(valoare1);
				nou = oper7(cast_Double, valoare2, oper, ok);
				return nou;
			}

		}

		if (valoare1.equals("ing")) {
			valoare1 = unu.substring(0, unu.length() - 6);
			if (valoare2.equals("int")) {
				valoare2 = doi.substring(0, doi.length() - 3);
				if (valoare2.equals("NaN")) {
					if (oper.equals("*")) {
						nou = "";
						return nou;
					}
					if (oper.equals("-")) {
						nou = valoare1;
						return nou;
					}
					if (oper.equals("/")) {
						nou = valoare1;
						return nou;
					}

				}
				cast_int = Integer.parseInt(doi.substring(0, doi.length() - 3));
				nou = oper5(valoare1, cast_int, oper);
				return nou;
			}
			if (valoare2.equals("ing")) {
				valoare2 = doi.substring(0, doi.length() - 6);
				nou = oper9(valoare1, valoare2, oper);
				return nou;
			}

			if (valoare2.equals("ble")) {
				valoare2 = doi.substring(0, doi.length() - 6);
				if (valoare2.equals("NaN")) {
					if (oper.equals("-")) {
						nou = "NaNDouble";
					}
					if (oper.equals("/")) {
						nou = "NaNDouble";
					}
					if (oper.equals("*")) {
						nou = "NaNDouble";
					}

					trb = 0;
				}
				cast_Double = Double.parseDouble(doi.substring(0, doi.length() - 6));
				nou = oper8(valoare1, cast_Double, oper, trb);
				return nou;

			}

		}

		return nou;
	}

	@Override
	public Node visit(Variable nod) {

		return null;
	}

	@Override
/**
 * Acest visit intoarce solve de arbore,astfel modificand arborele
 */
	public Node visit(Adunare nod) {

		return solve(nod);
	}

/**
 * **
 * Acest visit intoarce solve de arbore,astfel modificand arborele
 */
 */
	@Override
	public Node visit(Scadere nod) {

		return solve(nod);
	}

/**
 * 
 * Acest visit intoarce solve de arbore,astfel modificand arborele
 */
 @Override
	public Node visit(Inmultire nod) {
		// TODO Auto-generated method stub

		return solve(nod);
	}

	@Override
	/**
	 * Acest visit intoarce solve de arbore,astfel modificand arborele
	 */
	public Node visit(Impartire nod) {
		// TODO Auto-generated method stub
		return solve(nod);
	}

}
