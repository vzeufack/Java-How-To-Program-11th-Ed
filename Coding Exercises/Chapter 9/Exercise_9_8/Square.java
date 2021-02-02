/**
 * A rectangle with all sides equal
 */
public class Square extends Rectange{
    /**
     * Computes the area of square
     *
     * <p> the formula is lxl where l is the length of the side
     *
     * @return the area of the square as a double
     */
    @override
    public double area(){
        double x1 = getP1().getX();
        double x2 = getP2().getX();
        double y1 = getP1().getY();
        double y2 = getP2().getY();
        
        double area = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
        
        return area;
    }
}