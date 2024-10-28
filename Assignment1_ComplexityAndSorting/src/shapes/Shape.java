package shapes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public abstract class Shape implements Comparable<Shape>{

    /**
     *
     */
    protected double height;
    
    /**
     *
     * @param height
     */
    public Shape(double height){
        this.height = height;
    }

    /**
     *
     * @return
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
     * @return
     */
    public abstract double calcVolume();
    
    /**
     *
     * @return
     */
    public abstract double calcBaseArea();

    /**
     *
     * @param otherShape
     * @return
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
