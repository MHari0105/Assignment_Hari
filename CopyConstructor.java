

// COPY CONSTRUCTOR

class Copy {
    int num1;
    int num2;
    
    Copy(int n1, int n2) {
        this.num1 = n1;
        this.num2 = n2;
    }
    
    Copy(Copy copy) {
        num1 = copy.num1;
        num2 = copy.num2;
    }
    
    void display() {
        System.out.println(num1);
        System.out.println(num2);
    }
}
public class CopyConstructor {
    public static void main(String[] args) {
        
        Copy c1 = new Copy(10, 15);
        Copy c2 = new Copy(c1);
        c1.display();
        c2.num1 = 7;
        c2.num2 = 8;
        c2.display();
    }
}

