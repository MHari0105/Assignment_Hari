
import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        try {
            int element = Integer.parseInt(args[0]);
            fibo(new BigInteger("-1"), BigInteger.ONE, element);
        }
        catch (ArrayIndexOutOfBoundsException arr) {
            System.out.println("Enter a value");
        }
        
    }
    
    static void fibo(BigInteger b1, BigInteger b2, int n) {
        
        if (n >= 0) {
            BigInteger temp = BigInteger.ZERO;
            temp = b1.add(b2);
            System.out.println(b1);
            b1 = b2;
            b2 = temp;
            fibo(b1, b2, --n);
        }
       
    }
}        