package math;
import io.FileIO;
import java.util.ArrayList;

/**
 * The ArrayOperations is a simple class that a very basic  
 * functionality. The purpose of ArrayOperations is to serve 
 * a hands-on practice on Unit Testing with mocking
 * 
 * @author gianniskokkosis
 */

public class ArrayOperations {

    /**
     * FindPrimesInFile iterates in an array of numbers and
     * returns a new array that contains only prime numbers.
     * It uses readFile method of FileIO class to create an array
     * of numbers form a file which is located in a filepath location.
     * It also uses the isPrime method of MyMath to dermine if a number is 
     * prime or not.
     *
     * @param fileio an object of FileIO class
     * @param filepath the file that contains the numbers
     * @param myMath an object of MyMath class
     */
    public int[] findPrimesInFile(FileIO fileio, String filepath, 
        MyMath myMath){

        // Create an array of numbers from a file
        int array [] = fileio.readFile(filepath);
        // Create an ArraList of Integers
        ArrayList<Integer> primeArrayList = new ArrayList<Integer>();

        // Loop through the contents of the array
        for (int i = 0; i < array.length; i++){
            //If the number is prime then add it to the ArrayList
            if (myMath.isPrime(array[i])){
                primeArrayList.add(array[i]);
            }
        }

        // Create a new array with size equal to the size of the ArrayList
        int primeArray[] = new int[primeArrayList.size()];

        // Loop through the ArrayList and assign all its values to the new array
        for (int j = 0; j < primeArrayList.size(); j++){
            primeArray[j] = primeArrayList.get(j);
        }

        // Return the array that contains only prime numbers
        return primeArray;
    }
    
}