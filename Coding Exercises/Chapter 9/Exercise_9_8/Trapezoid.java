/**
 * Quadrilateral with only two sides parallel
 */
public class Trapezoid extends Quadrilateral{
    /**
     * Constructor
     * 
     * <p> Initializes each points of the Trapezoid
     *
     * @param x1                  double
     *                            the x coordinate of point 1 (A)
     *
     * @param y1                  double
     *                            the y coordinate of point 1
     *
     * @param x2                  double
     *                            the x coordinate of point 2 (B)
     *
     * @param y2                  double
     *                            the y coordinate of point 2
     *
     * @param x3                  double
     *                            the x coordinate of point 3 (C)
     *
     * @param y3                  double
     *                            the y coordinate of point 3
     *                           
     * @param x4                  double
     *                            the x coordinate of point 4 (D)
     *
     * @param y4                  double
     *                            the y coordinate of point 4
     */
     public Trapezoid (double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
         super(x1, y1, x2, y2, x3, y3, x4, y4);
     }
}