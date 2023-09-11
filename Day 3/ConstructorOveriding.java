
//  CONSTRUCTOR OVERRIDING
class SuperMain {
    SuperMain(int value) {
        System.out.println(value);
    }
}
class SubMain extends SuperMain {
    SubMain(int value) {
        super(value);
    }
}
public class ConstructorOveriding {
    public static void main(String[] args) {
        
        new SubMain(10);
        
    }
}