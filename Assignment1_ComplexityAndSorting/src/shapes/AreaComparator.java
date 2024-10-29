package shapes;

import java.util.Comparator;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class AreaComparator implements Comparator<Shape>{

    /**
     *
     * @param s1
     * @param s2
     * @return 
     *  Descending order of Area so if the shape 1 larger than shape 2 -> return -1;
     *  return 1 if shape 1 smaller than shape 2
     *  else return 0. 
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        double compareArea = s1.calcBaseArea() - s2.calcBaseArea();
        if (compareArea > 0){
            return -1;
        }
        else if (compareArea < 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}
