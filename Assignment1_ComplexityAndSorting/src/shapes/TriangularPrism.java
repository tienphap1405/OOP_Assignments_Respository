package shapes;

public class TriangularPrism extends Shape
{
    private double side;
    public TriangularPrism(double height, double side) {
        super(height);
        this.side = side;
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
