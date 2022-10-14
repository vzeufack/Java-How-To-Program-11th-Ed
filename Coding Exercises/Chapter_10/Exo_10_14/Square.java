public class Square extends TwoDimensionalShape{
   private double side;
   
   public Square(double side){
      if(side < 0.0)
         throw new IllegalArgumentException("Please provide a positive side length!");
      this.side = side;
   }
   
   public double getSide(){
      return side;
   }
   
   public void setSide(double side){
      if(side < 0.0)
         throw new IllegalArgumentException("Please provide a positive side length!");
      this.side = side;
   }
   
   @Override
   public double getArea(){
      return Math.pow(side, 2);
   }
   
   @Override
   public String toString(){
      return String.format("Square of side %f", side);
   }
}