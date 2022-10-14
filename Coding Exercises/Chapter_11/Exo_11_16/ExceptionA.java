//superclass ExceptionA
public class ExceptionA extends Exception{
   public ExceptionA(){}
   
   public ExceptionA(String errorMessage){
      super(errorMessage);
   }
   
   public ExceptionA(String errorMessage, Throwable throwable){
      super(errorMessage, throwable);
   }
   
   public ExceptionA(Throwable throwable){
      super(throwable);
   }
}