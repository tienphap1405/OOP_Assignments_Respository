package shapes;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class Pyramid extends Shape
{
    private double side;

    /**
     *
     * @param height
     * @param side
     */
    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }

    /**
     *
     * @return
     */
    @Override
    public double calcVolume() {
        return (side * side * height) / 3;
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
