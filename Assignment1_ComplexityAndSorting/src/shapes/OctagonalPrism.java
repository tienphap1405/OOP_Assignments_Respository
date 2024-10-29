package shapes;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class OctagonalPrism extends Shape
{
 private double side;

    /**
     *
     * @param height
     * @param side
     */
    public OctagonalPrism(double height, double side) {
        super(height);
        this.side = side;
    }
    
    /**
     *
     * @return area of the OctagonalPrism
     */
    @Override
    public double calcBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * side * side;
    }
    
    /**
     *
     * @return volume of the OctagonalPrism
     */
    @Override
    public double calcVolume() {
        return calcBaseArea() * height;
    }

}
