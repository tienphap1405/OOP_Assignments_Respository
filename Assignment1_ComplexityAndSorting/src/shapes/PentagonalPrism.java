package shapes;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class PentagonalPrism extends Shape
{
    private double side;

    /**
     *
     * @param height height
     * @param side side length
     */
    public PentagonalPrism(double height, double side) {
        super(height);
        this.side = side;
    }

    /**
     *
     * @return area of PentagonalPrism
     */
    @Override
    public double calcBaseArea() {
        double area = (5 * side * side * Math.tan((3 * Math.PI) /10)) / 4;
        return area;
    }
    
    /**
     *
     * @return volume of PentagonalPrism
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }
    
}
