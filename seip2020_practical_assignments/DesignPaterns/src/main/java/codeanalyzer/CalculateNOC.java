package codeanalyzer;

import java.io.IOException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateNOC extends SourceCodeAnalyzer{

    public CalculateNOC(SourceFileReader fileReader) {
		super(fileReader);
	}
    
    @Override
    public int calculateMetric(String filepath, String analyzerType)
            throws IOException{
		if(analyzerType.equals("regex")) {
            String sourceCode = fileReader.readFileIntoString(filepath);
            Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
            Matcher classSignatures = pattern.matcher(sourceCode);

            int classCounter = 0;
            while (classSignatures.find()) {
                classCounter++;
            }
            return classCounter;
		} else if (analyzerType.equals("strcomp")) {
            List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
            int classCounter = 0;
            for (String line : sourceCodeList) {
                line = line.strip(); //remove leading and trailing white spaces
                if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                    classCounter++;
                }
            }
            return classCounter; 
		}
        return -1;
    }
}