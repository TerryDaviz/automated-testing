import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Triangle {
    private final double aSide;
    private final double bSide;
    private final double cSide;
    Triangle(ArrayList<Double> sides) throws TriangleError {
        validateSides(sides);
        this.aSide = sides.get(0);
        this.bSide = sides.get(1);
        this.cSide = sides.get(2);
    }
   private static void validateSides (ArrayList<Double> sides) throws TriangleError {
       double maxLengthSide = Collections.max(sides);
       if (sides.size() != 3) {
           throw new TriangleError("sides amount must be 3");
       }
       if (sides.stream().anyMatch(x -> x <= 0)){
           throw new TriangleError("side length must be a positive number");
       }
       if (maxLengthSide >= sides.stream().reduce((x,y) -> x+y).get() - maxLengthSide){
            throw new TriangleError("side length must be less than sum of other's sides length");
       }
    }
}
