package Exam.Exercise6.Flowers;

public abstract class Flower {

    protected String name;
    protected String color;
    protected int price;
    protected int time;

    public Flower(String name, String color, int price, int time) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public float getPrice() {
        return price;
    }

    public int getTime() {
        return time;
    }
}

