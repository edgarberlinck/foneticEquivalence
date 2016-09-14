package localhost.foneticEquivalence.model;

import java.util.ArrayList;
import java.util.List;

public class Equivalence {
	private List<String[]> equivalenceList;
	private static Equivalence instance = new Equivalence();
	
	private Equivalence () {
		this.equivalenceList = new ArrayList<>();
		
		equivalenceList.add(new String[] {"a", "e", "i", "o", "u"});
		equivalenceList.add(new String[] {"c", "g", "j", "k", "q", "s", "x", "y", "z"});
		equivalenceList.add(new String[] {"b", "f", "p", "v", "w"});
		equivalenceList.add(new String[] {"d", "t"});
		equivalenceList.add(new String[] {"m", "n"});
	}
	
	public static boolean isEquivalent(String value1, String value2) {
		return instance.testEquivalence(value1, value2);
	}

	public static boolean isEquivalent(Word word1, Word word2) {
		return Equivalence.isEquivalent(word1.getValueToCompare(), word2.getValueToCompare());
	}
	
	private boolean testEquivalence(String value1, String value2) {
		System.out.println("Testing equivalence: "+value1 + " | "+value2);
		/**
		 * Para cada letra testar o seguinte:
		 * 	Se a respectiva letra em A é igual ou equivalente a B.
		 * 	
		 */
		return true;
	}
	
	
}
