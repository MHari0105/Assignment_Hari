import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

interface CalculatorOperations {
    void add(BigInteger n1, BigInteger n2);
    void subtract(BigInteger n1, BigInteger n2);
    void multiply(BigInteger n1, BigInteger n2);
    void divide(BigInteger n1, BigInteger n2);
    void clear();
}

class CalcApp implements CalculatorOperations {
    private BigInteger result = BigInteger.ZERO;

    @Override
    public void add(BigInteger num1, BigInteger num2) {
        result = num1.add(num2);
        System.out.println("Addition result : " + result);
    }

    @Override
    public void subtract(BigInteger num1, BigInteger num2) {
        result = num1.subtract(num2);
        System.out.println("Subtracted result : " + result);
    }

    @Override
    public void multiply(BigInteger num1, BigInteger num2) {
        result = num1.multiply(num2);
        System.out.println("Multiplied result : " + result);
    }

    @Override
    public void divide(BigInteger num1, BigInteger num2) {
        if (num2.equals(BigInteger.ZERO))
            System.out.println("Can't divide by ZERO");
        else {
            result = num1.divide(num2);
            System.out.println("Addition result : " + result);
        }
    }

    @Override
    public void clear() {
        result = BigInteger.ZERO;
        System.out.println();
    }
}
public class CalculatorMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CalculatorOperations calc = new CalcApp();

        boolean calculate = true;

        while (calculate) {
            BigInteger num1 = BigInteger.ZERO;
            System.out.println("Enter num1 : ");
            try {
                num1 = sc.nextBigInteger();
            }
            catch (InputMismatchException caught) {
                System.out.println("Enter valid integer");
            }

            BigInteger num2 = BigInteger.ZERO;
            System.out.println("Enter num2 : ");
            try {
                num2 = sc.nextBigInteger();
            }
            catch (InputMismatchException caught) {
                System.out.println("Enter valid integer");
                break;
            }

            System.out.println("Choose operation");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Clear");
            System.out.println("6. Exit");

            int choose = sc.nextInt();

            switch (choose) {
                case 1 :
                    calc.add(num1, num2);
                    break;
                case 2 :
                    calc.subtract(num1,  num2);
                    break;
                case 3 :
                    calc.multiply(num1, num2);
                    break;
                case 4 :
                    calc.divide(num1, num2);
                    break;
                case 5 :
                    calc.clear();
                    break;
                case 6 :
                    calculate = false;
                    break;
                default :
                    System.out.println("Enter valid choice");
            }
        }

        System.out.println("Operation completed");
    }
}
