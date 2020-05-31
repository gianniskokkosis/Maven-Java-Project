package codeanalyzer;

import java.util.Map;

public class MetricsFileExporterFactory {
	
	public MetricsFileExporter writeFile(String outputType, Map<String, Integer> metrics, String filepath) {
		MetricsFileExporter exporter;
		
		if (outputType.equals("csv")) {
			exporter = new MetricsExporterCSV();
		}else if (outputType.equals("json")) {
			exporter = new MetricsExporterJSON();
		}else {
			throw new IllegalArgumentException("Unknown type : " + outputType);
		}
		
		return exporter;
	}
}