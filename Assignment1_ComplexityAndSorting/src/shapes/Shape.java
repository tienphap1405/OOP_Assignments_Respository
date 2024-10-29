package shapes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 * Implement Comparable type Shape to compare Shape's height
 */
public abstract class Shape implements Comparable<Shape>{

    /**
     * Height is initialized as protected for subclass to use the same height
     * since every subclasses have the same height property
     */
    protected double height;
    
    /**
     * 
     * @param height height
     */
    public Shape(double height){
        this.height = height;
    }

    /**
     *
     * @return height of the shape
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     *
     * @return Create abstract method with no body for subclasses to implement
     * and calculate the volume
     */
    public abstract double calcVolume();
    
    /**
     *
     * @return Create abstract method with no body for subclasses to implement
     * and calculate the area
     */
    public abstract double calcBaseArea();

    /**
     *
     * @param otherShape
     * @return Descending -1 if shape 1 larger than shape 2
     *          1 if shape 1 smaller than shape 2
     */
    @Override
    public int compareTo(Shape otherShape) {
        double compareHeight = this.height - otherShape.height;
        if(compareHeight > 0){
            return -1;
        }
        else if (compareHeight < 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
