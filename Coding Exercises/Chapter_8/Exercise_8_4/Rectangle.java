public class Rectangle {
   private float length;
   private float width;

   public Rectangle(){
      this.length = 1.0f;
      this.width = 1.0f;
   }

   public Rectangle(float length, float width){
      if(length < 0 || length > 20 || width < 0 || width > 20)
         throw new IllegalArgumentException("Length and width must be greater than 0.0 and smaller than 20.0");
      
      this.length = length;
      this.width = width;
   }

   public float perimeter(){
      return (length + width) * 2;
   }

   public float area(){
      return length * width;
   }

   public float getLength(){
      return length;
   }

   public void setLength(float length){
      if(length < 0 || length > 20)
         throw new IllegalArgumentException("Length must be greater than 0.0 and smaller than 20.0");
      this.length = length;
   }

   public float getWidth(){
      return width;
   }

   public void setWidth(float width){
      if(width < 0 || width > 20)
         throw new IllegalArgumentException("Width must be greater than 0.0 and smaller than 20.0");
      this.width = width;
   }
}
