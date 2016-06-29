import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;



public class main {

	public static void main(String[] args) {
		LinkFinder finder = new LinkFinder();
		try {
			FileInputStream fileInputStream = new FileInputStream("src/neumont.edu");
			finder.processPage(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Iterator<String> iterator = finder.getLinks();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}	

	}

}
