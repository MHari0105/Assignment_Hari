
class Shape {
    
    int edges, vertices;
    double diameter = 8, radius = diameter/2;
    final static double pi = 3.14;
    
    Shape() {
        System.out.println("Define vertices and edges");
    }
    void drawShape() {
        System.out.println("Draw a shape");
    }
    double area() {
        return 0.0;
    }
}

class Square extends Shape {
    
    Square() {
        super();
    }
    
    void drawSquare(int sqEdges, int sqVertices) {
        edges = sqEdges;
        vertices = sqVertices;
        System.out.println("Square has " + edges + " edges and " + sqVertices);
    }
    
    double area() {
        return Math.pow(edges, 2);
    }
}

class Circle extends Shape {
    
    void drawCircle(int cirEdges, int cirVertices) {
        edges = cirEdges;
        vertices = cirVertices;
        System.out.println("Circle has " + edges + " edges and " + vertices);
    }
    
    double area() {
        return pi * Math.pow(radius, 2);
    }
}

public class Main {
    public static void main(String[] args) {
        
        Square sq = new Square();
        sq.drawShape();
        sq.drawSquare(4, 4);
        System.out.println(sq.area());
        
        Circle cir = new Circle();
        cir.drawCircle(0, 0);
        System.out.println(cir.area());
    }
}



