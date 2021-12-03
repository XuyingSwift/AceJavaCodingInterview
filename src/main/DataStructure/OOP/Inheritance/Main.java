package main.DataStructure.OOP.Inheritance;
class B
{
    int i;
}

class A
{
    int i;
}
public class Main {
    public static void main(String[] args) {
        Shape a = new Shape();
        Circle c = new Circle("Green", false, 3);
        // if in sub class, it has a intance vriable that has the same name, then it can not access to the supper class
        System.out.println("Color " + c.color);
        System.out.println("isfilled " + c.isFilled);
        System.out.println("radius " + c.r);
        System.out.println(c.getArea());
        c.setColor("Yellow");
        c.setFilled(false);
        System.out.println(c.getColor());
        System.out.println(c.getIsFilled());

        a = (Shape) c;
        System.out.println(a.color);
        System.out.println(a.getArea());
        // can not access r anymore
        System.out.println();



        A x = new A();
        B y;

       // y = (B) x;    // Illegal
    }
}
