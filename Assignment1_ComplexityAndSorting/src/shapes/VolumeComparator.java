package shapes;

import java.util.Comparator;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 * Class for comparing the volume of shapes objects
 */
public class VolumeComparator implements Comparator<Shape> {

    /**
     *
     * @param s1
     * @param s2
     * @return Descending order of Volume so if the shape 1 larger than shape 2 -> return -1;
     *  return 1 if shape 1 smaller than shape 2
     *  else return 0.
     */
    @Override
    public int compare(Shape s1, Shape s2) {
        double compareVolume = s1.calcVolume() - s2.calcVolume();
        if(compareVolume > 0){
            return -1;
        }
        else if (compareVolume < 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}
