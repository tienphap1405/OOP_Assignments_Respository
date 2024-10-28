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
     * @param height
     * @param side
     */
    public SquarePrism(double height, double side) {
        super(height);
        this.side = side;
    }

    /**
     *
     * @return
     */
    @Override
    public double calcVolume() {
        return side * side * height;
    }

    /**
     *
     * @return
     */
    @Override
    public double calcBaseArea() {
        return side * side;
    }
    
}
