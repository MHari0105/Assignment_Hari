// CONSTRUCTOR OVERLOADING
class Same {
    int x;
    Same(){
        System.out.println(" X : " + x);
    }
    
    Same(int y){
        this();
        this.x = y;
        System.out.println(" X : " + x);
    }
}
public class ConstructorOverloading {
    public static void main(String[] args){
	    new Same();
	    System.out.println();
        new Same(4);
    }
}