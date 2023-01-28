import java.util.Scanner;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import javax.xml.bind.JAXB;

public class CreateXMLTestData{
   public static void main(String[] args){
      
      ArrayList<Account> accountsList = new ArrayList<>();
      accountsList.add(new Account(100, "Alan", "Jones", 348.17));
      accountsList.add(new Account(300, "Mary", "Smith", 27.19));
      accountsList.add(new Account(500, "Sam", "Sharp", 0.00));
      accountsList.add(new Account(700, "Suzy", "Green", -14.22));
      
      Accounts accounts = new Accounts();
      
      try (BufferedWriter output = Files.newBufferedWriter(Paths.get("oldmast.xml"))) {
         for(Account acct: accountsList){
            accounts.getAccounts().add(acct);
         }
         JAXB.marshal(accounts, output);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      
      ArrayList<TransactionRecord> transactionRecords = new ArrayList<>();
      transactionRecords.add(new TransactionRecord(100, 27.14));
      transactionRecords.add(new TransactionRecord(300, 62.11));
      transactionRecords.add(new TransactionRecord(400, 100.56));
      transactionRecords.add(new TransactionRecord(900, 82.17));  
      transactionRecords.add(new TransactionRecord(300, 83.89));
      transactionRecords.add(new TransactionRecord(700, 80.78));
      transactionRecords.add(new TransactionRecord(700, 1.53)); 
      
      Transactions transactions = new Transactions();
      
      try (BufferedWriter output = Files.newBufferedWriter(Paths.get("trans.xml"))) {
         for(TransactionRecord t: transactionRecords){
            transactions.getTransactions().add(t);
         }
         JAXB.marshal(transactions, output);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
   }
}