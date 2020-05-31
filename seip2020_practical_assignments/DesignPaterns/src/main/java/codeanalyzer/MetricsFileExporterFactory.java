package codeanalyzer;

public class MetricsFileExporterFactory {
	
	public MetricsFileExporter getExporter(String outputType) {
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