package shapes;

import java.util.Comparator;

/**
 *
 * @author Tien Phap (Evan) Nguyen, Simon Luna Patiarroy
 */
public class VolumeComparator implements Comparator<Shape> {

    /**
     *
     * @param s1
     * @param s2
     * @return
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
