package model;

public class Apple {
    private int weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "model.Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}