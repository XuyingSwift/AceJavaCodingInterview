package main.DataStructure.OOP.Inheritance;

public class Shape {

    public String color;
    public boolean isFilled;

    public Shape() {
        this.color = "Red";
        this.isFilled = false;
    }

    public Shape(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
    }

    public String getColor(){
        return this.color;
    }

    public boolean getIsFilled() {
        return this.isFilled;
    }

    public void setColor(String c) {
        this.color = c;
    }

    public void setFilled(boolean f) {
        this.isFilled = f;
    }

    public int getArea() {
        return -1;
    }
}
