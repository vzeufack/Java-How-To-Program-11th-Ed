import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;


public class CollegeLoanPayoffController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    @FXML
    private TextField interestRateTextField;
   
    @FXML
    private TextField loanAmountTextField;
   
    @FXML
    private TextField monthlyPayment10YearTextField;
   
    @FXML
    private TextField monthlyPayment15YearTextField;
   
    @FXML
    private TextField monthlyPayment20YearTextField;
   
    @FXML
    private TextField monthlyPayment25YearTextField;
   
    @FXML
    private TextField monthlyPayment30YearTextField;
   
    @FXML
    private TextField monthlyPayment5YearTextField;
   
    @FXML
    void calculateButtonPressed(ActionEvent event) {
      BigDecimal loanAmount = BigDecimal.ZERO;
      double interestRate = 0.0;
      boolean isValidLoanAmount = false;
      boolean isValidInterest = false;
      
      try {
         loanAmount = new BigDecimal(loanAmountTextField.getText());
         isValidLoanAmount = true;
      }
      catch (NumberFormatException ex) {
         loanAmountTextField.setText("Enter a valid amount");
         loanAmountTextField.selectAll();
         loanAmountTextField.requestFocus(); 
      }
      
      try {
         interestRate = Double.parseDouble(interestRateTextField.getText());
         isValidInterest = true;
      }
      catch (NumberFormatException ex) {
         interestRateTextField.setText("Enter a valid interest rate");
         interestRateTextField.selectAll();
         interestRateTextField.requestFocus(); 
      }         
      
      if(isValidLoanAmount && isValidInterest){
         BigDecimal monthlyPayment5Year = computeMonthyPayment(loanAmount, interestRate, 5);
         BigDecimal monthlyPayment10Year = computeMonthyPayment(loanAmount, interestRate, 10);
         BigDecimal monthlyPayment15Year = computeMonthyPayment(loanAmount, interestRate, 15);
         BigDecimal monthlyPayment20Year = computeMonthyPayment(loanAmount, interestRate, 20);
         BigDecimal monthlyPayment25Year = computeMonthyPayment(loanAmount, interestRate, 25);
         BigDecimal monthlyPayment30Year = computeMonthyPayment(loanAmount, interestRate, 30);

         monthlyPayment5YearTextField.setText(currency.format(monthlyPayment5Year));
         monthlyPayment10YearTextField.setText(currency.format(monthlyPayment10Year));
         monthlyPayment15YearTextField.setText(currency.format(monthlyPayment15Year));
         monthlyPayment20YearTextField.setText(currency.format(monthlyPayment20Year));
         monthlyPayment25YearTextField.setText(currency.format(monthlyPayment25Year));
         monthlyPayment30YearTextField.setText(currency.format(monthlyPayment30Year));
      }
    }
    
    public void initialize(){
      currency.setRoundingMode(RoundingMode.HALF_UP);
    }
    
    //https://www.wallstreetmojo.com/mortgage-formula/
    private BigDecimal computeMonthyPayment(BigDecimal loanAmount, double interestRate, int numOfYears){
      double r = interestRate/12;
      int n = numOfYears * 12;
      double numerator = r * Math.pow((1 + r), n);
      double denominator = Math.pow(1 + r, n) - 1;
      return loanAmount.multiply(new BigDecimal(numerator/denominator));
    }
}
