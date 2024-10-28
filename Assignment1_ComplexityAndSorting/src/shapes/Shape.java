package shapes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tienp
 */
public abstract class Shape implements Comparable<Shape>{
    protected double height;
    
    public Shape(double height){
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public abstract double calcVolume();
    
    public abstract double calcBaseArea();

    @Override
    public int compareTo(Shape otherShape) {
        double compareHeight = this.height - otherShape.height;
        if(compareHeight > 0){
            return 1;
        }
        else if (compareHeight < 0){
            return -1;
        }
        else{
            return 0;
        }
    }
}
