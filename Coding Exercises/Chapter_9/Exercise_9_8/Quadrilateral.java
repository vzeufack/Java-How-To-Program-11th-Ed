/**
 * Represents a quadrilateral
 * A four sided figure
 */
public class Quadrilateral{
    private Point p1; // point 1
    private Point p2; // point 2
    private Point p3; // point 3
    private Point p4; // point 4
    
    /**
     * Constructor
     * 
     * <p> Initializes each points of the Quadrilateral
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
    public Quadrilateral (double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        //Making sure the 4 points are distinct by checking if AB = 0 || AD = 0 || CD = 0 || BC = 0
        if (getDistance(x1, y1, x2, y2) == 0 || getDistance(x1, y1, x4, y4) == 0 || getDistance(x3, y3, x4, y4) == 0 || getDistance(x2, y2, x3, y3) == 0)
            throw new IllegalArgumentException("There are two points which are the same");
        
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
        this.p3 = new Point(x3, y3);
        this.p4 = new Point(x4, y4);
    }
    
    /**
     * Point 1 accessor
     * 
     * @return point 1
     */
    public Point getP1(){
        return p1;
    }
    
    /**
     * Point 2 accessor
     * 
     * @return point 2
     */
    public Point getP2(){
        return p2;
    }
    
    /**
     * Point 3 accessor
     * 
     * @return point 3
     */
    public Point getP3(){
        return p3;
    }
    
    /**
     * Point 4 accessor
     * 
     * @return point 4
     */
    public Point getP4(){
        return p4;
    }
    
    /**
     * computes the area of the Quadrilateral
     *
     * <p> this method should be overridden by children
     *
     * @return the area of the quadrilateral
     */
     public double area(){
         return 0.0;
     }
     
     /**
      * Computes the distance between two points
      * given their coordinates
      *
      * @param x1     double
      *               the x coordintate of Point 1
      *               
      * @param y1     double
      *               the y coordinate of Point 2
      *
      * @param x2     double
      *               the x coordinate of Point 2
      *
      * @param y2     double
      *               the y coordinate of Point 2
      *
      * @return the distance
      */
     public double getDistance(double x1, double y1, double x2, double y2){
         return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
     }
}