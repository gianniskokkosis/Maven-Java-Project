package math;

import org.junit.Test;
import org.junit.Assert;

public class MyMathTest{

    MyMath myMath = new MyMath();

    @Test(expected=IllegalArgumentException.class)
    public void inputSmallerThanZero(){
        myMath.factorial(-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void inputGreaterThanTwelve(){
        myMath.factorial(14);
    }

    @Test
    public void isPrimeNumber(){
        Assert.assertTrue(myMath.isPrime(5));
    }
<<<<<<< HEAD

    @Test
    public void isNotPrimeNumber(){
        Assert.assertFalse(myMath.isPrime(9));
    }
=======
>>>>>>> d0e43cefa0e15652ced1c6fdd744c0fe218b83b7
    
}