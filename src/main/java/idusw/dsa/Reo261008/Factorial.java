package idusw.dsa.Reo261008;

public class Factorial {

    public static long factorialRec(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorialRec(n - 1);
        }
    }

    public static long factorial(int n) {
        long factorial = 1;
        for (int i = n; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
