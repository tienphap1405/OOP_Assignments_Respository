package shapes;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class Cone extends Shape
{
    private double radius;

    /**
     *
     * @param height height
     * @param radius radius
     */
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    /**
     *
     * @return volume of the Cone
     */
    @Override
    public double calcVolume() {
        return (Math.PI * radius * radius * height) / 3;
    }

    /**
     *
     * @return area of the Cone
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius;    
    }
    
}
