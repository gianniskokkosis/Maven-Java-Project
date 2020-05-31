package codeanalyzer;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facade {
	
	public void executeOperation(String filepath, String analyzerType, String sourceFileLocation, 
			String outputFileType, String outputFilePath) throws IOException {
		SourceCodeAnalyzerFactory factoryCodeAnalyzer = new SourceCodeAnalyzerFactory();
		MetricsFileExporterFactory exporter = new MetricsFileExporterFactory();
		List<SourceCodeAnalyzer> objects = factoryCodeAnalyzer.createSourceCodeAnalyzerObjs(sourceFileLocation);
		
		int loc = objects.get(0).calculateMetric(filepath, analyzerType);
		int nom = objects.get(1).calculateMetric(filepath, analyzerType);
		int noc = objects.get(2).calculateMetric(filepath, analyzerType);
		
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc", loc);
		metrics.put("nom", nom);
		metrics.put("noc", noc);
		
		exporter.writeFile(outputFileType, metrics, outputFilePath);
	}

}