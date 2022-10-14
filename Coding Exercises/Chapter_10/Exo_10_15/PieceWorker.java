public class PieceWorker extends Employee {
   private double wage; // wage per piece
   private int pieces; // number of pieces produced
   
   // constructor
   public PieceWorker(String firstName, String lastName,
      String socialSecurityNumber, Date birthDate, double wage, int pieces) {
      super(firstName, lastName, socialSecurityNumber, birthDate);

      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Wage per piece must be >= 0.0");
      }
      
      if (pieces < 0) { // validate pieces
         throw new IllegalArgumentException("Number of pieces must be >= 0");
      }
      
      this.wage = wage;
      this.pieces = pieces;
   } 

   // set wage
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Wage per piece must be >= 0.0");
      }

      this.wage = wage;
   } 

   // return wage
   public double getWage() {return wage;}

   // set pieces produced
   public void setPieces(int pieces) {
      if (pieces < 0) { // validate pieces
         throw new IllegalArgumentException("Number of pieces must be >= 0");
      }

      this.pieces = pieces;
   } 

   // return pieces produced
   public double getPieces() {return pieces;}

   // calculate earnings; override abstract method earnings in Employee
   @Override                                                           
   public double earnings() {                                          
      return getWage() * getPieces();                                                              
   }                                                                   

   // return String representation of HourlyEmployee object              
   @Override                                                             
   public String toString() {                                            
      return String.format("Pieceworker employee: %s%n%s: $%,.2f; %s: %,.2f", 
         super.toString(), "Wage per piece", getWage(),                     
         "Pieces produced", getPieces());                                    
   }                                                                     
} 




/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
