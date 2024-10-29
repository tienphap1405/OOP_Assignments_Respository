package shapes;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class Cylinder extends Shape
{
    private double radius;

    /**
     *
     * @param height height
     * @param radius radius
     */
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    
    /**
     *
     * @return volume of Cylinder
     */
    @Override
    public double calcVolume() {
        return Math.PI * radius * radius * height;
    }

    /**
     *
     * @return area of Cylinder
     */
    @Override
    public double calcBaseArea() {
        return Math.PI * radius * radius;
    }

}
