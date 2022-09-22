/*
 * Created on 11/12/2008
 *
 */
package performer.contabil.utils;

import java.util.HashMap;
import java.util.Iterator;

public class Criptografia {

	private static HashMap<String, String> valorLetra;

	static {
		valorLetra = new HashMap<String, String>();

		valorLetra.put("0", "WJ");
		valorLetra.put("1", "LX");
		valorLetra.put("2", "/?");
		valorLetra.put("3", "BG");
		valorLetra.put("4", "FR");
		valorLetra.put("5", "IE");
		valorLetra.put("6", "IA");
		valorLetra.put("7", "YL");
		valorLetra.put("8", "WY");
		valorLetra.put("9", "KX");
		valorLetra.put("A", "Q3");
		valorLetra.put("B", "88");
		valorLetra.put("C", "21");
		valorLetra.put("D", "R1");
		valorLetra.put("E", "9W");
		valorLetra.put("F", "RT");
		valorLetra.put("G", "59");
		valorLetra.put("H", "PB");
		valorLetra.put("I", "VZ");
		valorLetra.put("J", "+[");
		valorLetra.put("K", "FQ");
		valorLetra.put("L", "8#");
		valorLetra.put("M", "OW");
		valorLetra.put("N", "J@");
		valorLetra.put("O", "CE");
		valorLetra.put("P", "SC");
		valorLetra.put("Q", "RJ");
		valorLetra.put("R", "MX");
		valorLetra.put("S", "OE");
		valorLetra.put("T", "EM");
		valorLetra.put("U", "ZK");
		valorLetra.put("V", "KC");
		valorLetra.put("W", "TL");
		valorLetra.put("X", "MO");
		valorLetra.put("Y", "UY");
		valorLetra.put("Z", "BO");
		valorLetra.put("a", "SI");
		valorLetra.put("b", "PA");
		valorLetra.put("c", "AY");
		valorLetra.put("d", "?#");
		valorLetra.put("e", "RB");
		valorLetra.put("f", "XV");
		valorLetra.put("g", "ZQ");
		valorLetra.put("h", "AA");
		valorLetra.put("i", "Q7");
		valorLetra.put("j", "C6");
		valorLetra.put("k", "A1");
		valorLetra.put("l", "H1");
		valorLetra.put("m", "W8");
		valorLetra.put("n", "Z0");
		valorLetra.put("o", "B5");
		valorLetra.put("p", "F8");
		valorLetra.put("q", "Z5");
		valorLetra.put("r", "$#");
		valorLetra.put("s", "GD");
		valorLetra.put("t", "G9");
		valorLetra.put("u", "A0");
		valorLetra.put("v", "C5");
		valorLetra.put("w", "9L");
		valorLetra.put("x", "99");
		valorLetra.put("y", "TC");
		valorLetra.put("z", "Z3");
		valorLetra.put("�", "k%");
		valorLetra.put("�", "&|");
		// Especiais
		valorLetra.put("!", "Q@");
		valorLetra.put("@", "oS");
		valorLetra.put("#", "HH");
		valorLetra.put("$", "Bi");
		valorLetra.put("%", "Fa");
		valorLetra.put("&", "zT");
		valorLetra.put("(", "lx");
		valorLetra.put(")", "tr");

	}

	public static String criptografa(String texto) {
		String textoCripto = "";
		if (texto != null) {
			for (int i = 0; i < texto.length(); i++) {
				char c = texto.charAt(i);
				textoCripto += valorLetra.get(String.valueOf(c));
			}
		}
		return textoCripto;
	}

	public static String descriptografa(String texto) {
		String textoDescripto = "";

		for (int i = 0, j = 2; i < texto.length(); i += 2, j += 2) {
			String c = texto.substring(i, j);
			textoDescripto += getLetraByValor(c);
		}
		return textoDescripto;
	}

	private static String getLetraByValor(String value) {
		Iterator<String> it = valorLetra.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (valorLetra.get(key).equals(value))
				return key;
		}
		return "-1";
	}
}
