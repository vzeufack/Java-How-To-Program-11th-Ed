//Slip.java
//A slip contains the salesperson number, the product number and the total dollar value of that product sold that day

public class Slip{
   //instance variables
   private int salespersonNumber;
   private int productNumber;
   private double totalValue;
   
   //constructor
   public Slip (int initialSalespersonNumber, int initialProductNumber, double initialTotalValue){
      setSalespersonNumber(initialSalespersonNumber);
	  setProductNumber(initialProductNumber);
	  setTotalValue(initialTotalValue);
   }
   
   //salesperson accessor
   public int getSalespersonNumber(){
      return salespersonNumber;
   }
   
   //salesperson mutator
   public void setSalespersonNumber( int newSalespersonNumber){
      if (newSalespersonNumber >= 1 && newSalespersonNumber <= 4)
         salespersonNumber = newSalespersonNumber;
	  else{
	     System.out.println("Invalid salesperson number! Value set to 0");
	  }
   }
   
   //productNumber accessor
   public int getProductNumber(){
      return productNumber;
   }
   
   //productNumber mutator
   public void setProductNumber( int newProductNumber){
      if (newProductNumber >= 1 && newProductNumber <= 5)
         productNumber = newProductNumber;
	  else{
	     System.out.println("Invalid product number! Value set to 0");
	  }
   }
   
   //totalValue accessor
   public double getTotalValue(){
      return totalValue;
   }
   
   //totalValue mutator
   public void setTotalValue( double newTotalValue){
      if (newTotalValue > 0.0)
         totalValue = newTotalValue;
	  else{
	     System.out.println("Total value sold must be strictly positive! Value set to $0.0");
	  }
   }
   
   //toString method
   public String toString(){
      String result = String.format("Salespeople ID: %d%nProduct ID: %d%n Total value sold: $%f%n", 
	                    salespersonNumber, productNumber, totalValue);
      return result;
   }
   
   //equals method
   public boolean isEqual (Slip slip){
      if (salespersonNumber == slip.getSalespersonNumber() && productNumber == slip.getProductNumber()
	      && totalValue == slip.getTotalValue())
	     return true;
	  else
	     return false;
   }
}