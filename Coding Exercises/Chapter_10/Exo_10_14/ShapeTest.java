public class ShapeTest{
   public static void main (String[] args){
      Shape[] shapes = new Shape[6];
      shapes[0] = new Circle(4);
      shapes[1] = new Square(3);
      shapes[2] = new Triangle(10, 3);
      shapes[3] = new Cube(5);
      shapes[4] = new Sphere(6);
      shapes[5] = new Tetrahedron(10);
      
      for(Shape shape: shapes){
         System.out.println(shape);
         
         if(shape instanceof TwoDimensionalShape)
            System.out.println("Area: " + shape.getArea());
         
         if(shape instanceof ThreeDimensionalShape){
            ThreeDimensionalShape threeDShape = (ThreeDimensionalShape) shape;
            System.out.println("Area: " + threeDShape.getArea());
            System.out.println("Volume: " + threeDShape.getVolume());
         }
         
         System.out.println();
      }
   }
}