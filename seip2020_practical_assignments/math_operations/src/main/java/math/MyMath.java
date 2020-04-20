package math;


/**
 * The MyMath provides some more advanced mathematic
 * topics related to integers numbers.
 *
 * @author gianniskokkosis
 */
public class MyMath{

    /**
     * Factorial takes an integer number as an argument and calculates
     * the factorial for this given number.
     * 
     * @param n an integer number
     * @exception IllegalArgumentException
     */
    public int factorial(int n){
        // Set factorial result to 1
        int f = 1;

        // If the given number is negative or greater than 12 then throw an IllegalArgumentException
        if (n < 0 || n > 12){
            throw new IllegalArgumentException("Wrong! Number must be greater than 0 and smaller than 12. ");
        } else {
            /*
             * Otherwise calculate the factorial of the given number.
             * Loop from one till the counter i reach the number. 
             * The factorial is the multiplication product of all the previous
             * numbers of n exept 0. For example factorial of 4 is the multiplication
             * product of 1*2*3*4.
             */
            for (int i = 1; i <= n; i++){
                f *= i;
            }
        }

        // Return the factorial of n
        return f;
    }

    /**
     * isPrime determines if a given integer number is prime or not.
     * If its prime returns true otherwise returns false.
     * 
     * @param n an integer number
     * @exception IllegalArgumentException
     */
    public boolean isPrime(int n){
        // Set is prime eqaul to true
        boolean isPrime = true;

        // If n is smaller than 2, throw an IllegalArgumentException
        if (n < 2){
            throw new IllegalArgumentException("Wrong input! Input number must be greater than or equal to 2.");
        } else {

            // Otherwise determine if the number is prime
            for (int i = 2; i <= n/2; i++){

                /*
                 * if the number is divided perfect with a 
                 * smaller number, then it means that the number
                 * can be formed by multiplyin two smaller numbers
                 */ 
                if (n % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        // Return if the number is prime or not
        return isPrime;
    }
}