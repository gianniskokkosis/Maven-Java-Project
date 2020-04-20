package math;
import io.FileIO;
import java.util.ArrayList;

public class ArrayOperations {

    FileIO fileio = new FileIO();
    MyMath myMath = new MyMath();

    public ArrayList<Integer> findPrimesInFile(FileIO fileio, String filepath, 
        MyMath myMath){

        int array [] = fileio.readFile(filepath);
        ArrayList<Integer> primeArrayList = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++){
            if (myMath.isPrime(array[i])){
                primeArrayList.add(array[i]);
            }
        }

        return primeArrayList;
    }
    
}