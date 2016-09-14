package localhost.foneticEquivalence.model;

import java.util.ArrayList;
import java.util.List;

public class Equivalence {
	private List<String[]> equivalenceList;
	private Equivalence instance = new Equivalence();
	
	private Equivalence () {
		this.equivalenceList = new ArrayList<>();
		
		equivalenceList.add(new String[] {"a", "e", "i", "o", "u"});
		equivalenceList.add(new String[] {"c", "g", "j", "k", "q", "s", "x", "y", "z"});
		equivalenceList.add(new String[] {"b", "f", "p", "v", "w"});
		equivalenceList.add(new String[] {"d", "t"});
		equivalenceList.add(new String[] {"m", "n"});
	}
	
	public static Boolean isEquivalent(String value1, String value2) {
		//TODO
		return false;
	}
}
