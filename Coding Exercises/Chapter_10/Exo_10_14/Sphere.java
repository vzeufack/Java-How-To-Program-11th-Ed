public class Sphere extends ThreeDimensionalShape{
   private double radius;
   
   public Sphere(double radius){
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
      return 4 * Math.PI * Math.pow(radius, 2);
   }
   
   @Override
   public double getVolume(){
      return (4 * Math.PI * Math.pow(radius, 3))/3;
   }
   
   @Override
   public String toString(){
      return String.format("Sphere of radius %f", radius);
   }
}