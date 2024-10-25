package shapes;



public class Cylinder extends Shape
{
    private double radius;

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }
    

    @Override
    public double calcVolume() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calcBaseArea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
