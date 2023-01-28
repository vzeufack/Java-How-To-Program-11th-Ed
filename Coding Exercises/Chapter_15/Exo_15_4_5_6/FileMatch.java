import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.io.BufferedReader;
import java.nio.file.Files;
import javax.xml.bind.JAXB;
import java.util.List;
import java.io.BufferedWriter;

public class FileMatch{
   public static void main(String[] args){
      ArrayList<Account> accounts = readMaster("oldmast.txt");
      List<TransactionRecord> transactions = readTransactionsXML();      
      updateMaster();
   }
   
   public static ArrayList<Account> readMaster(String fileName){
      ArrayList<Account> accounts = new ArrayList<>();
      try(Scanner masterInput = new Scanner(Paths.get(fileName))){
         while(masterInput.hasNext()){
            Account account = new Account(masterInput.nextInt(), masterInput.next(), masterInput.next(), masterInput.nextDouble());
            accounts.add(account);
         }
      }
      catch(IOException | IllegalStateException | NoSuchElementException e){
         e.printStackTrace();
      }
      
      return accounts;
   }
   
   public static List<Account> readMasterXML(String fileName){
      Accounts accounts = new Accounts();
      try(BufferedReader input = Files.newBufferedReader(Paths.get(fileName))){
         accounts = JAXB.unmarshal(input, Accounts.class);
      }
      catch(IOException e){
         System.out.println("Issue reading " + fileName);
      }
      
      return accounts.getAccounts();
   }
   
   private static ArrayList<TransactionRecord> readTransactions(){
      ArrayList<TransactionRecord> transactions = new ArrayList<>();
      try(Scanner inTransaction = new Scanner(Paths.get("trans.txt"))){
         while(inTransaction.hasNext()){
            TransactionRecord transaction = new TransactionRecord(inTransaction.nextInt(), inTransaction.nextDouble());
            transactions.add(transaction);
         }
      }
      catch(IOException | IllegalStateException | NoSuchElementException e){
         e.printStackTrace();
      }
      
      return transactions;
   }
   
   private static List<TransactionRecord> readTransactionsXML(){
      Transactions transactions = new Transactions();
      try(BufferedReader inTransaction = Files.newBufferedReader(Paths.get("trans.xml"))){
         transactions = JAXB.unmarshal(inTransaction, Transactions.class);
      }
      catch(IOException e){
         e.printStackTrace();
      }
      
      return transactions.getTransactions();
   }
   
   public static ArrayList<String> readLogs(){
      ArrayList<String> logs = new ArrayList<>();
      try(Scanner logScanner = new Scanner(Paths.get("log.txt"))){
         while(logScanner.hasNext()){
            logs.add(logScanner.nextLine());
         }
      }
      catch(IOException | IllegalStateException | NoSuchElementException e){
         e.printStackTrace();
      }
      
      return logs;
   }
   
   private static void writeLogs(ArrayList<Integer> matchedAccountNumbers, List<TransactionRecord> transactions){
      try (Formatter output = new Formatter("log.txt")) {
         for(TransactionRecord t: transactions){
            if(!matchedAccountNumbers.contains(t.getAccountNumber())){
               output.format("Unmatched transaction record for account number %d%n", t.getAccountNumber());
            }
         }    
      }
      catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
      
   public static void updateMaster(){
      List<Account> accounts = readMaster("oldmast.txt");
      List<TransactionRecord> transactions = readTransactions();
      ArrayList<Integer> matchedAccountNumbers = new ArrayList<>();
      
      try (Formatter output = new Formatter("newmast.txt")) {
         for(Account account: accounts){            
            for(TransactionRecord t: transactions){
               if(account.getAccountNumber() == t.getAccountNumber()){
                  account.combine(t);
                  matchedAccountNumbers.add(account.getAccountNumber());
               }
            }
            
            output.format("%d %s %s %.2f%n", account.getAccountNumber(),  
                          account.getFirstName(), account.getLastName(), account.getBalance());
         }
      }
      catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
         e.printStackTrace();
         System.exit(1);
      }
      
      writeLogs(matchedAccountNumbers, transactions);
   }
   
   
   
   public static void updateMasterXML(){
      List<Account> accounts = readMasterXML("oldmast.xml");
      List<TransactionRecord> transactions = readTransactionsXML();
      ArrayList<Integer> matchedAccountNumbers = new ArrayList<>();
      
      Accounts newAccounts = new Accounts();
      try (BufferedWriter output = Files.newBufferedWriter(Paths.get("newmast.xml"))) {
         for(Account account: accounts){            
            for(TransactionRecord t: transactions){
               if(account.getAccountNumber() == t.getAccountNumber()){
                  account.combine(t);
                  matchedAccountNumbers.add(account.getAccountNumber());
               }
            }
            newAccounts.getAccounts().add(account);
         }
         JAXB.marshal(newAccounts, output);
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      
      writeLogs(matchedAccountNumbers, transactions);
   }
}