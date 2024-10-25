package shapes;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape>{

    @Override
    public int compare(Shape s1, Shape s2) {
        double compareArea = s1.calcBaseArea() - s2.calcBaseArea();
        if (compareArea > 0){
            return 1;
        }
        else if (compareArea < 0){
            return -1;
        }
        else{
            return 0;
        }
    }
    
}
