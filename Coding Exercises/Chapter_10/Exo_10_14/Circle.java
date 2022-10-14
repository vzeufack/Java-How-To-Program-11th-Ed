public class Circle extends TwoDimensionalShape{
   private double radius;
   
   public Circle(double radius){
      if(radius < 0.0)
         throw new IllegalArgumentException("Please provide a positive radius!");
      this.radius = radius;
   }
   
   public double getRadius(){
      return radius;
   }
   
   public void setRadius(double radius){
      if(radius < 0.0)
         throw new IllegalArgumentException("Please provide a positive radius!");
      this.radius = radius;
   }
   
   @Override
   public double getArea(){
      return Math.PI * Math.pow(radius, 2);
   }
   
   @Override
   public String toString(){
      return String.format("Circle of radius %f", radius);
   }
}