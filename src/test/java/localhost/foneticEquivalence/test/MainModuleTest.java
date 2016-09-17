package localhost.foneticEquivalence.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import localhost.foneticEquivalence.FoneticEquivalenceApp;

public class MainModuleTest {

	@Test
	public void mainModuleArgumentReadingTest () throws IOException {
		String[] args = new String[]{"1tom#", "brief", "soon", "dictionary.txt"};
		
		List<String> argumentList = new ArrayList<>();
		List<String> dictionary = new ArrayList<>();
				
		for (int i=0; i< args.length-1; i++)
			argumentList.add(args[i]);
		
		File file = new File(getClass().getClassLoader().getResource(args[args.length-1]).getPath());
		Files.lines(file.toPath()).forEach((word) -> dictionary.add(word) );
		
		assertTrue(argumentList.size() == 3);
		assertTrue(dictionary.size() == 11);
		
		FoneticEquivalenceApp app = new FoneticEquivalenceApp(argumentList, dictionary);
		app.showEquivalentWords();
		
	}
}
