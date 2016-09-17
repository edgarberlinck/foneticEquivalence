package localhost.foneticEquivalence;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		if (args.length < 2)
			throw new IllegalArgumentException("Invalid number of arguments provided.");
		
		List<String> argumentList = new ArrayList<>();
		List<String> dictionary = new ArrayList<>();
				
		for (int i=0; i< args.length-1; i++)
			argumentList.add(args[i]);
		
		File file = new File(args[args.length-1]);
		try {
			Files.lines(file.toPath()).forEach((word) -> dictionary.add(word) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FoneticEquivalenceApp app = new FoneticEquivalenceApp(argumentList, dictionary);
		app.showEquivalentWords();
	}

	public void showEquivalentWords() {
		for (Entry<String, List<String>> entry : foneticEquivalence.entrySet()) {
			System.out.println(String.format("%s: %s", entry.getKey(), entry.getValue().toString()));			
		}
	}

}
