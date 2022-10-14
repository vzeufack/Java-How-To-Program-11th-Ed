public class RectangleTest {
   public static void main (String[] args){
      Rectangle r1 = new Rectangle();
      System.out.printf("R1: L = %f w = %f perimeter = %f area = %f\n", r1.getLength(), r1.getWidth(), r1.perimeter(), r1.area());
      Rectangle r2 = new Rectangle(5, 10);
      System.out.printf("R2: L = %f w = %f perimeter = %f area = %f\n", r2.getLength(), r2.getWidth(), r2.perimeter(), r2.area());
      
      try{
         r2.setLength(40);
      }catch(IllegalArgumentException e){
         System.out.println("---" + e.getMessage());
      }
   
      try{
         r2.setLength(-5);
      }catch(IllegalArgumentException e){
         System.out.println("---" + e.getMessage());
      }
   
      try{
         r2.setLength(3);
      }catch(IllegalArgumentException e){
         System.out.println("---" + e.getMessage());
      }
   
      try{
         r2.setWidth(100);
      }catch(IllegalArgumentException e){
         System.out.println("---" + e.getMessage());
      }
   
      try{
         r2.setWidth(-21);
      }catch(IllegalArgumentException e){
         System.out.println("---" + e.getMessage());
      }
   
      try{
         r2.setWidth(4);
      }catch(IllegalArgumentException e){
      }
   
      System.out.printf("R2 after setting length and width: L = %f w = %f perimeter = %f area = %f\n", r2.getLength(), r2.getWidth(), r2.perimeter(), r2.area());
   
      try{
         Rectangle r3 = new Rectangle(-5, 4);
      }catch(IllegalArgumentException e){}
   
      try{
         Rectangle r4 = new Rectangle(16, 20);
      }catch(IllegalArgumentException e){}
   
      try{
         Rectangle r5 = new Rectangle(-432, 20);
      }catch(IllegalArgumentException e){}
   }
}
