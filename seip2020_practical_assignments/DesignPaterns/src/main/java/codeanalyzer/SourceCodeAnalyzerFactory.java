package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class SourceCodeAnalyzerFactory{

    public List<SourceCodeAnalyzer> createSourceCodeAnalyzerObjs(String sourceFileLocation){

        List<SourceCodeAnalyzer> objs = new ArrayList<SourceCodeAnalyzer>();
		SourceCodeAnalyzer analyzeLoc = null;
		SourceCodeAnalyzer analyzeNoc = null;
		SourceCodeAnalyzer analyzeNom = null;
		if (sourceFileLocation.equals("web")) {
			analyzeLoc = new CalculateLOC(new WebFileReader());
			analyzeNoc = new CalculateNOC(new WebFileReader());
			analyzeNom = new CalculateNOM(new WebFileReader());
		}else if (sourceFileLocation.equals("local")) {
			analyzeLoc = new CalculateLOC(new LocalFileReader());
			analyzeNoc = new CalculateNOC(new LocalFileReader());
			analyzeNom = new CalculateNOM(new LocalFileReader());
		}
		
		objs.add(analyzeLoc);
		objs.add(analyzeNoc);
		objs.add(analyzeNom);
		
		return objs;

    }
}