package codeanalyzer;

import java.io.IOException;

public abstract class SourceCodeAnalyzer{

   	protected SourceFileReader fileReader;
	
	public CodeAnalyzer(SourceFileReader fileReader){
		this.fileReader = fileReader;
	}
	
	public abstract int calculate(String filepath, String analyzerType) 
			throws IOException;
}