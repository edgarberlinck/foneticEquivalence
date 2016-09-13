package localhost.foneticEquivalence.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class FoneticEquivalenceTest {
	List<String> dictionary = new ArrayList<>();
	
	@BeforeClass
	public void loadDictionary () throws IOException {
		File file = new File(getClass().getClassLoader().getResource("dictionary.txt").getPath());
		Files.lines(file.toPath()).forEach((word) -> dictionary.add(word) );		
	}
	
	@Test
	public void loadWords () {
		
	}
}
