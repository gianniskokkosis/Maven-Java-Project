package io;

import org.junit.Test;
import org.junit.Assert;


public class FileIOTest {

    FileIO file = new FileIO();
    public static String resourcesPath = "src/test/resources/";

    @Test
    public void testReadFileValidInput(){

         int[] excpectedValues = new int[] {
            1, 2, 3, 4, 10, 12, 22, 3333, 12,
            98, 100, 99, 39876, 343, 0, 1, 4};

        String validInputFilePath = resources.concat("valid_values.txt");
        Assert.assertArrayEquals(excpectedValues, file.readFile(validInputFilePath));
    }
    
}