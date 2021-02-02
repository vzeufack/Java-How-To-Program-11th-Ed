//TotalSales.java by Vannel July 3rd 2018
//Summarizes the total sales per salesperson and product within a company

public class TotalSales{
   //instance variables
   private static final int NUMBER_OF_SALESPEOPLE = 4;
   private static final int NUMBER_OF_PRODUCTS = 5;
   private static double [][] sales = new double [NUMBER_OF_PRODUCTS + 2][NUMBER_OF_SALESPEOPLE + 2];
   
   //main method
   public static void main (String[] args){
      Slip slip11 = new Slip (1,1,1);
	  Slip slip111 = new Slip (1,1,4);
	  Slip slip12 = new Slip (1,2,1);
	  Slip slip13 = new Slip (1,3,1);
	  Slip slip14 = new Slip (1,4,1);
	  Slip slip15 = new Slip (1,5,1);
	  
	  Slip slip21 = new Slip (2,1,2);
	  Slip slip22 = new Slip (2,2,2);
	  Slip slip23 = new Slip (2,3,2);
	  Slip slip24 = new Slip (2,4,2);
	  Slip slip25 = new Slip (2,5,2);
	  
	  Slip slip31 = new Slip (3,1,3);
	  Slip slip32 = new Slip (3,2,3);
	  Slip slip33 = new Slip (3,3,3);
	  Slip slip34 = new Slip (3,4,3);
	  Slip slip35 = new Slip (3,5,3);
	  
	  Slip slip41 = new Slip (4,1,4);
	  Slip slip411 = new Slip (4,1,5);
	  Slip slip42 = new Slip (4,2,4);
	  Slip slip43 = new Slip (4,3,4);
	  Slip slip44 = new Slip (4,4,4);
	  Slip slip45 = new Slip (4,5,4);
	  Slip slip455 = new Slip (4,5,3.2);
	  
	  processSales(slip11,slip111,slip12,slip13,slip14,slip15,slip21,slip22,slip23,
	               slip24,slip25,slip31,slip32,slip33,slip34,slip35,slip41,slip42,
				   slip43,slip44,slip411,slip45,slip455);
	  outputSales();
   }
   
   //process sales
   public static void processSales (Slip... slips){
      boolean found;   
      for (int i = 0; i < slips.length; i++){
	     found = false;
	     for (int j = 1; j < sales.length && !found; j++){
		    for (int k = 1; k < sales[j].length && !found; k++){
		       if (j == slips[i].getProductNumber() &&  k == slips[i].getSalespersonNumber()){
			      sales[j][k] += slips[i].getTotalValue();
				  sales[j][sales[j].length - 1] += slips[i].getTotalValue();
				  sales[sales.length - 1][k] += slips[i].getTotalValue();
				  found = true;
			   }
		    }
		 }		 
	  }	  	    
   } // end method summarizeSales
   
   //output sales
   private static void outputSales(){
      System.out.printf("           ");
      for (int i = 1; i <= 4; i++){
	     System.out.printf("Salesperson%2d  ", i);
      }	  
	  System.out.println("   Total");
	  for (int j = 1; j < sales.length; j++){
	    if (j == sales.length-1){
		   System.out.printf("    Total");
		}
		else{
	       System.out.printf("Product%2d",j);
		}
		   
		for (int k = 1; k < sales[j].length; k++){
		   if (k == sales[j].length - 1){
		      if ( j == sales.length - 1 ){
			     continue;
			  }
			  else{
		         System.out.printf("%10.2f", sales[j][k]);	
              }				 
		   }
		   else{
		      System.out.printf("%10.2f     ", sales[j][k]);
		   }
		}
		System.out.println();
	  }	
   }// end method printSummary
} //end class