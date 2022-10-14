import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class CarPaymentCalculatorController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private int numOfYears = 1;
    
    @FXML
    private TextField carPriceTextField;

    @FXML
    private TextField downPaymentTextField;

    @FXML
    private TextField fiveYearLoanTextField;

    @FXML
    private TextField fourYearLoanTextField;

    @FXML
    private TextField interestRateTextField;

    @FXML
    private TextField threeYearLoanTextField;

    @FXML
    private TextField twoYearLoanTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
      BigDecimal carPrice = BigDecimal.ZERO;
      BigDecimal downPayment = BigDecimal.ZERO;
      double interestRate = 0.0;
      boolean isValidCarPrice = false;
      boolean isValidDownPayment = false;
      boolean isValidInterest = false;
      
      try {
         carPrice = new BigDecimal(carPriceTextField.getText());
         isValidCarPrice = true;
      }
      catch (NumberFormatException ex) {
         carPriceTextField.setText("Enter a valid price");
         carPriceTextField.selectAll();
         carPriceTextField.requestFocus(); 
      }
      
      try {
         downPayment = new BigDecimal(downPaymentTextField.getText());
         isValidDownPayment = true;
      }
      catch (NumberFormatException ex) {
         downPaymentTextField.setText("Enter a valid down payment");
         downPaymentTextField.selectAll();
         downPaymentTextField.requestFocus(); 
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
      
      if(isValidCarPrice && isValidDownPayment && isValidInterest){
         BigDecimal loanAmount = carPrice.subtract(downPayment);
         BigDecimal twoYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, 2);
         BigDecimal threeYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, 3);
         BigDecimal fourYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, 4);
         BigDecimal fiveYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, 5);
   
         twoYearLoanTextField.setText(currency.format(twoYearMonthlyPayment));
         threeYearLoanTextField.setText(currency.format(threeYearMonthlyPayment));
         fourYearLoanTextField.setText(currency.format(fourYearMonthlyPayment));
         fiveYearLoanTextField.setText(currency.format(fiveYearMonthlyPayment));
      }
    }
    
    //https://www.wallstreetmojo.com/mortgage-formula/
    private BigDecimal computeMonthyPayment(BigDecimal loanAmount, double interestRate, int numOfYears){
      double r = interestRate/12;
      int n = numOfYears * 12;
      double numerator = r * Math.pow((1 + r), n);
      double denominator = Math.pow(1 + r, n) - 1;
      return loanAmount.multiply(new BigDecimal(numerator/denominator));
    }
    
    public void initialize(){
      currency.setRoundingMode(RoundingMode.HALF_UP);
   }
}
