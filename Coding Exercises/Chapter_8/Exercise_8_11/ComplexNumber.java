public class ComplexNumber{
   private float realPart;
   private float imaginaryPart;
   
   public ComplexNumber(){};
   
   public ComplexNumber(float realPart, float imaginaryPart){
      this.realPart = realPart;
      this.imaginaryPart = imaginaryPart;
   }
   
   public float getRealPart(){
      return realPart;
   }
   
   public float getImaginaryPart(){
      return imaginaryPart;
   }
   
   public void setRealPart(float realPart){
      this.realPart = realPart;
   }
   
   public void setImaginaryPart(float imaginaryPart){
      this.imaginaryPart = imaginaryPart;
   }
   
   public String toString(){
      return String.format("(%f, %f)", realPart, imaginaryPart);
   }
   
   //adds 2 complex numbers
   public static ComplexNumber add(ComplexNumber n1, ComplexNumber n2){
      ComplexNumber result = new ComplexNumber();
      result.setRealPart(n1.getRealPart() + n2.getRealPart());
      result.setImaginaryPart(n1.getImaginaryPart() + n2.getImaginaryPart());
      return result;
   }
   
   //subtracts 2 complex numbers
   public static ComplexNumber subtract(ComplexNumber n1, ComplexNumber n2){
      ComplexNumber result = new ComplexNumber();
      result.setRealPart(n2.getRealPart() - n1.getRealPart());
      result.setImaginaryPart(n2.getImaginaryPart() - n1.getImaginaryPart());
      return result;
   }
}