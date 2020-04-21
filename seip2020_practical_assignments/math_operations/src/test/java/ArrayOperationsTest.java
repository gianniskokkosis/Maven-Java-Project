package math;

import io.FileIO;
import org.junit.Test;
import org.junit.Assert;
import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

    public static String resourcesPath = "src/test/resources/";

    @Test
    public void findPrimesInFileMocking(){

        ArrayOperations arrop = new ArrayOperations();

        MyMath mm = mock(MyMath.class);
        FileIO fio = mock(FileIO.class);
        String valid = resourcesPath.concat("test_mock.txt");

        int[] excpectedValues = new int[] {
            3, 4, 5, 6, 7, 8, 9, 10, 100, 200, 150};

        when(fio.readFile(valid)).thenReturn(excpectedValues);

        when(mm.isPrime(3)).thenReturn(true);
        when(mm.isPrime(4)).thenReturn(false);
        when(mm.isPrime(5)).thenReturn(true);
        when(mm.isPrime(6)).thenReturn(false);
        when(mm.isPrime(7)).thenReturn(true);
        when(mm.isPrime(8)).thenReturn(false);
        when(mm.isPrime(9)).thenReturn(false);
        when(mm.isPrime(10)).thenReturn(false);
        when(mm.isPrime(100)).thenReturn(false);
        when(mm.isPrime(200)).thenReturn(false);
        when(mm.isPrime(150)).thenReturn(false);

        Assert.assertArrayEquals(new int[]{3, 5, 7},
            arrop.findPrimesInFile(fio, valid, mm));
    }
}