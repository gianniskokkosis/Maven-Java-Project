package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class SourceCodeAnalyzer{

   	protected SourceFileReader fileReader;
	
	public CodeAnalyzer(SourceFileReader fileReader){
		this.fileReader = fileReader;
	}
	
	public abstract int calculate(String filepath, String analyzerType) 
			throws IOException;
}