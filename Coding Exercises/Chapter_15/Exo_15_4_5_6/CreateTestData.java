import java.util.Scanner;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.util.ArrayList;

public class CreateTestData{
   public static void main(String[] args){
      
      ArrayList<Account> accounts = new ArrayList<>();
      accounts.add(new Account(100, "Alan", "Jones", 348.17));
      accounts.add(new Account(300, "Mary", "Smith", 27.19));
      accounts.add(new Account(500, "Sam", "Sharp", 0.00));
      accounts.add(new Account(700, "Suzy", "Green", -14.22));
      
      try (Formatter output = new Formatter("oldmast.txt")) {
         for(Account acct: accounts){
            output.format("%d %s %s %.2f%n", acct.getAccountNumber(),  
               acct.getFirstName(), acct.getLastName(), acct.getBalance());
         }
      }
      catch (SecurityException | FileNotFoundException | 
         FormatterClosedException e) {
         e.printStackTrace();
         System.exit(1);
      }
      
      ArrayList<TransactionRecord> transactions = new ArrayList<>();
      transactions.add(new TransactionRecord(100, 27.14));
      transactions.add(new TransactionRecord(300, 62.11));
      transactions.add(new TransactionRecord(400, 100.56));
      transactions.add(new TransactionRecord(900, 82.17));  
      transactions.add(new TransactionRecord(300, 83.89));
      transactions.add(new TransactionRecord(700, 80.78));
      transactions.add(new TransactionRecord(700, 1.53)); 

      try (Formatter output = new Formatter("trans.txt")) {
         for(TransactionRecord t: transactions){
            output.format("%d %.2f%n", t.getAccountNumber(), t.getAmount());
         }
      }
      catch (SecurityException | FileNotFoundException | 
         FormatterClosedException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}