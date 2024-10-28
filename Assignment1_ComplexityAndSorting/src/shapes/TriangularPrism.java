package shapes;

public class TriangularPrism extends Shape
{
    private double side;
    public TriangularPrism(double height, double side) {
        super(height);
        this.side = side;
    }


    @Override
    public double calcBaseArea() {
        double area = (side * side * Math.sqrt(3)) / 4;
        return area;
    }
     
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
