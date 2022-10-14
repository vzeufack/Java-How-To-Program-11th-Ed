public class Cube extends ThreeDimensionalShape{
   private double side;
   
   public Cube(double side){
      if(side < 0.0)
         throw new IllegalArgumentException("Please provide a positive side!");
      this.side = side;
   }
   
   public double getSide(){
      return side;
   }
   
   public void setSide(double side){
      if(side < 0.0)
         throw new IllegalArgumentException("Please provide a positive side!");
      this.side = side;
   }
   
   @Override
   public double getArea(){
      return 6 * Math.pow(side, 2);
   }
   
   @Override
   public double getVolume(){
      return Math.pow(side, 3);
   }
   
   @Override
   public String toString(){
      return String.format("Cube of side %f", side);
   }
}