package localhost.foneticEquivalence.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equivalence {
	private List<String> equivalenceList;
	private static Equivalence instance = new Equivalence();

	private Equivalence() {
		this.equivalenceList = new ArrayList<>();

		equivalenceList.add("aeiou");
		equivalenceList.add("cgjkqsxyz");
		equivalenceList.add("bfpvw");
		equivalenceList.add("dt");
		equivalenceList.add("mn");
	}

	public static boolean isEquivalent(String value1, String value2) {
		Word w1 = new Word(value1);
		Word w2 = new Word(value2);
		return Equivalence.isEquivalent(w1, w2);
	}

	public static boolean isEquivalent(Word word1, Word word2) {
		return instance.testEquivalence(word1.getValueToCompare(), word2.getValueToCompare());
	}

	private boolean testEquivalence(String value1, String value2) {
		System.out.println("Testing equivalence: " + value1 + " | " + value2);
		/*
			1 - Verificar se a palavra possui uma ou mais letras consecutivas pertencentes ao
			mesmo grupo e remover caso encontre.
				1.1 - Neste passo eu posso alterar as palavras para que qualquer letra
				pertencente a algum conjunto de equivalencias receba um valor único, assim
				posso verificar a equivalencia com o equals, conforme passo 3.
			
			2 - Caso exista alguma letra que não esteja em nenhum dos conjuntos descartar qualquer
			possibilidade de equivalência com qualquer palavra
			
			3 - Palavras iguais são equivalentes
								
		*/
		
		//Passo 1
		for (String equivalence : equivalenceList) {
			value1 = zip(value1, equivalence);
			value2 = zip(value2, equivalence);
		}
		
		return value1.equals(value2);
	}

	private String zip (String value, String equivalenceList) {
		boolean sequentialEquivalenceFound = false;
		StringBuilder sb = null;
		for (int i=0; i < value.length(); i++) {
			if (Arrays.binarySearch(equivalenceList.toCharArray(), value.charAt(i)) >= 0) {
				if (!sequentialEquivalenceFound) {
					sb = new StringBuilder(value);
					sb.setCharAt(i, equivalenceList.charAt(0));
					sequentialEquivalenceFound = true;
				} else {
					sequentialEquivalenceFound = false;
				}
			}
		}
		return sb != null? sb.toString() : value;
	}
}
