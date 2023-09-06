interface OuterInterface {
    void outerPrint();
    interface InnerInterface {
        void innerPrint();
    }
}

class Outer implements OuterInterface {
    public void outerPrint() {
        System.out.println("Prints Outer Interface method");
    }
}

class Inner implements OuterInterface.InnerInterface {
    public void innerPrint() {
        System.out.println("Prints Inner Interface method");
    }
}
public class InterfaceMain {
    public static void main(String[] args) {

        Outer out = new Outer();
        out.outerPrint();

        Inner in = new Inner();
        in.innerPrint();
    }
}