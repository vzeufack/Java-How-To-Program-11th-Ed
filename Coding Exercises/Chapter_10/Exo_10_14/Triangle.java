public class Triangle extends TwoDimensionalShape{
   private double base;
   private double height;
   
   public Triangle(double base, double height){
      if(base < 0.0)
         throw new IllegalArgumentException("Please provide a positive base!");
      
      if(height < 0.0)
         throw new IllegalArgumentException("Please provide a positive height!");

      this.base = base;
      this.height = height;
   }
   
   public double getBase(){
      return base;
   }
   
   public double getHeight(){
      return height;
   }
   
   public void setBase(double base){
      if(base < 0.0)
         throw new IllegalArgumentException("Please provide a positive base!");
      this.base = base;
   }
   
   public void setHeight(double height){
      if(height < 0.0)
         throw new IllegalArgumentException("Please provide a positive height!");
      this.height = height;
   }
   
   @Override
   public double getArea(){
      return (base * height)/2;
   }
   
   @Override
   public String toString(){
      return String.format("Triangle of base %f & height %f", base, height);
   }
}
