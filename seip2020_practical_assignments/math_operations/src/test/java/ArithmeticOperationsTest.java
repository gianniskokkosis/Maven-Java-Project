package math;

import org.junit.Test;
import org.junit.Assert;

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

    @Test(expected = ArithmeticException.class)
    public void divisonWithZero(){
        test.divide(20.0, 0.0);
    }

}