package shapes;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class SquarePrism extends Shape
{
    private double side;

    /**
     *
     * @param height height
     * @param side side length
     */
    public SquarePrism(double height, double side) {
        super(height);
        this.side = side;
    }

    /**
     *
     * @return volume of SquarePrism 
     */
    @Override
    public double calcVolume() {
        return side * side * height;
    }

    /**
     *
     * @return area of SquarePrism
     */
    @Override
    public double calcBaseArea() {
        return side * side;
    }
    
}
