package localhost.foneticEquivalence.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import localhost.foneticEquivalence.model.Equivalence;
import localhost.foneticEquivalence.model.Word;

public class FoneticEquivalenceTest {
	List<String> dictionary = new ArrayList<>();
	List<String> arguments = new ArrayList<>();
		
	@Before
	public void loadDictionary () throws IOException {
		File file = new File(getClass().getClassLoader().getResource("dictionary.txt").getPath());
		Files.lines(file.toPath()).forEach((word) -> dictionary.add(word) );
		
		arguments.add("1tom#");
		arguments.add("brief");
		arguments.add("soon");
	}
	
	@Test
	public void createWordFromArgument () {
		String argument = "1tom#";
		Word word = new Word(argument);
		String processedWord = word.getValueToCompare();

		assertTrue(processedWord.equals("tm"));
	}
	
	@Test
	public void equivalenceText () {
		Word word1 = new Word("1tom#");
		Word word2 = new Word("Don");
		
		assertTrue(Equivalence.isEquivalent(word1, word2));
		assertTrue(Equivalence.isEquivalent(word1, new Word("Tooonnnnyyyy")));
		assertTrue(Equivalence.isEquivalent(new Word("brief"), new Word("brave")));
		assertTrue(Equivalence.isEquivalent(new Word("brief"), new Word("Braev")));
		assertTrue(Equivalence.isEquivalent(new Word("soon"), new Word("son")));
		assertTrue(Equivalence.isEquivalent(new Word("soon"), new Word("sunny")));
		assertTrue(Equivalence.isEquivalent(new Word("soon"), new Word("brave")));
		
	}
}
