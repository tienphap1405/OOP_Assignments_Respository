package shapes;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Shape> {

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
