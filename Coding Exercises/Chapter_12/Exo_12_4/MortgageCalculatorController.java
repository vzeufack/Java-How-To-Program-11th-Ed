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

public class MortgageCalculatorController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private int numOfYears = 1;
    
    @FXML
    private Label customYearLabel;

    @FXML
    private Label customYearLoanLabel;

    @FXML
    private TextField customYearLoanTextField;

    @FXML
    private Slider customYearSlider;

    @FXML
    private TextField downPaymentTextField;

    @FXML
    private TextField interestRateTextField;

    @FXML
    private TextField loanAmountTextField;

    @FXML
    private TextField purchagePriceTextField;

    @FXML
    private TextField tenYearLoanTextField;

    @FXML
    private TextField thirtyYearLoanTextField;

    @FXML
    private TextField twentyYearLoanTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
      BigDecimal purchasePrice = BigDecimal.ZERO;
      BigDecimal downPayment = BigDecimal.ZERO;
      double interestRate = 0.0;
      boolean isValidPurchasePrice = false;
      boolean isValidDownPayment = false;
      boolean isValidInterest = false;
      
      try {
         purchasePrice = new BigDecimal(purchagePriceTextField.getText());
         isValidPurchasePrice = true;
      }
      catch (NumberFormatException ex) {
         purchagePriceTextField.setText("Enter a valid price");
         purchagePriceTextField.selectAll();
         purchagePriceTextField.requestFocus(); 
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
      
      if(isValidPurchasePrice && isValidDownPayment && isValidInterest){
         BigDecimal loanAmount = purchasePrice.subtract(downPayment);
         BigDecimal tenYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, 10);
         BigDecimal twentyYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, 20);
         BigDecimal thirtyYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, 30);
         BigDecimal customYearMonthlyPayment = computeMonthyPayment(loanAmount, interestRate, numOfYears);
   
         loanAmountTextField.setText(currency.format(loanAmount));
         tenYearLoanTextField.setText(currency.format(tenYearMonthlyPayment));
         twentyYearLoanTextField.setText(currency.format(twentyYearMonthlyPayment));
         thirtyYearLoanTextField.setText(currency.format(thirtyYearMonthlyPayment));
         customYearLoanTextField.setText(currency.format(customYearMonthlyPayment));
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
      
      // listener for changes to customYearSlider's value
      customYearSlider.valueProperty().addListener(
         new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, 
               Number oldValue, Number newValue) {
               numOfYears = newValue.intValue();
               customYearLabel.setText(numOfYears + "-year");
            }
         }
      );
   }

}
