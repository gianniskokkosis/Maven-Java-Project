package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface SourceCodeAnalyzer{

    public int calculateMetric(String filepath, String analyzerType, String sourceFileLocation);
}