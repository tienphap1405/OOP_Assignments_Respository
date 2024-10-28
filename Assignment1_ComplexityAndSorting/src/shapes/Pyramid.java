package shapes;

public class Pyramid extends Shape
{
    private double side;

    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcVolume() {
        return (side * side * height) / 3;
    }

    @Override
    public double calcBaseArea() {
        return side * side;
    }
    
}
