package localhost.foneticEquivalence.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
	
//	@Test
//	public void loadWords () {
//		arguments.forEach((arg) -> {
//			
//		});
//	}
}
