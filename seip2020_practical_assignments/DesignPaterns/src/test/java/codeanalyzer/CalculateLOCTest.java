package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import codeanalyzer.*;

import static org.junit.Assert.*;

public class CalculateLOCTest{
    private static List<String> testSourceCode;
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	SourceCodeAnalyzer scal = new CalculateLOC(new LocalFileReader());

    @Test
    public void testCalculateRegexLocalLOC() throws IOException{
        assertEquals(21, scal.clalcuteMetric(TEST_CLASS, TYPE_REGEX));
    }
}