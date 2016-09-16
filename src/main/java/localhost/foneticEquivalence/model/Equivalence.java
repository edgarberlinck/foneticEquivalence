package localhost.foneticEquivalence.model;

import java.util.ArrayList;
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

		int matchesRemaining = value1.length();
		String lastEquivalence = null;
		int i = 0;
		for (Character ch : value1.toCharArray()) {
			for (String equivalence : equivalenceList) {
				if (equivalence.indexOf(ch) >= 0) {
					if (equivalence.equals(lastEquivalence)) {
						if (equivalence.indexOf(value2.charAt(i)) >= 0)
							continue;
						
					} else {
						if (equivalence.indexOf(value2.charAt(i)) >= 0) {
							lastEquivalence = equivalence;
							i++;
							matchesRemaining--;
							continue;
						}
					}
				} // -if (equivalence.indexOf(ch) >= 0)
			}
		}

		return true;
	}
}
