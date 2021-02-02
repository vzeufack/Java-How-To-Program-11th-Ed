/**
 * A point in a quadrilateral
 *
 * <p> it has x and y coordinates
 */
public class Point{
    private double x; //the x coordinate
    private double y; //the y coordinate
    
    /**
     * Constructor 1
     *
     * <p> allows to create a point by providing x and y coordinates
     *
     * @param x, the x coordinate, a double
     * @param y, the y coordinate, a double
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * x coordinate accessor
     *
     * @return the x coordinate
     */
     public double getX(){
         return x;
     }
     
     /**
     * y coordinate accessor
     *
     * @return the y coordinate
     */
     public double getY(){
         return y;
     }     
}