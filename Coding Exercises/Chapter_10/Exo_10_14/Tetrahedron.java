public class Tetrahedron extends ThreeDimensionalShape{
   private double side;
   
   public Tetrahedron(double side){
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
      return Math.sqrt(3) * Math.pow(side, 2);
   }
   
   @Override
   public double getVolume(){
      return (Math.sqrt(2)/12) * Math.pow(side, 3);
   }
   
   @Override
   public String toString(){
      return String.format("Tetrahedron of side %f", side);
   }
}