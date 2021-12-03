package main.DataStructure.OOP.Inheritance;

public class Circle extends Shape {

    public int r;

    public Circle(String c, boolean b, int r) {
        super(c,b);
        this.r = r;
    }

    /*
    * public int getArea() {
        return (int) (Math.PI * r*r);
    }
    *
    * */

}
