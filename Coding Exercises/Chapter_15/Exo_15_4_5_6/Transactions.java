import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Transactions{
   @XmlElement(name="transaction")
   private List<TransactionRecord> transactions = new ArrayList<>();
      
   public List<TransactionRecord> getTransactions(){ return transactions; }
}