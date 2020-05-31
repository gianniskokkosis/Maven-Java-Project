package codeanalyzer;

import java.io.IOException;

public abstract class SourceCodeAnalyzer{

   	protected SourceFileReader fileReader;
	
	public SourceCodeAnalyzer(SourceFileReader fileReader){
		this.fileReader = fileReader;
	}
	
	public abstract int calculateMetric(String filepath, String analyzerType) 
			throws IOException;
}