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
    
}