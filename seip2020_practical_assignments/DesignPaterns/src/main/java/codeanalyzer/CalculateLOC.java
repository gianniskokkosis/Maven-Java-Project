package codeanalyzer;

import java.io.IOException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateLOC extends SourceCodeAnalyzer{

    public CalculateLOC(SourceFileReader fileReader) {
		super(fileReader);
	}

    @Override
    public int calculateMetric(String filepath, String analyzerType) 
            throws IOException{
        if(analyzerType.equals("regex")) {
            String sourceCode = fileReader.readFileIntoString(filepath);
            Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
            Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

            int nonCodeLinesCounter = 0;
            while (nonCodeLinesMatcher.find()) {
                nonCodeLinesCounter++;
            }

            int sourceFileLength = sourceCode.split("\n").length;
            int loc =  sourceFileLength - nonCodeLinesCounter;

            return loc;
		} else if (analyzerType.equals("strcomp")) {
            List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
            int nonCodeLinesCounter = 0;
            for (String line : sourceCodeList) {
                line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
                if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
                    nonCodeLinesCounter++;
            }
            int loc = sourceCodeList.size() - nonCodeLinesCounter;
            return loc; 
		}
        return -1;
    }
}