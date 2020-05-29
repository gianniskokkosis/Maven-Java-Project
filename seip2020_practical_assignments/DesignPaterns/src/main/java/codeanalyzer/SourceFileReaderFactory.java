package codeanalyzer;

public class SourceFileReaderFactory {

    public SourceFileReader getSourceFileReader(String fileReaderType)
        throws IllegalArgumentExceptions{
        SourceFileReader reader;

        if (fileReaderType.equals("web")){
            reader = new WebFileReader();
        }else if (fileReaderType.equals("local")){
            reader = new LocalFileReader();
        }else{
            throw new IllegalArgumentException(
                "Unknown type " + fileReaderType
            );
        }

        return reader;
    }
}