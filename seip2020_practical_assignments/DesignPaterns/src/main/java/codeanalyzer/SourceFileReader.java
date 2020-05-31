package codeanalyzer;

import java.io.IOException;
import java.util.List;
/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web.
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 *
 */
public interface SourceFileReader{

	public List<String> readFileIntoList(String filepath) throws IOException;
	
	public String readFileIntoString(String filepath) throws IOException;
}
