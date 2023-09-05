
class Shape {
    Shape() {
        System.out.println("Define vertices and edges");
    }
    
    void drawShape() {
        System.out.println("Draw a shape");
    }
}

class Square extends Shape {
    int edges = 4;
    int vertices = 4;
    
    Square() {
        super();
    }
    
    void drawSquare() {
        System.out.println("Square has " + this.edges + " edges and " + this.vertices);
    }
}

 
public class InheritanceExample {
    public static void main(String[] args) {
        
        Square sq = new Square();
        sq.drawShape();
        sq.drawSquare();
    }
}

