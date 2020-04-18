package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;

@RunWith(Parameterized.class)
public class MyMathClassParameterizedTest{

    MyMath mym = new MyMath();

    private int number;
    private int result;

    public MyMathClassParameterizedTest(int number, int result) {
        this.number = number;
        this.result = result;
    }

    @Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{{0, 1}, {1, 1}, {2, 2}, {12, 479001600}};

        return Arrays.asList(data);
    }

    @Test
    public void parameterizedTestMethod(){
        Assert.assertEquals(result, mym.factorial(number));
    }
}