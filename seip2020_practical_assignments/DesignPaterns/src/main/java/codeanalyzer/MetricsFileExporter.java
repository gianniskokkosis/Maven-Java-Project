package codeanalyzer;

import java.util.Map;

public interface MetricsFileExporter {
	
	public void writeFile(String outputType, Map<String, Integer> metrics, String filepath);
}