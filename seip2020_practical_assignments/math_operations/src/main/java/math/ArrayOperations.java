package math;
import io.FileIO;
import java.util.ArrayList;

public class ArrayOperations {

    FileIO fileio = new FileIO();
    MyMath myMath = new MyMath();

    public int[] findPrimesInFile(FileIO fileio, String filepath, 
        MyMath myMath){

        int array [] = fileio.readFile(filepath);
        ArrayList<Integer> primeArrayList = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++){
            if (myMath.isPrime(array[i])){
                primeArrayList.add(array[i]);
            }
        }

        int primeArray[] = new array[primeArrayList.size()];

        for (int j = 0; j < primeArrayList.size(); j++){
            primeArray[j] = primeArrayList.get(j);
        }

        return primeArray;
    }
    
}