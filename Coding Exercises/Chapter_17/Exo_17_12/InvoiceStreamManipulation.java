import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class InvoiceStreamManipulation{
   public static void main(String[] args){
      List<Invoice> invoices = List.of(
         new Invoice("83", "Electric Sander", 7, 57.98),
         new Invoice("24", "Power saw", 18, 99.99),
         new Invoice("7", "Sledge hammer", 11, 21.5),
         new Invoice("77", "Hammer", 76, 11.99),
         new Invoice("39", "Lawn movwer", 3, 79.5),
         new Invoice("68", "Screwdriver", 106, 6.99),
         new Invoice("56", "Jig saw", 21, 11),
         new Invoice("3", "Wrench", 34, 7.5));
      
      System.out.println("List of invoices sorted by part description");
      invoices.stream()
              .sorted(Comparator.comparing(Invoice::getPartDescription))
              .forEach(System.out::println);
       
       System.out.println("\nList of invoices sorted by price per item");
       invoices.stream()
               .sorted(Comparator.comparing(Invoice::getPricePerItem))
               .forEach(System.out::println);
       
       System.out.println("\nList of invoices in range $200 to $500");
       invoices.stream()
               .filter(i -> i.getInvoiceAmount() >= 200 && i.getInvoiceAmount() <= 500)
               .forEach(System.out::println);
       
       System.out.println("\nAny invoice in which partDescription contains the word \"saw\"");
       System.out.println(
          invoices.stream()
                  .filter(i -> i.getPartDescription().contains("saw"))
                  .findAny()
                  .get());
   }
}