package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Parameterized;
import org.junit.runner.Parameterized.Parameter;
import org.junit.runner.Parameterized.Parameters;

import org.junit.Assert;

@RunWith(Parameterized.class)
public class MyMathClassParameterizedTest{

    MyMath mym = new MyMath();

    @Parameter (value = 0)
    public int number = 0;

    @Parameter (value = 1)
    public int result;

    @Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{{1, 1}, {2, 2}, {12, 479001600}};

        return Arrays.asList(data);
    }
}