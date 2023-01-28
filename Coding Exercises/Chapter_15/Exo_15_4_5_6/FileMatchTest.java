import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FileMatchTest {
   @Test public void updateNewMasterXMLTest() {      
      ArrayList<Account> accountsExpected = new ArrayList<>();
      accountsExpected.add(new Account(100, "Alan", "Jones", 375.31));
      accountsExpected.add(new Account(300, "Mary", "Smith", 173.19));
      accountsExpected.add(new Account(500, "Sam", "Sharp", 0.00));
      accountsExpected.add(new Account(700, "Suzy", "Green", 68.09));
      
      CreateXMLTestData.main(new String[0]);      
      FileMatch.updateMasterXML();
      List<Account> actualAccounts = FileMatch.readMasterXML("newmast.xml");
      Assert.assertEquals(accountsExpected, actualAccounts);
      
      ArrayList<String> expectedLogs = new ArrayList<String>();
      expectedLogs.add("Unmatched transaction record for account number 400");
      expectedLogs.add("Unmatched transaction record for account number 900");
      ArrayList<String> actualLogs = FileMatch.readLogs();
      Assert.assertEquals(expectedLogs, actualLogs);
   }
   
   @Test public void updateNewMasterTest() {      
      ArrayList<Account> accountsExpected = new ArrayList<>();
      accountsExpected.add(new Account(100, "Alan", "Jones", 375.31));
      accountsExpected.add(new Account(300, "Mary", "Smith", 173.19));
      accountsExpected.add(new Account(500, "Sam", "Sharp", 0.00));
      accountsExpected.add(new Account(700, "Suzy", "Green", 68.09));
      
      CreateTestData.main(new String[0]);      
      FileMatch.updateMaster();
      ArrayList<Account> actualAccounts = FileMatch.readMaster("newmast.txt");
      Assert.assertEquals(accountsExpected, actualAccounts);
      
      ArrayList<String> expectedLogs = new ArrayList<String>();
      expectedLogs.add("Unmatched transaction record for account number 400");
      expectedLogs.add("Unmatched transaction record for account number 900");
      ArrayList<String> actualLogs = FileMatch.readLogs();
      Assert.assertEquals(expectedLogs, actualLogs);
   }
}
