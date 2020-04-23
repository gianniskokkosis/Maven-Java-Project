package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

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

    @Test
    public void isNotPrimeNumber(){
        Assert.assertFalse(myMath.isPrime(9));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public void inputSmallerThanTwoInIsPrime(){
        thrown.expect(IllegalAccessException.class);
        myMath.isPrime(0);
    }
}