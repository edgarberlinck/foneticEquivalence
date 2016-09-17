package localhost.foneticEquivalence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import localhost.foneticEquivalence.model.Equivalence;

public class FoneticEquivalenceApp {

	private Map<String, List<String>> foneticEquivalence;

	public FoneticEquivalenceApp(List<String> argumentList, List<String> dictionary) {
		this.foneticEquivalence = new HashMap<>();
		for (String s : argumentList) {
			foneticEquivalence.put(s, new ArrayList<>());
			for (String d : dictionary)
				if (Equivalence.isEquivalent(s, d)) 
					foneticEquivalence.get(s).add(d);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void showEquivalentWords() {
		// TODO Auto-generated method stub
		
	}

}
