package shapes;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class TriangularPrism extends Shape
{
    private double side;

    /**
     *
     * @param height
     * @param side
     */
    public TriangularPrism(double height, double side) {
        super(height);
        this.side = side;
    }

    /**
     *
     * @return area of TriangularPrism
     */
    @Override
    public double calcBaseArea() {
        double area = (side * side * Math.sqrt(3)) / 4;
        return area;
    }
     
    /**
     *
     * @return volume of TriangularPrism
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
}
