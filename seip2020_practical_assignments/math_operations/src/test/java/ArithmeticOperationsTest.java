package math;

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/**
* The ArithmeticOperationsTest class provides all the necessary 
* unit tests and test cases for ArithmeticOperations class 
*
* @author gianniskokkosis
*/
public class ArithmeticOperationsTest{

    ArithmeticOperations test = new ArithmeticOperations();

    @Test
    public void simpleDivisionOfTwoDoubleNumbers(){
        Assert.assertEquals(2.0, test.divide(10.0, 5.0), 0.1);
    }

    @Test
    public void divisionWithOneNegativesNumbers(){
        Assert.assertEquals(-2.0, test.divide(-20.0, 10.0), -0.1);
    }

    @Test
    public void divisionWithTwoNegativesNumbers(){
        Assert.assertEquals(4.0, test.divide(-20.0, -5.0), 0.1);
    }

    @Test(expected = ArithmeticException.class)
    public void divisonWithZero(){
        test.divide(20.0, 0.0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void multiplyWithTwoNegativesNumbers(){
        thrown.expect(IllegalArgumentException.class);
        test.multiply(-2, -2);
    }

    @Test
    public void multiplyWithBigIntegersNumbers(){
        thrown.expect(IllegalArgumentException.class);
        test.multiply(Integer.MAX_VALUE, 2);
    }

    @Test 
    public void multiplyWithTwoIntegeresNumbers(){
        Assert.assertEquals(100, test.multiply(10, 10));
    }
}