package shapes;

public class PentagonalPrism extends Shape
{
    private double side;

    public PentagonalPrism(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override
    public double calcBaseArea() {
        double area = (5 * side * side * Math.tan((3 * Math.PI) /10)) / 4;
        return area;
    }
    
    @Override
    public double calcVolume() {
        return calcBaseArea() * getHeight();
    }
    
}
