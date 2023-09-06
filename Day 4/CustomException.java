
import java.util.Scanner;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
        System.out.println(" Print positive value ");
    }
}

class CustomException {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        try {
            if (input < 0) {
                throw new MyException("Enter a positive value");
            }
            System.out.println("Operation successful with value: " + input);
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}