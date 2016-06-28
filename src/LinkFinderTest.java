import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.junit.Test;


public class LinkFinderTest {

	@Test
	public void test() {
		
		LinkFinder lf = new LinkFinder();
		 try {
			FileInputStream fileInputStream = new FileInputStream("src/neumont.edu");
			lf.processPage(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		 Iterator<String> testIterator = lf.getLinks();
		 BufferedReader reader = null;
		 do{
			FileInputStream resultFile;
			try {
				resultFile = new FileInputStream("src/results");
				reader = new BufferedReader(new InputStreamReader(resultFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			  try {
				assertTrue(testIterator.next().equals(reader.readLine()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }while(testIterator.hasNext());
		 
	}

}
