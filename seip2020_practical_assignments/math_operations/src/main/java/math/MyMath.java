package math;

public class MyMath{
    
    public int factorial(int n){
        int f = 1;

        if (n < 0 || n > 12){
            throw new IllegalArgumentException("Wrong! Number must be greater than 0 and smaller than 12. ");
        } else {
            for (int i = 1; i <= n; i++){
                f *= i;
            }
        }

        return f;
    }
}