package shapes;

public class Cone extends Shape
{
    private double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double calcVolume() {
        return (Math.PI * radius * radius * getHeight()) / 3;
    }

    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius;    
    }
    
}
