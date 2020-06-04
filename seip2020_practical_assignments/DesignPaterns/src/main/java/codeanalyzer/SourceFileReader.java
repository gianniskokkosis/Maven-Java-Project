package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.net.URL;

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

class LocalFileReader implements SourceFileReader{

    @Override
    public List<String> readFileIntoList(String filepath) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
        lines.add(line);
        }
        reader.close();
        return lines;
    }

    @Override
    public String readFileIntoString(String filepath) throws IOException{
        StringBuilder sb = new StringBuilder();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }
}

class WebFileReader implements SourceFileReader{

    @Override
    public List<String> readFileIntoList(String filepath) throws IOException{
        List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    @Override
    public String readFileIntoString(String filepath) throws IOException{
        StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        reader.close();
        return sb.toString();
    }

}
